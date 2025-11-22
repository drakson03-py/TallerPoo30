	//Alan Alfredo Galleguillos Castro // 21.455.933-1 //ICCI
	
	
	
	
	package Taller;
	
	import java.io.*;
	import java.util.*;
	
	public class Main {
		
		public static List<Proyectos> proyectos= new ArrayList<>();
		public static String poder;
		public static String usuario;
		
		public static void main(String[] args) throws IOException {
			
			Scanner sc = new Scanner(System.in);
			
			boolean retorno = false;
			do{
			boolean a = login(sc);
			if(a) {print("Aprobado");}
			else {print("Usuario o contraseña incorrecto");
			retorno = true;}
			}while(retorno);
			
			crearProyectos(sc);
			printMenu();
			
			
			
			String eleccion = sc.nextLine();
			admin(eleccion,sc);
			usuario(eleccion,sc);
			
			
			
			
			
			sc.close();
		}
		
		public static void admin(String eleccion,Scanner sc) throws IOException {
			if(poder.equals("Administrador")) {
				
			switch(eleccion) {
			
				case"1":{VerListaCompleta();}
				case"2":{agregarOEliminarProyecto(sc);}
				case"3":{agregarOEliminarTarea(sc);}
			}
			
		}
		}
		public static void usuario(String eleccion,Scanner sc) throws IOException	 {
			if(poder.equals("Colaborador")) {
				
				switch(eleccion) {
				
				case"1":{VerLista();}
				case"2":{tareasAsignadas();}
				case"3":{cambiarEstadoTarea(sc);}
				 	
				}
				
			}
			
		}
		
		public static void tareasAsignadas() {
			
			for(Proyectos plop:proyectos) {
				System.out.println("Tareas Asignadas");
				plop.tareasAsignadas(usuario);
			
				
			}
			
			
		}
		public static void VerListaCompleta() {
			
			for(Proyectos plop:proyectos) {
				System.out.println("--------------------------------");
				System.out.println(plop);
				System.out.println("============");
				System.out.println("Tareas Asociadas");
				plop.getTareas();
			}
			
		}
		public static void VerLista() {
			
			for(Proyectos plop:proyectos) {
				System.out.println("--------------------------------");
				System.out.println(plop);
				
			}
			
		}
		
		
		public static void crearProyectos(Scanner sc) throws FileNotFoundException {
			File pro = new File("Archivos/proyectos.txt");
			Scanner lector = new Scanner(pro);
			
			while(lector.hasNextLine()) {
			String linea = lector.nextLine();
			String parte[] = linea.split("\\|");
			Proyectos  pi = new Proyectos(parte[0],parte[1],parte[2]);
			proyectos.add(pi);
			}
			lector.close();
		};
	
		public static boolean login(Scanner sc) throws FileNotFoundException {
			
			boolean authUsuario = false;
			boolean authPassword = false;
			
			
			print("Usuario:");
			
			String user = sc.nextLine();
			print("Contraseña:");
			String password = sc.nextLine();
			
			File users = new File("Archivos/usuarios.txt");
			Scanner lector = new Scanner(users);
			
			while(lector.hasNextLine()) {	
				
			String linea = lector.nextLine();
			String parte[] = linea.split("\\|");	
			if (parte[0].equals(user)) { 
				authUsuario = true;
				if(parte[1].equals(password)) {authPassword = true;poder = parte[2];usuario = parte[0];}
				break;}
			}
			
			lector.close();
			
			
			if(authUsuario == true && authPassword == true) {return true;}
			
			else {return false;}
			
			
			
			
			
			
			
			
			
			
			
		}
		public static void printMenu() {
		    switch (poder) {
		        case "Administrador":
		            System.out.println("===== MENÚ ADMINISTRADOR =====");
		            System.out.println("1. Ver lista completa de proyectos y tareas");
		            System.out.println("2. Agregar o eliminar un proyecto");
		            System.out.println("3. Agregar o eliminar una tarea en un proyecto");
		            System.out.println("4. Asignar prioridades (Strategy)");
		            System.out.println("5. Generar reporte de proyectos");
		            System.out.println("0. Salir");
		            break;
	
		        case "Colaborador":
		            System.out.println("===== MENÚ USUARIO =====");
		            System.out.println("1. Ver proyectos asignados");
		            System.out.println("2. Ver tareas asignadas");
		            System.out.println("3. Cambiar estado de una tarea");
		            System.out.println("0. Salir");
		            break;
	
		        default:
		            System.out.println("Rol desconocido. No hay menú disponible.");
		            break;
		    }
		}
		
		public static void print(String txt) {System.out.println(txt);}
		
		public static void agregarOEliminarProyecto(Scanner sc) throws IOException {

		    System.out.println("1. Agregar proyecto");
		    System.out.println("2. Eliminar proyecto");
		    String opcion = sc.nextLine();

		    if (opcion.equals("1")) {
		        // AGREGAR
		        System.out.println("ID del proyecto:");
		        String id = sc.nextLine();

		        System.out.println("Nombre del proyecto:");
		        String nombre = sc.nextLine();

		        System.out.println("Responsable:");
		        String responsable = sc.nextLine();

		        FileWriter fw = new FileWriter("Archivos/proyectos.txt", true);
		        fw.write(id + "|" + nombre + "|" + responsable + "\n");
		        fw.close();

		        System.out.println("Proyecto agregado.");

		    } else if (opcion.equals("2")) {

		        System.out.println("ID del proyecto a eliminar:");
		        String idEliminar = sc.nextLine();

		        File archivoPro = new File("Archivos/proyectos.txt");
		        Scanner lectorPro = new Scanner(archivoPro);

		        List<String> nuevosProyectos = new ArrayList<>();

		        while (lectorPro.hasNextLine()) {
		            String linea = lectorPro.nextLine();
		            String parte[] = linea.split("\\|");

		            if (!parte[0].equals(idEliminar)) {
		                nuevosProyectos.add(linea);
		            }
		        }
		        lectorPro.close();

		        FileWriter fwPro = new FileWriter("Archivos/proyectos.txt");
		        for (String l : nuevosProyectos) fwPro.write(l + "\n");
		        fwPro.close();

		        File archivoTar = new File("Archivos/tareas.txt");
		        Scanner lectorTar = new Scanner(archivoTar);

		        List<String> nuevasTareas = new ArrayList<>();

		        while (lectorTar.hasNextLine()) {
		            String linea = lectorTar.nextLine();
		            String parte[] = linea.split("\\|");

		            if (!parte[0].equals(idEliminar)) {
		                nuevasTareas.add(linea);
		            }
		        }
		        lectorTar.close();

		        FileWriter fwTar = new FileWriter("Archivos/tareas.txt");
		        for (String l : nuevasTareas) fwTar.write(l + "\n");
		        fwTar.close();

		        System.out.println("Proyecto y sus tareas asociadas eliminados.");
		    }
		}
		public static void cambiarEstadoTarea(Scanner sc) throws IOException {

		    System.out.println("ID de la tarea a modificar:");
		    String idTarea = sc.nextLine();

		    System.out.println("Nuevo estado (Pendiente / En progreso / Completada):");
		    String nuevoEstado = sc.nextLine();

		    File archivo = new File("Archivos/tareas.txt");
		    Scanner lector = new Scanner(archivo);

		    List<String> nuevasLineas = new ArrayList<>();

		    while (lector.hasNextLine()) {
		        String linea = lector.nextLine();
		        String[] parte = linea.split("\\|");

		        if (parte[1].equals(idTarea)) {
		            parte[4] = nuevoEstado;

		            String nuevaLinea =
		                parte[0] + "|" + parte[1] + "|" + parte[2] + "|" +
		                parte[3] + "|" + parte[4] + "|" + parte[5] + "|" +
		                parte[6] + "|" + parte[7];

		            nuevasLineas.add(nuevaLinea);
		        } else {
		            nuevasLineas.add(linea);
		        }
		    }
		    lector.close();

		    FileWriter fw = new FileWriter("Archivos/tareas.txt");
		    for (String l : nuevasLineas) {
		        fw.write(l + "\n");
		    }
		    fw.close();

		    System.out.println("Estado actualizado.");
		}
		public static void agregarOEliminarTarea(Scanner sc) throws IOException {

		    System.out.println("1. Agregar tarea");
		    System.out.println("2. Eliminar tarea");
		    String opcion = sc.nextLine();

		    if (opcion.equals("1")) {

		        System.out.println("ID del proyecto:");
		        String idProyecto = sc.nextLine();

		        System.out.println("ID de la nueva tarea:");
		        String idTarea = sc.nextLine();

		        System.out.println("Tipo de tarea (Bug, Feature, Documentacion):");
		        String tipo = sc.nextLine();

		        System.out.println("Descripción:");
		        String descrip = sc.nextLine();

		        System.out.println("Estado inicial:");
		        String estado = sc.nextLine();

		        System.out.println("Responsable:");
		        String responsable = sc.nextLine();

		        System.out.println("Complejidad:");
		        String complejidad = sc.nextLine();

		        System.out.println("Fecha:");
		        String fecha = sc.nextLine();

		        FileWriter fw = new FileWriter("Archivos/tareas.txt", true);
		        fw.write(idProyecto + "|" + idTarea + "|" + tipo + "|" + descrip + "|" + estado + "|" 
		                + responsable + "|" + complejidad + "|" + fecha + "\n");
		        fw.close();

		        System.out.println("Tarea agregada.");

		    } else if (opcion.equals("2")) {

		        System.out.println("ID de la tarea a eliminar:");
		        String idEliminar = sc.nextLine();

		        File archivo = new File("Archivos/tareas.txt");
		        Scanner lector = new Scanner(archivo);

		        List<String> nuevasLineas = new ArrayList<>();

		        while (lector.hasNextLine()) {
		            String linea = lector.nextLine();
		            String[] parte = linea.split("\\|");

		            if (!parte[1].equals(idEliminar)) {
		                nuevasLineas.add(linea);
		            }
		        }
		        lector.close();

		        FileWriter fw = new FileWriter("Archivos/tareas.txt");
		        for (String l : nuevasLineas) fw.write(l + "\n");
		        fw.close();

		        System.out.println("Tarea eliminada.");
		    }
		}

	}
	
