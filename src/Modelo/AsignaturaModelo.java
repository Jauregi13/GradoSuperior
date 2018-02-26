package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
