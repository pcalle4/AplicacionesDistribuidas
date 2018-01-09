package interciclo.controlador;
//Clase Controlador de Calificacion
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import interciclo.datos.CalificacionDAO;
import interciclo.modulos.Calificacion;


@ManagedBean
@SessionScoped
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
	
	public void loadCalificaciones() { //datos de lista
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
