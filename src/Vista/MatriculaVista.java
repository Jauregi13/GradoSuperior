package Vista;

import Modelo.MatriculaModelo;

import java.util.ArrayList;
import java.util.Iterator;

import Modelo.Alumno;
import Modelo.AlumnoModelo;
import Modelo.Asignatura;
import Modelo.AsignaturaModelo;
import Modelo.Matricula;

public class MatriculaVista {
	
	MatriculaModelo matriculaModelo = new MatriculaModelo();

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
