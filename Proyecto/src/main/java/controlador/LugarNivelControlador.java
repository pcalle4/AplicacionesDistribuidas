package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import datos.LugaNiveDAO;
import modulos.LugarNivelacion;
import modulos.Soli_Cita;

@ManagedBean
public class LugarNivelControlador {

	@Inject
	private LugaNiveDAO lgdao;
	
	private LugarNivelacion lugnive = null;
	
	private List<LugarNivelacion> listalugares;

	
	
	public LugaNiveDAO getLgdao() {
		return lgdao;
	}

	public void setLgdao(LugaNiveDAO lgdao) {
		this.lgdao = lgdao;
	}

	public LugarNivelacion getLugnive() {
		return lugnive;
	}

	public void setLugnive(LugarNivelacion lugnive) {
		this.lugnive = lugnive;
	}

	public List<LugarNivelacion> getListalugares() {
		return listalugares;
	}

	public void setListalugares(List<LugarNivelacion> listalugares) {
		this.listalugares = listalugares;
	}

	@PostConstruct
	public void init() {
		lugnive = new LugarNivelacion();
		lugnive.addSoliCita(new Soli_Cita());
		loadLugares();
	}
	
	public void loadLugares() {
		listalugares = lgdao.listadoLugNive();
	  }
	
	public String loadDatosEditar(int id) {
		  System.out.println("Cargando datos de precios a editar" + id);
		  lugnive = lgdao.leer(id);
		  return "GuardarLugar";
	  }
	  
	public String guardar() {
		System.out.println(lugnive);
		lgdao.guardar(lugnive);
		loadLugares();
		return "ListadoLugares";
		
	}
	
	public String eliminarLugares(int id) {
		lgdao.borrar(id);
		loadLugares();
		return "ListadoLugares";
	}
	
	public String addSoliCita() {
		lugnive.addSoliCita(new Soli_Cita());
		return null;
	}
}

