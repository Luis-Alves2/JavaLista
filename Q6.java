interface Expression { 
      
    String avaliar(String expr); 
    String imprimirArvore(String expr);
} 

class ExprAritmetica implements Expression {
   
   public String avaliar(String expr){
	char[] exprate = new char[expr.length()];
	char[] exprpos = new char[expr.length()];
	Double tmp1 = 0.0;
	Double tmp2 = 0.0;
	Double tmp = 0.0;
	String acabou = expr;

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '+'){
		for(int j = 0; j < i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+1; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		} 
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		tmp = (tmp1 + tmp2);
		acabou = String.valueOf(tmp);
		return acabou;
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
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		tmp = (tmp1 - tmp2);
		acabou = String.valueOf(tmp);
		return acabou;
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
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		tmp = (tmp1 * tmp2);
		acabou = String.valueOf(tmp);
		return acabou;
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
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		tmp = (tmp1 / tmp2);
		acabou = String.valueOf(tmp);
		return acabou;
           }
	}

	tmp = Double.valueOf(expr);
	return expr;
	
   }

   public String ToString(char[] viraString){
	String tmp = new String(viraString);
	return tmp;
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
		tmp = '('+ tmp1 + '*' + tmp2 + ')' ;
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
	tmp = '('+expr+')';
	return tmp;
	
   }
}

class ExprLogica implements Expression {

