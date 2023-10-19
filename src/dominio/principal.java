package dominio;

import java.util.ArrayList;

import dao.SegurosDao;
import dao.TipoSegurodao;


public class principal {

	public static void main(String[] args) {
	    TipoSegurodao dao = new TipoSegurodao();
		ArrayList<Tiposeguro> lista = new ArrayList<Tiposeguro>(); 
		lista= dao.ListarTiposdeSeguros();
		for(Tiposeguro seguro: lista) {
			System.out.println(seguro.toString());
		}
		
		SegurosDao d1 = new SegurosDao(); 
		int ultimo=0;
		ultimo= d1.UltimoID();
			System.out.println(ultimo);
			
		Seguros obj= new Seguros();
		SegurosDao daoAA= new SegurosDao();
		obj.setCostoContratacion(22);
		obj.setCostoMaxAsegurado(333);
		obj.setDescripcion("ddd");
		
		obj.setTipoSeguro(daoAA.TipoSeguro(2));
		if(daoAA.agregarSeguro(obj)>0) {
			System.out.println("PEPEPE");
		}
		
	}
}
