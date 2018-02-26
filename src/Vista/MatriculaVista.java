package Vista;

import Modelo.MatriculaModelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import Modelo.Alumno;
import Modelo.AlumnoModelo;
import Modelo.Asignatura;
import Modelo.AsignaturaModelo;
import Modelo.Matricula;

public class MatriculaVista {

	public static final int MATRICULAR = 1;
	public static final int SALIR = 2;
	MatriculaModelo matriculaModelo = new MatriculaModelo();

	public void menuMatriculas() {

		Scanner scan = new Scanner(System.in);
		int opcion = 0;

		do {
			System.out.println(MATRICULAR + ". Matricular alumno");
			System.out.println(SALIR + ". Salir del programa");

			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case MATRICULAR:

				matricular(scan);

				break;
				
			case SALIR:
				
				break;

			default:
				break;
			}
		}

		while (opcion != SALIR);

	}

	private void matricular(Scanner scan) {

		AlumnoModelo alumnoModelo = new AlumnoModelo();
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();

		System.out.println("Introduce el dni del alumno a matricular");
		String dni = scan.nextLine();
		
		Alumno alumno = alumnoModelo.selectPorDni(dni);

		while (alumno == null){
			System.out.println("Ese dni no existe");
			System.out.println("Introduce otro dni:");
			dni = scan.nextLine();
		}
		
		System.out.println("Introduce el nombre de la asignatura para matricular:");
		String nombre_asignatura = scan.nextLine();
		
		Asignatura asignatura = asignaturaModelo.selectPorNombre(nombre_asignatura);
		
		Matricula matricula = new Matricula();
		
		Date fecha_actual = new Date();
		matricula.setAlumno(alumno);
		matricula.setAsignatura(asignatura);
		matricula.setFecha(fecha_actual);
		matriculaModelo.añadirMatricula(matricula);

	}

	public void mostrarMatriculas() {
		ArrayList<Matricula> matriculas = matriculaModelo.listarMatriculas();
		Iterator<Matricula> i = matriculas.iterator();

		while (i.hasNext()) {
			Matricula matricula = i.next();

			mostrarMatricula(matricula);

		}
	}

	public void mostrarMatricula(Matricula matricula) {

		System.out.println(matricula.getAlumno().getNombre() + " : " + matricula.getAlumno().getDni() + " : "
				+ matricula.getAsignatura().getNombre() + " : " + matricula.getAsignatura().getHoras());

	}

}
