package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import datos.CalificacionDAO;
import modulos.Calificacion;


@ManagedBean
public class CalificacionControlador {
	
	@Inject
	private CalificacionDAO cdao;
	
	private Calificacion calificacion = null;
	
	private List<Calificacion>listacalificacion;
	
	public List<Calificacion> getListacalificacion() {
		return listacalificacion;
	}
	public void setListacalificacion(List<Calificacion> listacalificacion) {
		this.listacalificacion = listacalificacion;
	}
	
	@PostConstruct
	public void init() {
		calificacion = new Calificacion();
		loadCalificaciones();
	}
	public Calificacion getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}
	
	public void loadCalificaciones() {
		  listacalificacion = cdao.listadoCalificaciones();
	  }
	
	public String loadDatosEditar(int id) {
		  System.out.println("Cargando datos de calificaciones a editar" + id);
		 calificacion = cdao.leer(id);
		  return"CalificarProfesores";
	  }
	  
	public String guardar() {
		System.out.println(calificacion);
		cdao.guardar(calificacion);
		loadCalificaciones();
		return "ListadoCalificaciones";
		
	}
	
	public String eliminarCalificacion(int id) {
		cdao.borrar(id);
		loadCalificaciones();
		return "ListadoCalificaciones";
	}
}
