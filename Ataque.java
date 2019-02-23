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

public class Ataque {
	
	  private String nombre;
	  private int pp;
	  
	  private int pdMin;
	  private int pdMax;

	  private String estado;

	  public Ataque(String nombre, int pp, int pdMax, int pdMin, String estado) {
	    this.nombre=nombre;
	    this.pp=pp;
	    this.pdMax=pdMax;
	    this.pdMin=pdMin;
	    this.estado=estado;
	  }

  public String getNombre() {
		return nombre;
	}

	public int getPp() {
		return pp;
	}

	public int getPdMin() {
		return pdMin;
	}

	public int getPdMax() {
		return pdMax;
	}

	public String getEstado() {
		return estado;
	}
  
}
