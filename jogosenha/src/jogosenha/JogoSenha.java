package jogosenha;
import java.util.Scanner;
import java.util.Random;

public class JogoSenha {
	public static void main (String []args) {
	     menu();
	 }
	     public static void menu () {
	     Scanner menu = new Scanner (System.in);


	      System.out.print ("Bem-vindo(a) insira o seu nome para começarmos: ");
	      String nomeusuario = menu.nextLine();
	      System.out.println("Oi "+nomeusuario+" você conhece o jogo da senha?\nCaso já saiba as regras digite 1 se não digite 2: ");
	      int opc = menu.nextInt();
	 
	     switch (opc) {
	     
	     case 1: 
             jogo();
             break;
             
	     case 2:
	          regras();
	          System.out.println ("Caso tenha terminado de ler digite 1.");
	           int confirmacao = menu.nextInt();
	           if (confirmacao == 1 ) {
	               jogo(); 
	               }else {
	            	   System.out.println ("\nChega de palhaçada né. Recomece tudo.");
	            	   menu();
	               }
	               
	     default:
	       System.out.println ("Insira uma entrada válida, 1 para acessar o jogo ou 2 para acessar as regras: ");
	        int entradavalida = menu.nextInt();
	         if (entradavalida == 1 ) {
	             jogo();
	         }else if (entradavalida == 2) {
	        	 regras();
	        	 System.out.println ("Caso tenha terminado de ler digite 1.");
		           confirmacao = menu.nextInt();
		           if (confirmacao == 1 ) {
		               jogo(); 
	         } else {
	        	 System.out.println ("\nChega de palhaçada né. Recomece tudo.");
          	   menu();
	         }
	       break;
	     }}
     
     
}
 public static void regras () {
     System.out.println (" I. O programa vai gerar uma sequência de 4 números de 1 a 6\n "
              + "II. O usuário tem direito a 10 tentativas e  quando forem equivalentes a 0 o jogo sera encerrado.\n"
              + "III. O usuário deve apenas inserir NUMEROS no terminal na forma vertical.\n"
              + "IV. Caso um número seja movimentado entre casas o usuário será notificado.\n"
              + "V. Como prêmio o usuário ganha um ótimo suco de mangaba.\n"
              + "VI. Caso perca o usuário deve a cada membro da equipe um suco de mangaba.\n"
              + "VII. Boa sorte, vai precisar! 🙂 ");
     }

public static void jogo () {
    
	    int contador = 0;
	    Random gerador = new Random();
	    Scanner lerjogo = new Scanner(System.in);
	    int senhacorretaArray[] = new int[4];
	    int senhatentativa[] = new int[4];

	    for (int i = 0; i < 4; i++) {
	        senhacorretaArray[i] = gerador.nextInt(1, 6);
	    }
	    

	    while (contador < 11) {
	        System.out.println("Realize sua tentativa: ");
	        for (int c = 0; c < 4; c++) {
	            senhatentativa[c] = lerjogo.nextInt();
	        }
	        
	        int digitosCorretos = 0;
	        int digitosDeslocados = 0;

	        for (int i = 0; i < 4; i++) {
	            if (senhatentativa[i] == senhacorretaArray[i]) {
	                digitosCorretos++;
	            } else {
	                for (int j = 0; j < 4; j++) {
	                    if (senhatentativa[i] == senhacorretaArray[j]) {
	                        digitosDeslocados++;
	                        break;
	                    }
	                }
	            }
	        }

	        
	        boolean senhaCorreta = true;
	        for (int i = 0; i < 4; i++) {
	            if (senhatentativa[i] != senhacorretaArray[i]) {
	                senhaCorreta = false;
	                break;
	            }
	        }

	        if (senhaCorreta) {
	            System.out.println("Parabéns! Você acertou a senha!");
	            break;
	        } else {
	        	contador++;
	        	if(contador <=10) {
		        System.out.println(contador+ " Tentativa(s), tente novamente" );
	        	}
		        System.out.println("Digitos corretos: "+digitosCorretos);
		        System.out.println("Digitos deslocados: "+digitosDeslocados);


	        }

	        if (contador > 10) {
	            System.out.println("Você perdeu o jogo, suas tentativas acabaram!");
	            System.out.println("A senha é: ");
	            for (int i = 0; i < 4; i++) {
	    	        System.out.println(senhacorretaArray[i]);
	            }
	            break;
	        }
	        
	    }
	    continuarJogo();
}
		public static void continuarJogo() {
	    String continuar;
	    Scanner ler = new Scanner(System.in);
	    System.out.println("Deseja continuar a jogar, sim ou não?: ");
	    continuar = ler.next();
	    if(continuar.equalsIgnoreCase("Sim")) {
	    	jogo();
	    } else if(continuar.equalsIgnoreCase("Não")|| continuar.equals("NAO")) {
	    	System.exit(0);
	    } else {
	    	System.out.println("Opção Inválida, Digite 'Sim ou 'Não': ");
	    	continuarJogo();
	    }
	    
	}}
