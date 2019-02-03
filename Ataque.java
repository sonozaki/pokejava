public class Ataque {
	
	String nombre;
	  int pp;
	  
	  int pdMin;
	  int pdMax;

	  String estado;

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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getPdMin() {
		return pdMin;
	}

	public void setPdMin(int pdMin) {
		this.pdMin = pdMin;
	}

	public int getPdMax() {
		return pdMax;
	}

	public void setPdMax(int pdMax) {
		this.pdMax = pdMax;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

  
}
