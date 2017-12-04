package interciclo.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import interciclo.datos.TutorDAO;
import interciclo.modulos.Tutor;

@ManagedBean
@SessionScoped
public class TutorControlador {

	private Tutor tutor;
	@Inject
	private TutorDAO tdao;
	private List<Tutor>tutores;
	
	
	public List<Tutor> getTutores() {
		return tutores;
	}
	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Inicio Tutor");
		tutor = new Tutor();
		loadTutor();
	
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public void loadTutor() {
		tutores = tdao.listadoTutor();
	}
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos"+ id);
		tutor = tdao.leer(id);
		return "crearTutor";
	}
	public String guardar() {
		System.out.println(tutor);
		tdao.guardarTutor(tutor);
		loadTutor();
		return "listado-tutores";
	}
   public String borrarTutor(int id) {
	   tdao.borrar(id);
	   loadTutor();
	   return "listado-tutores";
   }
	
}