/*  Copyright 2019 Francisco Dominguez Lerma
 	Author: Francisco Dominguez Lerma
  
    This file is part of PokeJava.

    PokeJava is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 2 of the License, or
    (at your option) any later version.

    PokeJava is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with PokeJava.  If not, see <https://www.gnu.org/licenses/>.*/

import java.util.Scanner;
import java.util.Random;

public class Pokejava{

	public static void main(String[] args){
	    Scanner sc;
	    Pokemon pokemon1=null;
	    Pokemon pokemon2=null;
	    boolean turno=false;

	    try {
	    if(args[0].equals("--help")){
	      System.out.println("Como usar pokejava:");
	      System.out.println("Pokejava necesita dos ficheros pkm para obtener las propiedades de cada pokemon, ejemplo:");
	      System.out.println("");
	      System.out.println("java Pokejava pikachu.pkm infernape.pkm");
		  System.exit(0);
	    }
 
	     //Creamos los objetos pokemon
	     pokemon1=Ficheros.cargarFichero(args[0]);
	     pokemon2=Ficheros.cargarFichero(args[1]);
	    } catch(ArrayIndexOutOfBoundsException | NullPointerException ex2) {
	    	System.out.println("Debes pasar como argumentos dos ficheros pkm, ejemplo:");
	    	System.out.println("");
	    	System.out.println("java Pokejava pikachu.pkm infernape.pkm");
	    	System.exit(1);
	    }
	
	    sc = new Scanner(System.in);
	    String orden;
	
	    System.out.println("Bienvenido a PokeJava!!");
	
	    while(pokemon1.getPv()>0 && pokemon2.getPv()>0) {
	    
	      if(!turno) {
	    	  System.out.println("");
	    	  if(pokemon1.getEstado().equals("")) {
	    		  System.out.print("[pv:"+pokemon1.getPv()+"]["+pokemon1.getNombre()+"] --> ");
	    	  } else {
	    		  System.out.print("[pv:"+pokemon1.getPv()+"]["+pokemon1.getEstado()+"]["+pokemon1.getNombre()+"] --> ");
	    	  }
	      }
	      else {
	    	  System.out.println("");
	    	  if(pokemon2.getEstado().equals("")) {
	    		  System.out.print("[pv:"+pokemon2.getPv()+"]["+pokemon2.getNombre()+"] --> ");
	    	  } else {
	    		  System.out.print("[pv:"+pokemon2.getPv()+"]["+pokemon2.getEstado()+"]["+pokemon2.getNombre()+"] --> ");
	    	  }
	    	  
	    }
	      
	      orden=sc.next();
	
	      //Gestionamos los comandos, también gestionamos el turno cambiando el valor del booleano turno
	      switch(orden){
	        case "atacar":
	          if(!turno) pokemon1.atacar(pokemon2);
	          else pokemon2.atacar(pokemon1);
	          turno=!turno;
	          break;
	       case "pocion":
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
	          System.out.println("\n---- AYUDA -----");
	          System.out.println("atacar\t permite atacar al pokemon enemigo");
	          System.out.println("pocion\t utiliza la pocion para curar a tu pokemon");
	          System.out.println("antidoto\t utiliza el antidoto para restablecer el estado del pokemon");
	          System.out.println("informacion\t muestra toda la informacion de la partida, pv, pv enemigo etc...");
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
	    
	    if(pokemon1.getPv()>0) 
	    	System.out.println("\n--- El pokemon "+pokemon1.getNombre()+" ha ganado la partida ---");
	    
	    else if(pokemon2.getPv()>0)
	    	System.out.println("\n--- El pokemon "+pokemon2.getNombre()+" ha ganado la partida ---");
	    
	
	    }

    }

  
