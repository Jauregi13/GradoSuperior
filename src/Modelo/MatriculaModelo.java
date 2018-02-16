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
	
	public ArrayList<Matricula> listarMatriculas(Matricula matricula){
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM matriculas");
			
			while(rs.next()){
				Alumno alumno = new Alumno();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
