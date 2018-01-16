package interciclo.controlador;
//Clase Controlador de Estudiante
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import interciclo.datos.EstudianteDAO;
import interciclo.modulos.Estudiante;

@ManagedBean
@SessionScoped
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
		estudiantes= new ArrayList<Estudiante>();
		loadEstudiante();
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public void loadEstudiante() { //datos de lista
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
	public String nuevo() {
		estudiante=new Estudiante();
		return "crearEstudiante";
	}
	
	public String borrarEstudiante(int id) {
		estdao.borrar(id);
		loadEstudiante();
		return "listado-estudiantes";
	}
	
	
	
	public EstudianteDAO getEstdao() {
		return estdao;
	}
	public void setEstdao(EstudianteDAO estdao) {
		this.estdao = estdao;
	}
	
}
