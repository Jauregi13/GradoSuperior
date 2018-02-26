package Vista;

import java.util.Scanner;

public class InstitutoVista {

	final static int MENU_ALUMNO = 1;
	final static int MENU_ASIGNATURA = 2;
	final static int MENU_MATRICULA = 3;
	final static int SALIR = 4;
	
	
	public void menuInstituto(){
		
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		do{
			System.out.println(MENU_ALUMNO + ". Elegir gestor de alumnos");
			System.out.println(MENU_ASIGNATURA + ". Elegir el gestor de asignaturas");
			System.out.println(MENU_MATRICULA + ". Elegir el gestor de matriculas");
			System.out.println(SALIR + ". Salir de la aplicacion");
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case MENU_ALUMNO:
				
				AlumnoVista gestorAlumno = new AlumnoVista();
				
				gestorAlumno.menuAlumno();
				break;
				
			case MENU_ASIGNATURA:
				
				AsignaturaVista gestorAsignatura = new AsignaturaVista();
				
				gestorAsignatura.menuAsignatura();
				break;
				
			case MENU_MATRICULA:
				
				MatriculaVista gestorMatricula = new MatriculaVista();
				
				gestorMatricula.menuMatriculas();
				
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
