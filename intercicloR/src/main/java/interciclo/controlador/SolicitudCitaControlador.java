package interciclo.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import interciclo.datos.SolicitudCitaDAO;
import interciclo.modulos.SolicitudCita;

@ManagedBean
public class SolicitudCitaControlador {
	@Inject
	private SolicitudCitaDAO sdao;
	private SolicitudCita sol = null;
	private List<SolicitudCita>solicitudes;	
	
	private int id;
	
	@PostConstruct
	public void init() {
		 sol = new SolicitudCita();
		 loadSolicitudes();
	}

	public SolicitudCita getSol() {
		return sol;
	}
	public void setSol(SolicitudCita sol) {
		this.sol = sol;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<SolicitudCita> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<SolicitudCita> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public void loadSolicitudes() {
		solicitudes = sdao.listarSolicitud();
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando los Datos a editar" + id);
		sol = sdao.leer(id);
		return "CrearSolicitud";
	}
	
	public String borrarDatos(int id) {
		sdao.borrar(id);
		loadSolicitudes();
		return null;
	}
	
	public String Guardar() {
		System.out.println(sol);
		sdao.Guardar(sol);
		loadSolicitudes();
		return "ListarSolicitudes";
	}
}
