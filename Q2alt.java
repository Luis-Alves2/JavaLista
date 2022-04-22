class texto {
   private String texto;

   public texto(String texto) {
      this.texto = texto;
   }

   public void printAllTexto(){
	System.out.println(this.texto);
	
   }

   public int countAllPalavras(){
	int palavras = 0;
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
	alvo = "(?i)" + alvo;
	this.texto = this.texto.replaceAll(alvo, substituto);
	return this.texto;
   }
}

public class Q2alt {
  public static void main(String[] args) {
	texto lorem = new texto("porta,portaria");
	lorem.printAllTexto();
	System.out.println(lorem.countAllPalavras());
	System.out.println(lorem.howManySubStrings("porta"));
	System.out.println(lorem.findAndReplace("porta","door"));
  }
}