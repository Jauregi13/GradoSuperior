package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AsignaturaModelo extends Conector{
	
	public Asignatura selectPorId(int id){
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM asignaturas WHERE id = " + id);
			
			if(rs.next()){
				Asignatura asignatura = new Asignatura();
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));
				
				return asignatura;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void insertAsignatura(Asignatura asignatura){
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO asignaturas (nombre, horas) VALUES (?,?)");
			
			pst.setString(1, asignatura.getNombre());
			pst.setInt(2, asignatura.getHoras());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public Asignatura selectPorNombre(String nombre_asignatura) {
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM asignaturas WHERE nombre = " + nombre_asignatura);
			
			pst.setString(1, nombre_asignatura);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Asignatura asignatura = new Asignatura();
				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));
				
				return asignatura;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ArrayList<Asignatura> selectConAlumnos(){
		ArrayList<Asignatura> asignaturas = new ArrayList();
		MatriculaModelo matriculaModelo = new MatriculaModelo();
		try {
			Statement st = super.conexion.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM asignaturas");
			
			while(rs.next()){
				
				Asignatura asignatura = new Asignatura();
				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));
				asignatura.setMatriculas(matriculaModelo.selectPorAsignatura(asignatura));
				
				asignaturas.add(asignatura);
				
				return asignaturas;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}
