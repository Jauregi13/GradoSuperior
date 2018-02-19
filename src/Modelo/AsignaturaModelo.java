package Modelo;

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

}
