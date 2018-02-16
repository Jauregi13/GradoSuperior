package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumnoModelo extends Conector{
	
	public ArrayList<Alumno> selectAll(){
		ArrayList<Alumno> alumnos = new ArrayList();
		try {
			Statement st = super.conexion.createStatement();			
			ResultSet rs = st.executeQuery("SELECT * FROM alumnos");
			
			while(rs.next()){
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setEmail(rs.getString("email"));
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
		
	}
	
	public void insertar(Alumno alumno){
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO alumnos (dni, nombre, email) values (?,?,?)");
			
			pst.setString(1, alumno.getDni());
			pst.setString(2, alumno.getNombre());
			pst.setString(3, alumno.getEmail());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Alumno selectPorId(){
		
	}

}