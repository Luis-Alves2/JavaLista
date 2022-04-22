class texto {
   private String texto;

   public texto(String texto) {
      this.texto = texto;
   }

   public void printAllTexto(){
	System.out.println(this.texto);
	
   }

   public int countAllPalavras(){
	if(texto.length() == 0){
		return 0;
	}
	int palavras = 1;
	boolean palavra = false;
	char[] vetordechar = texto.toCharArray();
	
	for(int i = 0; i < vetordechar.length; i++){
	    	if(Character.isLetter(vetordechar[i])){
			palavra = true;
		}else if(!Character.isLetter(vetordechar[i]) && palavra == true){
			palavras++;
			palavra = false;
		}
	}
	
	return palavras;
   }

   public int howManySubStrings(String sub){       
        int substringsize = sub.length();         
        int textao = this.texto.length();         
        int total = 0; 
	int j=0;
  
        for (int i = 0; i <= textao - substringsize; i++) {              
            for (j = 0; j < substringsize; j++) { 
                if (this.texto.charAt(i + j) != sub.charAt(j)) { 
                    break; 
                } 
            }   
            if (j == substringsize) {                 
                total++;                 
                j = 0;                 
            }             
        }         
        return total;
   }

   public String findAndReplace(String alvo, String substituto){

	int substringsize = alvo.length();      
        int total = 0;
	int indexinicial=0;
	boolean palavra = false;
	String tmp;
	int j;

	for (int i = 0; i <= this.texto.length() - substringsize; i++) {              
            for (j = 0; j < substringsize; j++) {
                if (this.texto.charAt(i + j) != alvo.charAt(j)) {
                    break; 
                }
		if(j == substringsize-1){
		    indexinicial = i;
		}
            }   
            if (j == substringsize) {
		if(indexinicial == 0){
			palavra = isFullWord(indexinicial, substringsize, false);
		}else{
			palavra = isFullWord(indexinicial-1, substringsize, true);
		}
		if(palavra == true){
		   tmp = replaceWord(indexinicial, substituto, substringsize);
		   this.texto = tmp;
		}
		j = 0;      
            }             
        }
	return this.texto;         
   }

   public String replaceWord(int indexinicial, String substituto, int sizetodelete){
	String tmp;
	tmp = insertWord(indexinicial, substituto);
	this.texto = tmp;

	int indexdelete = indexinicial + substituto.length();
	tmp = deleteAt(indexdelete , sizetodelete);
	this.texto = tmp;

	return this.texto;
   }
   
   public String insertWord(int indexinicial, String palavra){

	char[] vetordechar = this.texto.toCharArray();

	char[] newtexto = new char[this.texto.length() + palavra.length()];

	char[] newpalavra = palavra.toCharArray();

	for(int i = 0; i < indexinicial ; i++){
	   newtexto[i] = vetordechar[i];
	}

	for(int i = 0; i< palavra.length();i++){
	   newtexto[i+indexinicial] = newpalavra[i];
	}

	for(int i = indexinicial; i < this.texto.length();i++){
	   newtexto[i+palavra.length()] = vetordechar[i];
	}

	String newertexto = new String(newtexto);

	this.texto = newertexto;
	return this.texto;
   }

   public String deleteAt(int indexinicial,int tam){

	char[] vetordechar = this.texto.toCharArray();
	char[] newtexto = new char[this.texto.length() - tam];

	for(int i = 0; i< indexinicial;i++){
		newtexto[i] = vetordechar[i];
	}

	for(int i = indexinicial+tam; i< this.texto.length();i++){
		newtexto[i-tam] = vetordechar[i];
	}

	String newertexto = new String(newtexto);
	this.texto = newertexto;

	return this.texto;  
   }

   public boolean isFullWord(int inicio,int tam, boolean flag){

	char[] vetordechar = this.texto.toCharArray();
	int tamanhopalavra = 0;

	if(flag == true){
	   if(Character.isLetter(vetordechar[inicio])){
		return false;
	   }
	   inicio++;
	}

	while(inicio < this.texto.length() && Character.isLetter(vetordechar[inicio])){
		tamanhopalavra++;
		inicio++;
	}

	if(tam == tamanhopalavra){
	   return true;
	}else{
	   return false;	
	}

   }

}


public class Q2 {
  public static void main(String[] args) {
	texto lorem = new texto("adipiscing incididunt einm minim picuin inbimbimin bolota");
	lorem.printAllTexto();
	System.out.println(lorem.countAllPalavras());
	System.out.println(lorem.howManySubStrings("in"));
	System.out.println(lorem.findAndReplace("bolota","IN"));
  }
}