import java.util.ArrayList;

import Modelo.Matricula;
import Modelo.MatriculaModelo;
import Vista.AlumnoVista;
import Vista.AsignaturaVista;
import Vista.InstitutoVista;
import Vista.MatriculaVista;

public class MainMatricula {

	public static void main(String[] args) {

		InstitutoVista gestorInstituto = new InstitutoVista();

		gestorInstituto.menuInstituto();

	}
}