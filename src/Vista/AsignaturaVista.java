package Vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.AsignaturaModelo;
import Modelo.Matricula;

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
				
				ArrayList<Asignatura> asignaturas = asignaturaModelo.selectConAlumnos();
				
				mostrarAsignaturas(asignaturas);
				
				break;
				
				
			case SALIR:
				
				break;

			default:
				break;
			}
		}
		while(opcion != SALIR);
	}

	private void mostrarAsignaturas(ArrayList<Asignatura> asignaturas) {
		
		Iterator<Asignatura> i = asignaturas.iterator();
		
		while(i.hasNext()){
			Asignatura asignatura = i.next();
			
			ArrayList<Matricula> alumnos = asignatura.getMatriculas();
			
			System.out.println(asignatura.getNombre());
			
			Iterator<Matricula> i2 = alumnos.iterator();
			
			while(i2.hasNext()){
				Matricula alumno = i2.next();
				
				System.out.println("\t" + alumno.getAlumno().getDni() + " " + alumno.getAlumno().getNombre());
			}
			
		}
		
	}

}
