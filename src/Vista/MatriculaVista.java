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

	public static void main(String[] args) {
		
		MatriculaModelo matriculaModelo = new MatriculaModelo();
		ArrayList<Matricula> matriculas = matriculaModelo.listarMatriculas();
		
		

	}
	
	private void mostrarMatriculas(ArrayList<Matricula> matriculas){
		Iterator<Matricula> i = matriculas.iterator();
		
		while(i.hasNext()){
			Matricula matricula = i.next();
			
			mostrarMatricula(matricula);
			
			
		}
	}

	private void mostrarMatricula(Matricula matricula) {
		
		AlumnoModelo alumnoModelo = new AlumnoModelo();
		Alumno alumno = alumnoModelo.selectPorId(matricula.getId_alumno());
		
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
		Asignatura asignatura = asignaturaModelo.selectPorId(matricula.getId_asignatura());
		
		System.out.println(alumno.getDni() + " " + alumno.getNombre() + " " + asignatura.getNombre() + " "
				+ asignatura.getHoras() + " " + matricula.getFecha());
		
	}

}
