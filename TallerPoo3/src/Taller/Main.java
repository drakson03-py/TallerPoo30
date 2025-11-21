	//Alan Alfredo Galleguillos Castro // 21.455.933-1 //ICCI
	
	
	
	
	package Taller;
	
	import java.io.*;
	import java.util.*;
	
	public class Main {
		
		public static List<Proyectos> proyectos= new ArrayList<>();
		public static String poder;
		
		public static void main(String[] args) throws FileNotFoundException {
			
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
			
			switch(eleccion) {
			
			case"1":{VerListaCompleta();}
			}
			
			
			
			
			
			sc.close();
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
				if(parte[1].equals(password)) {authPassword = true;poder = parte[2];}
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
	}
	
