package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import datos.PrecioDAO;
import modulos.Precios;
import modulos.Soli_Cita;

@ManagedBean
public class PrecioControlador {

	@Inject
	private PrecioDAO prdao;
	
	private Precios precio = null;
	
	private List<Precios>listaprecio;
	
	public List<Precios> getListaprecios() {
		return listaprecio;
	}
	public void setListaprecios(List<Precios> listaprecio) {
		this.listaprecio = listaprecio;
	}
	
	@PostConstruct
	public void init() {
		precio = new Precios();
		precio.addSoliCita(new Soli_Cita());
		loadPrecios();
	}
	public Precios getPrecios() {
		return precio;
	}
	public void setPrecios(Precios precio) {
		this.precio = precio;
	}
	
	public void loadPrecios() {
		  listaprecio = prdao.listadoPrecios();
	  }
	
	public String loadDatosEditar(int id) {
		  System.out.println("Cargando datos de precios a editar" + id);
		  precio = prdao.leer(id);
		  return "GuardarPrecio";
	  }
	  
	public String guardar() {
		System.out.println(precio);
		prdao.guardar(precio);
		loadPrecios();
		return "ListadoPrecio";
		
	}
	
	public String eliminarPrecios(int id) {
		prdao.borrar(id);
		loadPrecios();
		return "ListadoPrecio";
	}
	
	public String addSoliCita() {
		precio.addSoliCita(new Soli_Cita());
		return null;
	}
	
}
