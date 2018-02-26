import java.util.ArrayList;

import Modelo.Matricula;
import Modelo.MatriculaModelo;
import Vista.AlumnoVista;
import Vista.AsignaturaVista;
import Vista.MatriculaVista;

public class MainMatricula {

	public static void main(String[] args) {

		MatriculaVista gestorMatricula = new MatriculaVista();
		gestorMatricula.menuMatriculas();
		
		AlumnoVista gestorAlumnos = new AlumnoVista();
		gestorAlumnos.menuAlumno();
		
		AsignaturaVista gestorAsignatura = new AsignaturaVista();
		gestorAsignatura.menuAsignatura();
	}

}
