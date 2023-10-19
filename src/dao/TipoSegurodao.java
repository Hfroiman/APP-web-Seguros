package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Tiposeguro;

public class TipoSegurodao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "782782";
	private String dbName = "segurosgroup";
	
	
	public ArrayList<Tiposeguro> ListarTiposdeSeguros() 
	{	
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		ArrayList<Tiposeguro> lista = new ArrayList<Tiposeguro>();
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idTipo, descripcion FROM tiposeguros");
			
			while(rs.next())
			{
				Tiposeguro segurosRs = new Tiposeguro();
				segurosRs.setID(rs.getInt("idTipo"));
				segurosRs.setDescripcion(rs.getString("descripcion"));
				
				lista.add(segurosRs);
			}
			
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}
	
public String devolverDescripcion(int id) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		String descripcion = null;
		try
		{
			ArrayList<Tiposeguro> lista = ListarTiposdeSeguros();
			
			for (Tiposeguro x : lista) {
				if(x.getID()==id) {
					descripcion = x.getDescripcion();
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		
		}
		
		return descripcion;
	}
}
