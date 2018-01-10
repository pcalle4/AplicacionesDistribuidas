package interciclo.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import interciclo.datos.LugaNiveDAO;
import interciclo.modulos.LugarNivelacion;

@ManagedBean
@SessionScoped
public class LugarNivelControlador {
	
	private LugarNivelacion lugnive;
	@Inject
	private LugaNiveDAO lgdao;
	private List<LugarNivelacion> listalugares;

	public List<LugarNivelacion> getListalugares() {
		return listalugares;
	}

	public void setListalugares(List<LugarNivelacion> listalugares) {
		this.listalugares = listalugares;
	}


	

	

	@PostConstruct
	public void init() {
		lugnive = new LugarNivelacion();
		//lugnive.addSoliCita(new Soli_Cita());//delete
		listalugares=new ArrayList<>();//add
		loadLugares();
	}
	public LugarNivelacion getLugnive() {
		return lugnive;
	}

	public void setLugnive(LugarNivelacion lugnive) {
		this.lugnive = lugnive;
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
	public String doListLugar() {
		List<LugarNivelacion> lugares = lgdao.listadoLugNive();
		for(LugarNivelacion aux : lugares) {
			System.out.println("LugarNivelacion=[codigo="+aux.getCodigo()+", "
					+ "lugar="+aux.getLugar()+"]");
		}
		return null;
	}
	
	public String addSoliCita() {
		//lugnive.addSoliCita(new Soli_Cita());//delete
		return null;
	}
	public String nuevo() {
		lugnive=new LugarNivelacion();
		return "GuardarLugar";
	}
	
	
	public LugaNiveDAO getLgdao() {
		return lgdao;
	}

	public void setLgdao(LugaNiveDAO lgdao) {
		this.lgdao = lgdao;
	}
}

