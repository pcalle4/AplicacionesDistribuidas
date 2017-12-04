package interciclo.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import interciclo.datos.EstudianteDAO;
import interciclo.modulos.Estudiante;

@ManagedBean
@ViewScoped
public class EstudianteControlador{

	private Estudiante estudiante;
	@Inject
	private EstudianteDAO estdao;
	private List<Estudiante>estudiantes;
	
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	@PostConstruct
	public void init() {
		estudiante = new Estudiante();
		loadEstudiante();
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public void loadEstudiante() {
		estudiantes = estdao.listadoEstudiante();
	}
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos"+ id);
		estudiante = estdao.leer(id);
		return "crearEstudiante";
	}
	public String guardar() {
		System.out.println(estudiante);
		estdao.guardarEstudiante(estudiante);
		loadEstudiante();
		return "listado-estudiantes";
	}
	public String borrarEstudiante(int id) {
		estdao.borrar(id);
		loadEstudiante();
		return "listado-estudiantes";
	}
}
