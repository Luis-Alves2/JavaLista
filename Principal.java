interface Colecao { 
      
    // all are the abstract methods. 
    void inserirP(Pessoa p); 
    String[] tamanhoColecaoNaoNull();
} 

abstract class Pessoa {
   protected String nome;
   protected String cpf;

   public Pessoa(String nome, String cpf){
	this.nome = nome;
	this.cpf = cpf;
   } 

   public String getNome(){
	return this.nome;
   }

   public void setNome(String newname){
	this.nome = newname;
   }

   public String getCpf(){
	return this.cpf;
   }

   public void setCpf(String newcpf){
	this.cpf = newcpf;
   }
}

class Professor extends Pessoa{
   private String formacao;
   private String area;

   public Professor(String formacao, String area, String nome, String cpf){
	super(nome,cpf);
	this.formacao = formacao;
	this.area = area;
   } 
}

class Aluno extends Pessoa{
   private String matricula;
   private String curso;

   public Aluno(String matricula, String curso, String nome, String cpf){
	super(nome,cpf);
	this.matricula = matricula;
	this.curso = curso;
   } 
}

class ColecaoVetor implements Colecao {
   private Pessoa dados[] = new Pessoa[5];
   int numerodevagas = 5;
   
   public void inserirP(Pessoa novapessoa){
	dados[5 - numerodevagas] = novapessoa;
	numerodevagas = numerodevagas-1;
   }
  
   public String[] tamanhoColecaoNaoNull(){
	String listadestring[] = new String[5];
	for(int i = 0; i<(5-numerodevagas);i++){
	   listadestring[i] = dados[i].getNome();
	}
	System.out.println(this.numerodevagas);
	return listadestring;
	
   }
}  

public class Principal {
  public static void main(String[] args) {
	int numberofinserts = 0;
	String listadenomes[] = new String [5];
	ColecaoVetor umacolecao = new ColecaoVetor();
	Pessoa gorge = new Professor("arte","danca","jorge","1123");
	Pessoa morge = new Professor("artes","dancar","forge","2143");
	Pessoa forge = new Professor("artear","pintar","blorge","1925");
	umacolecao.inserirP(gorge);
	listadenomes = umacolecao.tamanhoColecaoNaoNull();
	System.out.println(listadenomes[0]);
	umacolecao.inserirP(morge);
	listadenomes = umacolecao.tamanhoColecaoNaoNull();
	System.out.println(listadenomes[0]);
	System.out.println(listadenomes[1]);
	umacolecao.inserirP(forge);
	listadenomes = umacolecao.tamanhoColecaoNaoNull();
	System.out.println(listadenomes[0]);
	System.out.println(listadenomes[1]);
	System.out.println(listadenomes[2]);
  }
}