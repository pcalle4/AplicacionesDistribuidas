package interciclo.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import interciclo.datos.EspecialidadDAO;
import interciclo.modulos.Especialidad;

@ManagedBean
@ViewScoped
public class EspecialidadControlador {

	private Especialidad especialidad;
	@Inject
	private EspecialidadDAO esdao;
	private List<Especialidad>especialidades;
	
	
	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
	
	@PostConstruct
	public void init() {
		especialidad = new Especialidad();
		loadEspecialidad();
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public void loadEspecialidad() {
		especialidades = esdao.listadoEspecialidad();
	}
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos"+ id);
		especialidad = esdao.leer(id);
		return"crearEspecialidad";
	}
	public String guardar() {
		System.out.println(especialidad);
		esdao.guardarEspecialidad(especialidad);
		loadEspecialidad();
		return "listado-especialidades";
	}
	public String borrarEspecialidad(int id) {
		esdao.borrar(id);
		loadEspecialidad();
		return "listado-especialidades";
	}
	
	
	
	
}
