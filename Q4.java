class Senha {
   protected String senhaalfabetica;
   protected int senhanumerica;

   public Senha(String senhaalfabetica, int senhanumerica){
	this.senhaalfabetica = senhaalfabetica;
	this.senhanumerica = senhanumerica;
   }

   public String getSenhaAlfabetica(){
	return this.senhaalfabetica;
   }

   public int getSenhaNumerica(){
	return this.senhanumerica;
   }

   public void setSenhaAlfabetica(String novasenha){
	this.senhaalfabetica = novasenha;
   }

   public void setSenhaNumerica(int novasenha){
	this.senhanumerica = novasenha;
   }

}

class Conta {
   protected String idnumero;
   protected int agencia;
   protected Senha senhadaconta;

   public Conta(String idnumero, int agencia, Senha senhadaconta){
	this.idnumero = idnumero;
	this.agencia = agencia;
	this.senhadaconta = senhadaconta;
   }

   public String getIdNumero(){
	return this.idnumero;
   }

   public void setIdNumero(String novoid){
	this.idnumero = novoid;
   }

   public int getAgencia(){
	return this.agencia;
   }

   public void setAgencia(int novagencia){
	this.agencia = novagencia;
   }

   public Senha getSenha(){
	return this.senhadaconta;
   }

   public void setSenha(Senha newSenha){
	this.senhadaconta = newSenha;
   }
   
}

public class Q4 {
  public static void main(String[] args) {
	Senha minhasenha = new Senha("A1B2C3",123456);
	Conta continha = new Conta("296",51,minhasenha);
	Senha tmp = continha.getSenha();
	System.out.println(tmp.getSenhaAlfabetica());
	System.out.println(continha.getIdNumero());
	tmp.setSenhaAlfabetica("C3B2A1");
	continha.setSenha(tmp);
	System.out.println(tmp.getSenhaAlfabetica());
  }
}