package interciclo.controlador;
//Clase Controlador de Horarios
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import interciclo.datos.HorarioDAO;
import interciclo.modulos.Horarios;

@ManagedBean
public class HorariosControlador {
	private Horarios hor;
	@Inject
	private HorarioDAO hdao;
	private List<Horarios>horarios; 
	
	
	
	@PostConstruct
	public void init() {
		 hor = new Horarios();
		 loadHorarios();
	}
	
	public Horarios getHor() {
		return hor;
	}
	public void setHor(Horarios hor) {
		this.hor = hor;
	}
	public List<Horarios> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horarios> horarios) {
		this.horarios = horarios;
	}

	public void loadHorarios() {	//datos de lista
		horarios = hdao.listarHorarios();
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando los Datos a editar" + id);
		hor = hdao.leer(id);
		return "CrearHorarios";
	}
	
	public String borrarDatos(int id) {
		hdao.Borrar(id);
		loadHorarios();
		return "listado-horarios";
	}
	
	public String Guardar() {
		System.out.println(hor);
		hdao.Guardar(hor);
		loadHorarios();
		return "listado-horarios";
	}
	

}
