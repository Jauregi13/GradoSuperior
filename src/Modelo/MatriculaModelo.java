package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatriculaModelo extends Conector {
	
	public void aņadirMatricula(Matricula matricula){
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO matriculas (id_alumno, id_asignatura, fecha) values (?,?,?)");
			
			pst.setInt(1, matricula.getAlumno().getId());
			pst.setInt(2, matricula.getAsignatura().getId());
			pst.setDate(3, new java.sql.Date(matricula.getFecha().getTime()));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Matricula> listarMatriculas(){
		ArrayList<Matricula> matriculas = new ArrayList();
		AlumnoModelo alumnoModelo = new AlumnoModelo();
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM matriculas");
			
			if(rs.next()){
				Matricula matricula = new Matricula();
				matricula.setFecha(rs.getDate("fecha"));
				matricula.setAlumno(alumnoModelo.selectPorId(rs.getInt("id_alumno")));
				matricula.setAsignatura(asignaturaModelo.selectPorId(rs.getInt("id_asignatura")));
				
				matriculas.add(matricula);
				
				return matriculas;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	public ArrayList<Matricula> selectPorAlumno(Alumno alumno) {
		
		try {
			AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
			ArrayList<Matricula> asignaturas = new ArrayList();
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM matriculas WHERE id_alumno = ?");
			
			pst.setInt(1, alumno.getId());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Matricula matricula = new Matricula();
				matricula.setAsignatura(asignaturaModelo.selectPorId(rs.getInt("id_asignatura")));
				matricula.setFecha(rs.getDate("fecha"));
				
				asignaturas.add(matricula);
				
				return asignaturas;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<Matricula> selectPorAsignatura(Asignatura asignatura) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM matriculas WHERE id_asignatura = ?");
			
			pst.setInt(1, asignatura.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
