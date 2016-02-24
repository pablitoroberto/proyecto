package controller;


import entidades.Aula;
import entidades.Carrera;
import entidades.Disponibilidad;
import entidades.Docente;
import entidades.Materia;
import entidades.Periodo;
import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;



public class LoginDAO {

	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select usuario, contrasenia from Usuario where usuario = ? and contrasenia = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
	public static boolean validatedocente(String user) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select nombre from Docente where ci = ? ");
			ps.setString(1, user);
			

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
	public static boolean validateestudainte(String user) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select nombres from Estudiante where cedula = ? ");
			ps.setString(1, user);
			

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
        
        public static boolean validateeperincripcion(String user) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select nombres from Estudiante where ID_ESTUDIANTE=(select ID_ESTUDIANTE from prenscripcion where ID_ESTUDIANTE=(select ID_ESTUDIANTE from estudiante where CEDULA=?))");
			ps.setString(1, user);
			

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
        
        
        public ArrayList<Carrera> damecarrera() throws Exception{
        ArrayList<Carrera> lst = new ArrayList<>();
                Connection con = null;
		PreparedStatement ps = null;
                con = DataConnect.getConnection();
                String sql="SELECT * FROM CARRERA";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next()){
                    Carrera ca= new Carrera();
                    ca.setIdCarrera(rs.getInt("id_carrera"));
                    ca.setNombre(rs.getString("nombre"));
                    lst.add(ca);
                    
                    
                
                }
            
            
            return lst;
        }
        public ArrayList<Periodo> dameperiodo() throws Exception{
        ArrayList<Periodo> lst = new ArrayList<>();
                Connection con = null;
		PreparedStatement ps = null;
                con = DataConnect.getConnection();
                String sql="SELECT * FROM PERIODO";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next()){
                    Periodo ca= new Periodo();
                    ca.setIdPeriodo(rs.getInt("id_periodo"));
                    ca.setNombre(rs.getString("nombre"));
                    lst.add(ca);
                    
                    
                
                }
            
            
            return lst;
        }
        public ArrayList<Aula> dameaula() throws Exception{
        ArrayList<Aula> lst = new ArrayList<>();
                Connection con = null;
		PreparedStatement ps = null;
                con = DataConnect.getConnection();
                String sql="SELECT * FROM Aula";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next()){
                    Aula ca= new Aula();
                    ca.setIdAula(rs.getInt("id_aula"));
                    ca.setNombre(rs.getString("nombre"));
                    lst.add(ca);
                    
                    
                
                }
            
            
            return lst;
        }
        
        
        public ArrayList<Materia> damemateria( int idcarrera) throws Exception{
        ArrayList<Materia> lst = new ArrayList<>();
                Connection con = null;
                con = DataConnect.getConnection();
                String sql="SELECT * FROM Materia where id_carrera="+idcarrera;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next()){
                    Materia ca= new Materia();
                    ca.setIdMateria(rs.getInt("id_materia"));
                    ca.setNombre(rs.getString("nombre"));
                    lst.add(ca);

                }
            return lst;
        }
        
        public ArrayList<Docente> damedocente( int idmateria) throws Exception{
        ArrayList<Docente> lst = new ArrayList<>();
                Connection con = null;
                con = DataConnect.getConnection();
                String sql="SELECT * FROM Docente where ID_DOCENTE in (select ID_DOCENTE from disponibilidad where ID_MATERIA="+idmateria+")";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next()){
                    Docente ca= new Docente();
                    ca.setIdDocente(rs.getInt("id_docente"));
                    ca.setNombre(rs.getString("nombre"));
                    lst.add(ca);

                }
            return lst;
        }
        
        public static  String obtenerCarrera(int carrera) throws SQLException{
            Connection con = null;
                con = DataConnect.getConnection();
                String sql="SELECT * FROM Carrera where id_carrera="+carrera;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
            
               if(rs.next()){
                    Carrera ca= new Carrera();
                    ca.setIdCarrera(rs.getInt("id_carrera"));
                    ca.setNombre(rs.getString("nombre"));
                    return rs.getString("nombre");
                }
                
            return rs.getString("nombre") ; 
        
        }
        public static  String obtenerMateria(int materia) throws SQLException{
            Connection con = null;
                con = DataConnect.getConnection();
                String sql="SELECT * FROM Materia where id_materia="+materia;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
            
               if(rs.next()){
                    Carrera ca= new Carrera();
                    ca.setIdCarrera(rs.getInt("id_materia"));
                    ca.setNombre(rs.getString("nombre"));
                    return rs.getString("nombre");
                }
                
            return rs.getString("nombre") ; 
        
        }
        public static  String obtenerAula(int idaula) throws SQLException{
            Connection con = null;
                con = DataConnect.getConnection();
                String sql="SELECT * FROM Aula where id_aula="+idaula;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
            
               if(rs.next()){
                    Aula ca= new Aula();
                    ca.setIdAula(rs.getInt("id_aula"));
                    ca.setNombre(rs.getString("nombre"));
                    return rs.getString("nombre");
                }
                
            return rs.getString("nombre") ; 
        
        }
        
}