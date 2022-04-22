abstract class Livro {
   public String nome;
   public int edicao;
   public int ano;

   public Livro(String nome, int edicao, int ano) {
      this.nome = nome;
      this.edicao = edicao;
      this.ano = ano;
   }
}

class LivroLivraria extends Livro {
    public double preco;
   
   public LivroLivraria(String nome, int edicao, int ano, double preco) {
      super(nome, edicao, ano);
      this.preco = preco;
        System.out.println("nome --" + this.nome);
   }
}

class LivroBiblioteca extends Livro {
    public int codigodolivro;
    public boolean foiemprestado;
    public int codigodoemprestador;
   
   public LivroBiblioteca(String nome, int edicao, int ano, int codigodolivro,boolean foiemprestado, int codigodoemprestador) {
      super(nome, edicao, ano);
      this.codigodolivro = codigodolivro;
      if(foiemprestado == true){
          setcodigodoemprestador(codigodoemprestador);
      }
   }
   
   public void setcodigodoemprestador(int codigodoemprestador) {
         this.codigodoemprestador = codigodoemprestador;
   }
}

public class Q1 {
  public static void main(String[] args) {
	LivroLivraria gabi = new LivroLivraria("olivrobrabo",7,2008, 49.90);
  }
}