   public String avaliar(String expr){
	char[] exprate = new char[expr.length()];
	char[] exprpos = new char[expr.length()];
	Double tmp1 = 0.0;
	Double tmp2 = 0.0;
	Double tmp = 0.0;
	String acabou = expr;
	int flag = 0;

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '>'){
		if(expr.charAt(i+1) == '='){
			flag = 1;
		}
		if(flag == 1){
		   for(int j = 0; j < i;j++){
		   	exprate[j] = expr.charAt(j);
	 	   }
		   for(int j= i+2; j< expr.length();j++){
		   	exprpos[j] = expr.charAt(j);
		   } 
		   tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		   tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		   if(tmp1 >= tmp2){
		   	return "True";
		   }else{
		   	return "False";
		   }
		}else{
		   for(int j = 0; j < i;j++){
			exprate[j] = expr.charAt(j);
		   }
		   for(int j= i+1; j< expr.length();j++){
		   	exprpos[j] = expr.charAt(j);
		   } 
		   tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		   tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		   if(tmp1 > tmp2){
			return "True";
	       	   }else{
			return "False";
		   }
		}			
           }
	}

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '<'){
		if(expr.charAt(i+1) == '='){
			flag = 1;
		}
		if(flag == 1){
		   for(int j = 0; j < i;j++){
		   	exprate[j] = expr.charAt(j);
	 	   }
		   for(int j= i+2; j< expr.length();j++){
		   	exprpos[j] = expr.charAt(j);
		   } 
		   tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		   tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		   if(tmp1 <= tmp2){
		   	return "True";
		   }else{
		   	return "False";
		   }
		}else{
		   for(int j = 0; j < i;j++){
			exprate[j] = expr.charAt(j);
		   }
		   for(int j= i+1; j< expr.length();j++){
		   	exprpos[j] = expr.charAt(j);
		   } 
		   tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		   tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		   if(tmp1 < tmp2){
			return "True";
	       	   }else{
			return "False";
		   }
		}
           }
	}

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '!'){
		for(int j = 0; j < i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+2; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		} 
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		if(tmp1 != tmp2){
		   return "True";
		}else{
		   return "False";
		}
           }
	}

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '=' && expr.charAt(i+1) == '='){
		for(int j = 0; j < i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+2; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		} 
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		if(tmp1 <= tmp2 && tmp1 >= tmp2){
		   return "True";
		}else{
		   return "False";
		}
       }
	}


	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '+'){
		for(int j = 0; j < i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+1; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		} 
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		tmp = (tmp1 + tmp2);
		acabou = String.valueOf(tmp);
		return acabou;
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
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		tmp = (tmp1 - tmp2);
		acabou = String.valueOf(tmp);
		return acabou;
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
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		tmp = (tmp1 * tmp2);
		acabou = String.valueOf(tmp);
		return acabou;
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
		tmp1 = Double.valueOf(avaliar(ToString(exprate)));
		tmp2 = Double.valueOf(avaliar(ToString(exprpos)));
		tmp = (tmp1 / tmp2);
		acabou = String.valueOf(tmp);
		return acabou;
           }
	}

	tmp = Double.valueOf(expr);
	return expr;
	
   }

   public String ToString(char[] viraString){
	String tmp = new String(viraString);
	return tmp;
   }

   public String imprimirArvore(String expr){
    char[] exprate = new char[expr.length()];
	char[] exprpos = new char[expr.length()];
	String tmp1 = expr;
	String tmp2 = expr;
	String tmp = expr;
	int flag = 0;
       
    for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '>'){
		if(expr.charAt(i+1) == '='){
			flag = 1;
		}
		if(flag == 1){
		   for(int j = 0; j < i;j++){
		   	exprate[j] = expr.charAt(j);
	 	   }
		   for(int j= i+2; j< expr.length();j++){
		   	exprpos[j] = expr.charAt(j);
		   } 
		   tmp1 = imprimirArvore(ToString(exprate));
		   tmp2 = imprimirArvore(ToString(exprpos));
		   tmp = '(' + tmp1 + ">=" + tmp2 + ')';
		   return tmp;
		}else{
		   for(int j = 0; j < i;j++){
			exprate[j] = expr.charAt(j);
		   }
		   for(int j= i+1; j< expr.length();j++){
		   	exprpos[j] = expr.charAt(j);
		   } 
		   tmp1 = imprimirArvore(ToString(exprate));
		   tmp2 = imprimirArvore(ToString(exprpos));
		   tmp = '(' + tmp1 + '>' + tmp2 + ')';
		   return tmp;
		   }
		}
      }

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '<'){
		if(expr.charAt(i+1) == '='){
			flag = 1;
		}
		if(flag == 1){
		   for(int j = 0; j < i;j++){
		   	exprate[j] = expr.charAt(j);
	 	   }
		   for(int j= i+2; j< expr.length();j++){
		   	exprpos[j] = expr.charAt(j);
		   } 
		   tmp1 = imprimirArvore(ToString(exprate));
		   tmp2 = imprimirArvore(ToString(exprpos));
		   tmp = '(' + tmp1 + "<=" + tmp2 + ')';
		   return tmp;
		}else{
		   for(int j = 0; j < i;j++){
			exprate[j] = expr.charAt(j);
		   }
		   for(int j= i+1; j< expr.length();j++){
		   	exprpos[j] = expr.charAt(j);
		   } 
		   tmp1 = imprimirArvore(ToString(exprate));
		   tmp2 = imprimirArvore(ToString(exprpos));
		   tmp = '(' + tmp1 + '<' + tmp2 + ')';
		   return tmp;
		}
           }
	}

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '!'){
		for(int j = 0; j < i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+2; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		} 
		tmp1 = imprimirArvore(ToString(exprate));
		tmp2 = imprimirArvore(ToString(exprpos));
		tmp = '(' + tmp1 + "!=" + tmp2 + ')';
		return tmp;
       }
	}

	for(int i = expr.length()-1; i >= 0; i--){
	   if(expr.charAt(i) == '=' && expr.charAt(i+1) == '='){
		for(int j = 0; j < i;j++){
		   exprate[j] = expr.charAt(j);
		}
		for(int j= i+2; j< expr.length();j++){
		   exprpos[j] = expr.charAt(j);
		} 
		tmp1 = imprimirArvore(ToString(exprate));
		tmp2 = imprimirArvore(ToString(exprpos));
		tmp = '(' + tmp1 + "==" + tmp2 + ')';
		return tmp;
       }
	}

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
		tmp = '('+ tmp1 + '*' + tmp2 + ')' ;
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
    
	tmp = '('+expr+')';
	return tmp;
	
   }
}

public class Q6 {
  public static void main(String[] args) {
	ExprAritmetica expressaozinha = new ExprAritmetica();
	ExprLogica expressaozinho = new ExprLogica();
	System.out.println("ao chamar imprimirArvore: " + expressaozinha.imprimirArvore("2*3+4/6/6*4"));
	System.out.println("ao chamar avaliar: " + expressaozinha.avaliar("2*3+4/6/6*4"));
	System.out.println("ao chamar imprimirArvore: " + expressaozinho.imprimirArvore("2+5/10<12+16"));
	System.out.println("ao chamar avaliar: " + expressaozinho.avaliar("2+5/10<12+16"));
  }
}