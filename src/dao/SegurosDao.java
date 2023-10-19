package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Seguros;
import dominio.Tiposeguro;

public class SegurosDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "782782";
	private String dbName = "segurosgroup";
	private Tiposeguro tiposeguro;

	
	public ArrayList<Seguros> ListaSeguros() 
	{	
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		ArrayList<Seguros> lista = new ArrayList<Seguros>();
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT s.idSeguro, s.descripcion, ti.descripcion as Descripcionti, ti.idTipo as Idtipseguro, s.costoContratacion, s.costoAsegurado FROM seguros s inner join tiposeguros ti on s.idTipo=ti.idTipo");
			
			while(rs.next())
			{
				Seguros segurosRs = new Seguros();
				segurosRs.setID(rs.getInt("idSeguro"));
				segurosRs.setDescripcion(rs.getString("descripcion"));
				
				tiposeguro = new Tiposeguro();
				tiposeguro.setID(rs.getInt("Idtipseguro"));
				tiposeguro.setDescripcion(rs.getString("Descripcionti"));
				
				segurosRs.setTipoSeguro(tiposeguro);
				segurosRs.setCostoContratacion(rs.getFloat("costoContratacion"));
				segurosRs.setCostoMaxAsegurado(rs.getFloat("costoAsegurado"));
				
				
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
	
	public ArrayList<Seguros> ListaSegurosFiltrada(int id) 
	{	
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		ArrayList<Seguros> lista = new ArrayList<Seguros>();
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT s.idSeguro, s.descripcion, ti.descripcion as Descripcionti, ti.idTipo as Idtipseguro, s.costoContratacion, s.costoAsegurado FROM seguros s inner join tiposeguros ti on s.idTipo=ti.idTipo where ti.idTipo= "+id);
			
			while(rs.next())
			{
				Seguros segurosRs = new Seguros();
				segurosRs.setID(rs.getInt("idSeguro"));
				segurosRs.setDescripcion(rs.getString("descripcion"));
				
				tiposeguro = new Tiposeguro();
				tiposeguro.setID(rs.getInt("Idtipseguro"));
				tiposeguro.setDescripcion(rs.getString("Descripcionti"));
				
				segurosRs.setTipoSeguro(tiposeguro);
				segurosRs.setCostoContratacion(rs.getFloat("costoContratacion"));
				segurosRs.setCostoMaxAsegurado(rs.getFloat("costoAsegurado"));
				
				
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
	
	
	
	public Tiposeguro TipoSeguro(int id){
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idTipo, descripcion from tiposeguros where idTipo="+id);
			
			
			while(rs.next())
			{
				tiposeguro = new Tiposeguro();
				tiposeguro.setID(rs.getInt("idTipo"));
				tiposeguro.setDescripcion(rs.getString("descripcion"));
			}
			
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.tiposeguro;
	}
	public int UltimoID(){
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		int id=0;
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select idseguro from seguros");
			
			while(rs.next())
			{
				Seguros segurosRs = new Seguros();
				segurosRs.setID(rs.getInt("idseguro"));
				
				id=segurosRs.getID();
			}
			
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	
	public int eliminarSeguro(int id)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		int filas = 0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "delete from seguros where id=" + id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}

	
	public int agregarSeguro(Seguros seguros)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		int filas=0;
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "Insert into seguros (descripcion, idTipo, costoContratacion, costoAsegurado) values ('"+seguros.getDescripcion()+"',"+seguros.getTipoSeguro().getID()+","+seguros.getCostoContratacion()+","+seguros.getCostoMaxAsegurado()+")";
			filas = st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
}
