package Taller;

import java.util.ArrayList;
import java.util.List;

public class Proyectos {
	
	private String id;
	private String nombre;
	private String responsable;
	private List<Tareas>listaTareas;
	
	public Proyectos(String id,String nombre,String responsable) {
		
		listaTareas = new ArrayList<>();
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
	}

}
