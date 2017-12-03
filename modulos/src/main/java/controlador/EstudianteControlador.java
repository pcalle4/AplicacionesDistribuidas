package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import datos.EstudianteDAO;
import modulos.Estudiante;

@ManagedBean
@RequestScoped
public class EstudianteControlador {
	
	
	@Inject
	private EstudianteDAO edao;
	private Estudiante estudiante=null;
	private List<Estudiante>estudiantes;
	
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	@PostConstruct
	public void init() {
		estudiante=new Estudiante();
		loadEstudiantes();
		
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public void loadEstudiantes() {
		estudiantes=edao.listadoEstudiantes();
	}
	public String guardar() {
		System.out.println(estudiante);
		edao.guardar(estudiante);
		loadEstudiantes();
		return "ListadoEstudiantes";
	}
	

}
