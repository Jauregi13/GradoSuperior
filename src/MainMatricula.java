import java.util.ArrayList;

import Modelo.Matricula;
import Modelo.MatriculaModelo;
import Vista.AlumnoVista;
import Vista.MatriculaVista;

public class MainMatricula {

	public static void main(String[] args) {

		MatriculaVista gestorMatricula = new MatriculaVista();
		gestorMatricula.mostrarMatriculas();
		
		AlumnoVista gestorAlumnos = new AlumnoVista();
		gestorAlumnos.menuAlumno();
	}

}
