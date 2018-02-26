package Vista;

import java.util.Scanner;

import Modelo.Asignatura;
import Modelo.AsignaturaModelo;

public class AsignaturaVista {
	
	public void menuAsignatura(){
		
		final int INSERTAR_ASIGNATURA = 1;
		final int MOSTRAR_ASIGNATURAS = 2;
		final int SALIR = 3;
		
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		do{
			System.out.println(INSERTAR_ASIGNATURA + ". Insertar asignatura");
			System.out.println(MOSTRAR_ASIGNATURAS + ". Mostrar asignaturas con alumnos correspondientes");
			System.out.println(SALIR + ". Salir del programa");
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case INSERTAR_ASIGNATURA:
				
				System.out.println("Introduce el nombre de la asignatura:");
				String nombre = scan.nextLine();
				
				System.out.println("Introduce las horas de la asignatura");
				int horas = Integer.parseInt(scan.nextLine());
				
				Asignatura asignatura = new Asignatura();
				asignatura.setNombre(nombre);
				asignatura.setHoras(horas);
				
				asignaturaModelo.insertAsignatura(asignatura);
				break;
				
			case MOSTRAR_ASIGNATURAS:
				
				
				break;
				
				
			case SALIR:
				
				break;

			default:
				break;
			}
		}
		while(opcion != SALIR);
	}

}
