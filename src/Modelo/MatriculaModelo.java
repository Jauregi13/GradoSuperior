package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatriculaModelo extends Conector {
	
	public void añadirMatricula(Matricula matricula){
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO matriculas values (?,?,?)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Matricula> listarMatriculas(){
		ArrayList<Matricula> matriculas = new ArrayList();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM matriculas");
			
			if(rs.next()){
				Matricula matricula = new Matricula();
				matricula.setFecha(rs.getDate("fecha"));
				matricula.setId_alumno(rs.getInt("id_alumno"));
				matricula.setId_asignatura(rs.getInt("id_asignatura"));
				
				matriculas.add(matricula);
				
				return matriculas;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

}
