package interciclo.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import interciclo.datos.LogInDAO;
import interciclo.modulos.LogIn;


@ManagedBean
public class LogInControlador {
	@Inject
	private LogInDAO ldao;
	private LogIn log = null;
	private List<LogIn>login; 
	private int id;
	
	@PostConstruct
	public void init() {
		 log = new LogIn();
		 loadHorarios();
	}
	
	public LogIn getLog() {
		return log;
	}
	public void setLog(LogIn log) {
		this.log = log;
	}

	public List<LogIn> getLogin() {
		return login;
	}

	public void setLogin(List<LogIn> login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void loadHorarios() {	
		login=ldao.listarLogins();
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando los Datos a editar" + id);
		log = ldao.leer(id);
		return "CrearHorarios";
	}
	
	public String borrarDatos(int id) {
		ldao.Borrar(id);
		loadHorarios();
		return null;
	}
	
	public String Guardar() {
		System.out.println(log);
		ldao.Guardar(log);
		loadHorarios();
		return "ListarHorarios";
	}
	
	public String ingresar(String email,String contrasena) {
		
		ldao.usuarioExiste(email, contrasena);
		if (false) {
			System.out.println("No esta registrado");
		}
			
		return"homepage";
	}
}
