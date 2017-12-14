package interciclo.controlador;
//Clase Controlador de Academicas
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import interciclo.datos.AcademicasDAO;
import interciclo.modulos.Academicas;
import interciclo.modulos.Especialidad;

@ManagedBean
public class AcademicasControlador {

	private Academicas academica;
	@Inject
	private AcademicasDAO ardao;
	private List<Academicas>academicas;
	
	
	public List<Academicas> getAcademicas() {
		return academicas;
	}
	public void setAcademicas(List<Academicas> academicas) {
		this.academicas = academicas;
	}
	
	public Academicas getAcademica() {
		return academica;
	}
	public void setAcademica(Academicas academica) {
		this.academica = academica;
	}
	
	@PostConstruct
	public void init() {
		academica = new Academicas();
		academica.addEspecialidad(new Especialidad());
		loadAcademicas();
	}
	
	//metodos
	
	public void loadAcademicas() { //datos de lista
		academicas = ardao.listadoAcademicas();
	}
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos"+ id);
		academica = ardao.leer(id);
		return"crearAreas";
	}
	public String guardar() {
		System.out.println(academica);
		ardao.guardarAcademica(academica);
		return "listado-areas";		
	}
	public String borrarAcademica(int id) { 
		ardao.borrar(id);
		loadAcademicas();
		return "listado-areas";
	}
	
	public String addEspecialidad() {
		academica.addEspecialidad(new Especialidad());
		return null;
	}
}
