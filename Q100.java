interface Expression { 
      
    String avaliar(String expr); 
    String imprimirArvore(String expr);
} 

class ExprAritmetica implements Expression {

   public String ToString(char[] viraString){
	String tmp = new String(viraString);
	return tmp;
   }
   
   public String avaliar(String expr){
       return ("Hello World");
   }
   
   
   public String imprimirArvore(String expr){
	char[] exprate = new char[expr.length()];
	char[] exprpos = new char[expr.length()];
	String tmp1 = expr;
	String tmp2 = expr;
	String tmp = expr;

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '+'){
		for(int j = 0; j < i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+1; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		} 
		
		tmp1 = imprimirArvore(ToString(exprate));
		tmp2 = imprimirArvore(ToString(exprpos));
		tmp = '(' + tmp1 + '+' + tmp2 + ')' ;
		return tmp;
        }
	}

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '-'){
		for(int j = 0; j< i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+1; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		}  
		tmp1 = imprimirArvore(ToString(exprate));
		tmp2 = imprimirArvore(ToString(exprpos));
		tmp = '(' + tmp1 + '-' + tmp2 + ')' ;
		return tmp;
        }
	}
	
	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '*'){
		for(int j = 0; j< i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+1; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		}  
		tmp1 = imprimirArvore(ToString(exprate));
		tmp2 = imprimirArvore(ToString(exprpos));
		tmp = '(' + tmp1 + '*' + tmp2 + ')' ;
		return tmp;
        }
	}

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '/'){
		for(int j = 0; j< i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+1; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		}
		tmp1 = imprimirArvore(ToString(exprate));
		tmp2 = imprimirArvore(ToString(exprpos));
		tmp = ( '(' + tmp1 + '/' + tmp2 + ')' );
		return tmp;
        }
    }
	
	return '(' + expr + ')';
	
   }
}  

public class Q100 {
  public static void main(String[] args) {
	System.out.println("Hello World");
	ExprAritmetica expressaozinha = new ExprAritmetica();
	System.out.println(expressaozinha.imprimirArvore("2*3+4/6"));

  }
}