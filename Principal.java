import java.util.Scanner;
import java.util.Random;

public class Principal{
  	public static void main(String[] args){

	    boolean turno=false;
	
	    if(args[0].equals("--help")){
	      System.out.println("Mostrando la ayuda");
		  System.exit(0);
	    }
	
	    Pokemon pokemon1=Ficheros.cargarFichero(args[0]);
	    Pokemon pokemon2=Ficheros.cargarFichero(args[1]);
	    
	   System.out.println(pokemon1.getAtaques()[1].getNombre());
	   System.out.println(pokemon2.getAtaques()[1].getNombre());
	
	   Scanner sc = new Scanner(System.in);
	    String orden;
	
	    System.out.println("Bienvenido a PokeJava!!");
		
		
	
	    while(pokemon1.pv>0 && pokemon2.pv>0) {
	    
	      if(!turno) System.out.print("["+pokemon1.getNombre()+"] --> ");
	      else System.out.print("["+pokemon2.getNombre()+"] --> ");
	      orden=sc.next();
	
	      switch(orden){
	        case "atacar":
	          if(!turno) pokemon1.atacar(pokemon2);
	          else pokemon2.atacar(pokemon1);
	          turno=!turno;
	          break;
	       case "curar":
	          if(!turno) pokemon1.curarse();
	          else pokemon2.curarse();
	          turno=!turno;
	          break;
	       case "antidoto":
	          if(!turno) pokemon1.antidoto();
	          else pokemon2.antidoto();
	          turno=!turno;
	          break;
	      case "exit":
	          System.out.println("Se cancelo la partida");
	          System.exit(0);
	          break;
	      case "ayuda":
	          System.out.println("---- AYUDA -----");
	          System.out.println("atacar\t permite atacar al pokemon enemigo");
	          System.out.println("pocion\t utiliza la pocion para curar a tu pokemon");
	          System.out.println("antidoto\t utiliza el antidoto para restablecer el estado del pokemon");
	          System.out.println("exit\t cancela la partida");
	          System.out.println("ayuda\t despliega esta ayuda");
	          break;
	      case "informacion":
	          if(!turno) pokemon1.informacion(pokemon2);
	          else pokemon2.informacion(pokemon1);
	          break;
	      default:
	    	  System.out.println("El comando introducido no es correcto");
	          }
	
	
	      }
	
	    }

    }

  
