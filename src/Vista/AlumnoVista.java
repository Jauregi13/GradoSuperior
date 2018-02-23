package Vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Modelo.Alumno;
import Modelo.AlumnoModelo;
import Modelo.Matricula;

public class AlumnoVista {

	public void menuAlumno(){
		
		final int MOSTRAR_MATRICULAS = 1;
		final int MOSTRAR_ALUMNOS_MATRICULAS = 2;
		final int SALIR = 3;
		AlumnoModelo alumnoModelo = new AlumnoModelo();
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		
		do{
			System.out.println(MOSTRAR_MATRICULAS + ". Mostrar todos los alumnos");
			System.out.println(MOSTRAR_ALUMNOS_MATRICULAS + ". Mostrar los alumnos con cada asignatura matriculada");
			System.out.println(SALIR + ". Salir del menu");
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case MOSTRAR_MATRICULAS:
				
				break;
				
			case MOSTRAR_ALUMNOS_MATRICULAS:
				
				ArrayList<Alumno> alumnos = new ArrayList();
				alumnos = alumnoModelo.selectAllConMatriculas();
				
				mostrarAlumnos(alumnos);
				break;
				
			case SALIR:
				
				break;

			default:
				break;
			}
		}
		
		while(opcion != SALIR);
	}

	private void mostrarAlumnos(ArrayList<Alumno> alumnos) {
		
		Iterator<Alumno> i = alumnos.iterator();
		
		while(i.hasNext()){
			Alumno alumno = i.next();
			
			System.out.println(alumno.getDni() + " " + alumno.getNombre() + " ");
			
			ArrayList<Matricula> matriculas = alumno.getMatriculas();
			
			Iterator<Matricula> i2 = matriculas.iterator();
			
			while(i2.hasNext()){
				Matricula matricula = i2.next();
				
				System.out.println("\t " + matricula.getAsignatura().getNombre());
			}
		}
		
	}
	

}
