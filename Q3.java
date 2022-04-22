enum Gender {
    cisgenero,
    transgenero,
    generofluido,
    naobinario};

class Pessoa {
   protected Gender identidade;
   protected String nome;
   protected int idade;
   protected String graudeescolaridade;
   protected String Orisexual;
   protected char Biosexo;

   public Pessoa() {
   }

   public Pessoa(String nome, int idade, String graudeescolaridade, Gender identidade, String Orisexual, char Biosexo) {
	this.nome = nome;
	this.idade = idade;
	this.graudeescolaridade = graudeescolaridade;
	this.identidade = identidade;
	this.Orisexual = Orisexual;
	this.Biosexo = Biosexo;
   }
   public Gender getGenderidentidade(){
	return this.identidade;
   }


   public String getNome(){
	return this.nome;
   }

   public int getIdade(){
	return this.idade;
   }

   public String getGraudeEscolaridade(){
	return this.graudeescolaridade;
   }

   public String getOrientacaoSexual(){
	return this.Orisexual;
   }

   public char getSexoBiologico(){
	return this.Biosexo;
   }

   public void setIdade(int novaidade){
	this.idade = novaidade;
   }

   public void setNome(String novoNome){
	this.nome = novoNome;
   }

   public void setGraudeEscolaridade(String novoGrau){
	this.graudeescolaridade = novoGrau;
   }

   public void dormir(){
	System.out.println("Dormindo.");
   }

   public void cagar(){
	System.out.println("Cagando..");
   }

   public void comer(){
	System.out.println("Comendo!");
   }

   public void viver(){
	System.out.println("Vivendo :D");
   }

   public void sobreviver(){
	System.out.println("Sobrevivendo :/");
   }

   public void trabalhar(){
	System.out.println("Trabalhando >:(");
   }
}

public class Q3 {
  public static void main(String[] args) {
	Gender identidade = Gender.naobinario;
	Pessoa serumano = new Pessoa("joca",91,"Ensino Médio Completo",identidade,"pansexual",'M');
	serumano.trabalhar();
  }
}