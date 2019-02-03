import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Pokemon{
  String nombre;
  int pv;
  int pociones;
  String estado;
  int antidotos;

  Ataque[] ataques;
  Scanner sc=new Scanner(System.in);

  Random aleatorio=new Random(System.currentTimeMillis());  
  
  public Pokemon(String nombre, int pociones,int antidotos, Ataque[] ataques){
	  
	    this.nombre=nombre;
	    this.pv=100;
	    this.pociones=pociones;
	    this.antidotos=antidotos;
	    this.ataques=ataques;
	    
	  //  System.out.println(this.ataques[1].getNombre());

	  }
  
  public String getNombre() {
	return this.nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
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

public void setPociones(int pociones) {
	this.pociones = pociones;
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

public void setAntidotos(int antidotos) {
	this.antidotos = antidotos;
}

public Ataque[] getAtaques() {
	return this.ataques;
}

public void setAtaques(Ataque[] ataques) {
	this.ataques = ataques;
}


  public void recibirDaño(int daño){
    this.pv-=daño;
  }

  public void atacar(Pokemon pokemonEnemigo){
	 
    int index=0;
    int ataqueSeleccionado;
    aleatorio.setSeed(System.currentTimeMillis());

     for(Ataque ataque: ataques){
        System.out.println(index+"- "+ataque.getNombre()+ " pp:"+ataque.getPp());
        index++;
     }
     System.out.print("Elige ataque a usar [0 - 3] --> ");

     ataqueSeleccionado=sc.nextInt();
  
    int daño=aleatorio.nextInt((ataques[ataqueSeleccionado].getPdMax()-ataques[ataqueSeleccionado].getPdMin())+ataques[ataqueSeleccionado].getPdMin());

    pokemonEnemigo.recibirDaño(daño);

    System.out.println("Se ha usado el ataque "+ataques[ataqueSeleccionado].getNombre()+ " producido un daño de "+daño+" al pokemon enemigo");
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
 System.out.println("----- Informacion de la partida -----");
 System.out.println("PV: "+ this.pv);
 System.out.println("Pociones "+ this.pociones);
 System.out.println("Antidotos "+ this.antidotos);

 for(Ataque ataque: ataques){
        System.out.println(ataque.nombre);
        System.out.println("\tpp "+ataque.pp);
        System.out.println("\tpdMax "+ataque.pdMax);
        System.out.println("\tpdMin "+ataque.pdMin);
     }
 }

}
