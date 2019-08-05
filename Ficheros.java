
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Ficheros {

	public static Pokemon cargarFichero(String pokemon){

		Properties prop = new Properties();
		InputStream is = null;

		// Atributos de pokemon
		String nombrePokemon = new String();
		int pociones = 0;
		int antidotos = 0;
		Ataque[] ataques = new Ataque[4];

		// Atributos de ataques
		String[] nombreAtaque = new String[4];
		String[] estadoAtaque = new String[4];
		int[] pp = new int[4];
		int[] pdMax = new int[4];
		int[] pdMin = new int[4];

		Pokemon miPokemon;

		//Abrimos el fichero

		try {
			is = new FileInputStream(pokemon);
			prop.load(is);
		} catch (IOException e1) {
			System.out.println("Error abriendo fichero " + pokemon);
			e1.printStackTrace();
			System.exit(1);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				System.out.println("Error cerrando fichero " + pokemon);
				e.printStackTrace();
				System.exit(1);
			}
		}

		nombrePokemon = prop.getProperty("nombre");

		pociones = Integer.parseInt(prop.getProperty("pociones"));

		antidotos = Integer.parseInt(prop.getProperty("antidotos"));

		nombreAtaque[0]=prop.getProperty("ataque1_nombre");
		nombreAtaque[1]=prop.getProperty("ataque2_nombre");
		nombreAtaque[2]=prop.getProperty("ataque3_nombre");
		nombreAtaque[3]=prop.getProperty("ataque4_nombre");

		estadoAtaque[0]=prop.getProperty("ataque1_estado");
		estadoAtaque[1]=prop.getProperty("ataque2_estado");
		estadoAtaque[2]=prop.getProperty("ataque3_estado");
		estadoAtaque[3]=prop.getProperty("ataque4_estado");

		pp[0]=Integer.parseInt(prop.getProperty("ataque1_pp"));
		pp[1]=Integer.parseInt(prop.getProperty("ataque2_pp"));
		pp[2]=Integer.parseInt(prop.getProperty("ataque3_pp"));
		pp[3]=Integer.parseInt(prop.getProperty("ataque4_pp"));

		pdMax[0]=Integer.parseInt(prop.getProperty("ataque1_pdMax"));
		pdMax[1]=Integer.parseInt(prop.getProperty("ataque2_pdMax"));
		pdMax[2]=Integer.parseInt(prop.getProperty("ataque3_pdMax"));
		pdMax[3]=Integer.parseInt(prop.getProperty("ataque4_pdMax"));

		pdMin[0]=Integer.parseInt(prop.getProperty("ataque1_pdMin"));
		pdMin[1]=Integer.parseInt(prop.getProperty("ataque2_pdMin"));
		pdMin[2]=Integer.parseInt(prop.getProperty("ataque3_pdMin"));
		pdMin[3]=Integer.parseInt(prop.getProperty("ataque4_pdMin"));


		// Creamos los ataques

		ataques[0] = new Ataque(nombreAtaque[0], pp[0], pdMax[0], pdMin[0], estadoAtaque[0]);
		ataques[1] = new Ataque(nombreAtaque[1], pp[1], pdMax[1], pdMin[1], estadoAtaque[1]);
		ataques[2] = new Ataque(nombreAtaque[2], pp[2], pdMax[2], pdMin[2], estadoAtaque[2]);
		ataques[3] = new Ataque(nombreAtaque[3], pp[3], pdMax[3], pdMin[3], estadoAtaque[3]);

		// Devuelve un pokemon completamente creado
		miPokemon = new Pokemon(nombrePokemon, pociones, antidotos, ataques);

		return miPokemon;

	}
}
