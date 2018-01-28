package interciclo.controlador;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import interciclo.modulos.Tutor;

@Named
@SessionScoped
public class Sesion {

	private String usuario;
	
	private Tutor tutorLoggeado;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Tutor getTutorLoggeado() {
		return tutorLoggeado;
	}

	public void setTutorLoggeado(Tutor tutorLoggeado) {
		this.tutorLoggeado = tutorLoggeado;
	}


	
	
	
}
