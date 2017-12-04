package interciclo.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import interciclo.datos.AcademicasDAO;
import interciclo.modulos.Academicas;

@ManagedBean
@ViewScoped
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
	
	@PostConstruct
	public void init() {
		academica = new Academicas();
		loadAcademicas();
	}
	public Academicas getAcademica() {
		return academica;
	}
	public void setAcademica(Academicas academica) {
		this.academica = academica;
	}
	public void loadAcademicas() {
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
	
}
