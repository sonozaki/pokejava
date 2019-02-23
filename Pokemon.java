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
import java.util.concurrent.ThreadLocalRandom;

public class Pokemon{
  private String nombre;
  private int pv;
  private int pociones;
  private String estado="";
  private int antidotos;
  private int danio;

  Ataque[] ataques;
  Scanner sc=new Scanner(System.in);
  
  public Pokemon(String nombre, int pociones,int antidotos, Ataque[] ataques){
	  
	    this.nombre=nombre;
	    this.pv=100;
	    this.pociones=pociones;
	    this.antidotos=antidotos;
	    this.ataques=ataques;

	  }
  
  public String getNombre() {
	return this.nombre;
}

public int getPv() {
	return this.pv;
}

public void setPv(int pv) {
	this.pv = pv;
}

public int getPociones() {
	return this.pociones;
}

public String getEstado() {
	return this.estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public int getAntidotos() {
	return this.antidotos;
}


  public void recibirDanio(int danio){
    this.setPv(this.getPv()-danio);
  }

  public void atacar(Pokemon pokemonEnemigo){
	 
    int index;
    int ataqueSeleccionado=0;
	
	do {
		index=0;
		//Menu para seleccionar ataque
		 for(Ataque ataque: ataques){
			System.out.println(index+1+" - "+ataque.getNombre()+ " pp:"+ataque.getPp());
			index++;
		 }
		 System.out.print("Elige ataque a usar [1 - 4] --> ");
		 
		 ataqueSeleccionado=sc.nextInt()-1;
		 //Si el ataque no incorrecto
		 if(ataqueSeleccionado<0 || ataqueSeleccionado>3){
		 
		 System.out.println("\nEl ataque introducido no es correcto, vuelve a intentarlo\n");
		 continue;
		 
		 }
	 
	} while(ataqueSeleccionado<0 || ataqueSeleccionado>3);

     
     
     //Si el pokemon está paralizado
     if(!(this.getEstado().equals("")) && ThreadLocalRandom.current().nextInt(1,3)==1) {
    	 System.out.println("El pokemon está en estado "+this.getEstado()+" no se puede mover");
    	 return;
     }
     
     //Calculamos el danio entre el rango del ataque
     try {
    	 danio=ThreadLocalRandom.current().nextInt(ataques[ataqueSeleccionado].getPdMin(), ataques[ataqueSeleccionado].getPdMax() + 1);
     } catch(IllegalArgumentException ex) {
    	 System.out.println("ERROR: pdMax debe ser siempre mayor a pdMin en el fichero .pkm");
    	 System.exit(1);
     }

    pokemonEnemigo.recibirDanio(danio);

    System.out.println("Se ha usado el ataque "+ataques[ataqueSeleccionado].getNombre()+ " produciendo un danio de "+danio+" al pokemon enemigo");
    
    //Si el ataque que hemos usado puede paralizar al enemigo
    if(!(ataques[ataqueSeleccionado].getEstado().equals("\"\"")) && ThreadLocalRandom.current().nextInt(1,3)==1 
    		&& pokemonEnemigo.getEstado().equals("")) {
    	
    	pokemonEnemigo.setEstado(ataques[ataqueSeleccionado].getEstado());
    	System.out.println("El pokemon enemigo pasa al estado "+pokemonEnemigo.getEstado());
    }
    
  }

  public void curarse(){
    if(this.pociones>0){
      this.pv+=75;
      pociones--;
      if(this.pv>100) this.pv=100;
      System.out.println("Pokemon curado");
    } else {
      System.out.println("No tienes pociones");
    }
  }

  public void antidoto(){

    if(this.antidotos>0){
    	this.estado="";
    	this.antidotos--;
    	System.out.println("Pokemon de vuelta a la normalidad");
    } else {
    	System.out.println("No tienes antidotos");
    }
  }
 public void informacion(Pokemon pokemonEnemigo){
	 System.out.println("");
	 System.out.println("----- Informacion de la partida -----");
	 System.out.println("PV: "+ this.getPv());
	 System.out.println("PV Enemigo: "+ pokemonEnemigo.getPv());
	 System.out.println("Pociones: "+ this.getPociones());
	 System.out.println("Antidotos: "+ this.getAntidotos());
	 System.out.println("\nAtaques: \n");
	
	 for(Ataque ataque: ataques){
	        System.out.println("\t"+ataque.getNombre());
	        System.out.println("\t\tpp: "+ataque.getPp());
	        System.out.println("\t\tpdMax: "+ataque.getPdMax());
	        System.out.println("\t\tpdMin: "+ataque.getPdMin()+"\n");
	     }
	 }

}
