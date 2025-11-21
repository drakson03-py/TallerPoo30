package Taller;

public class Tareas {
	
	private String proyecto;
	private String id;
	private String tipo;
	private String descrip;
	private String estado;
	private String responsable;
	private String complejidad;
	private String fecha;
	
	public Tareas(String proyecto, String id, String tipo, String descrip, String estado, String responsable, String complejidad, String fecha) {
	    this.proyecto = proyecto;
	    this.id = id;
	    this.tipo = tipo;
	    this.descrip = descrip;
	    this.estado = estado;
	    this.responsable = responsable;
	    this.complejidad = complejidad;
	    this.fecha = fecha;
	}

	
	public String toString() {
	    return "============\n"+"proyecto: " + this.proyecto + "\n"
	         + "id: " + this.id + "\n"
	         + "tipo: " + this.tipo + "\n"
	         + "descrip: " + this.descrip + "\n"
	         + "estado: " + this.estado + "\n"
	         + "responsable: " + this.responsable + "\n"
	         + "complejidad: " + this.complejidad + "\n"
	         + "fecha: " + this.fecha;
	}
}
