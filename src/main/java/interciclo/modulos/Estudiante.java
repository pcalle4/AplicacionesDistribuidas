package interciclo.modulos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;



@Entity
public class Estudiante implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="est_id")
	private int est_id;
	
	@NotNull
	@Column(name="est_nombre")
	private String est_nombre;
	
	@NotNull
	@Column(name="est_apellido")
	private String est_apellido;
	
	@NotNull
	@Column(name="est_cedula")
	private String est_cedula;
	
	@NotNull
	@Column(name="est_telefono")
	private String est_telefono;
	
	@NotNull
	@Email
	@Column(name="est_mail")
	private String est_mail;
	

	@NotNull
	@Column(name="est_contrasena")
	private String est_contrasena;


	public int getEst_id() {
		return est_id;
	}


	public void setEst_id(int est_id) {
		this.est_id = est_id;
	}


	public String getEst_nombre() {
		return est_nombre;
	}


	public void setEst_nombre(String est_nombre) {
		this.est_nombre = est_nombre;
	}


	public String getEst_apellido() {
		return est_apellido;
	}


	public void setEst_apellido(String est_apellido) {
		this.est_apellido = est_apellido;
	}


	public String getEst_cedula() {
		return est_cedula;
	}


	public void setEst_cedula(String est_cedula) {
		this.est_cedula = est_cedula;
	}


	public String getEst_telefono() {
		return est_telefono;
	}


	public void setEst_telefono(String est_telefono) {
		this.est_telefono = est_telefono;
	}


	public String getEst_mail() {
		return est_mail;
	}


	public void setEst_mail(String est_mail) {
		this.est_mail = est_mail;
	}


	public String getEst_contrasena() {
		return est_contrasena;
	}


	public void setEst_contrasena(String est_contrasena) {
		this.est_contrasena = est_contrasena;
	}


	@Override
	public String toString() {
		return "EstudianteControlador [est_id=" + est_id + ", est_nombre=" + est_nombre + ", est_apellido="
				+ est_apellido + ", est_cedula=" + est_cedula + ", est_telefono=" + est_telefono + ", est_mail="
				+ est_mail + ", est_contrasena=" + est_contrasena + "]";
	}
	
	
}
