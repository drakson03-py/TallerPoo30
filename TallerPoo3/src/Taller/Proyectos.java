package Taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Proyectos {
	
	private String id;
	private String nombre;
	private String responsable;
	private List<Tareas>listaTareas;
	
	public Proyectos(String id,String nombre,String responsable) throws FileNotFoundException {
		
		listaTareas = new ArrayList<>();
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
		
		File t = new File("Archivos/tareas.txt");
		Scanner lector = new Scanner(t);
		
		while(lector.hasNextLine()) {
			String linea = lector.nextLine();
			String parte[] = linea.split("\\|");
			
			
			
			if(parte[0].equals(this.id)) {
				Tareas ta = new Tareas(parte[0], parte[1], parte[2], parte[3], parte[4], parte[5], parte[6], parte[7]);
				listaTareas.add(ta);
			}
		}
		lector.close();
	}

	
	public String getId() {return this.id;}
	public String getNombre() {return this.nombre;}
	public String getResponsable() {return this.responsable;}	
	public void getTareas() {for(Tareas b:listaTareas) { System.out.println(b);} }
	public String toString() {
	    return "id: " + this.id + "\n"
	         + "nombre: " + this.nombre + "\n"
	         + "responsable: " + this.responsable + "\n"
	         + "tareas: " + listaTareas.size();
	}
}
