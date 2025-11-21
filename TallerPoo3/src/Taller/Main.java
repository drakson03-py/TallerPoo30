//Alan Alfredo Galleguillos Castro // 21.455.933-1 //ICCI




package Taller;

import java.io.*;
import java.util.*;

public class Main {
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
		
		
		
		
		
		sc.close();
	}

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
	
	public static void print(String txt) {System.out.println(txt);}
}
