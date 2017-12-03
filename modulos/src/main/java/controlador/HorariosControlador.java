package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import datos.HorarioDAO;
import modulos.Horarios;

@ManagedBean
public class HorariosControlador {
	
	@Inject
	private HorarioDAO hdao;
	private Horarios hor = null;
	private List<Horarios>horarios; 
	private int id;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void loadHorarios() {	
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
		return null;
	}
	
	public String Guardar() {
		System.out.println(hor);
		hdao.Guardar(hor);
		loadHorarios();
		return "ListarHorarios";
	}

}
