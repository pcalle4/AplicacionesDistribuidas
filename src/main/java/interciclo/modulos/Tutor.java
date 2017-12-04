package interciclo.modulos;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
public class Tutor implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="tut_id")
	private int tut_id;
	
	@NotNull
	@Column(name="tut_nombre")
	private String tut_nombre;
	
	@NotNull
	@Column(name="tut_apellido")
	private String tut_apellido;
	
	@NotNull
	@Column(name="tut_cedula")
	private String tut_cedula;
	
	@NotNull
	@Column(name="tut_telefono")
	private String tut_telefono;
	
	@NotNull
	@Email
	@Column(name="tut_mail")
	private String tut_mail;
	
	@NotNull
	@Column(name="tut_contrasena")
	private String tut_contrasena;

	public int getTut_id() {
		return tut_id;
	}

	public void setTut_id(int tut_id) {
		this.tut_id = tut_id;
	}

	public String getTut_nombre() {
		return tut_nombre;
	}

	public void setTut_nombre(String tut_nombre) {
		this.tut_nombre = tut_nombre;
	}

	public String getTut_apellido() {
		return tut_apellido;
	}

	public void setTut_apellido(String tut_apellido) {
		this.tut_apellido = tut_apellido;
	}

	public String getTut_cedula() {
		return tut_cedula;
	}

	public void setTut_cedula(String tut_cedula) {
		this.tut_cedula = tut_cedula;
	}

	public String getTut_telefono() {
		return tut_telefono;
	}

	public void setTut_telefono(String tut_telefono) {
		this.tut_telefono = tut_telefono;
	}

	public String getTut_mail() {
		return tut_mail;
	}

	public void setTut_mail(String tut_mail) {
		this.tut_mail = tut_mail;
	}

	public String getTut_contrasena() {
		return tut_contrasena;
	}

	public void setTut_contrasena(String tut_contrasena) {
		this.tut_contrasena = tut_contrasena;
	}

	@Override
	public String toString() {
		return "Tutor [tut_id=" + tut_id + ", tut_nombre=" + tut_nombre + ", tut_apellido=" + tut_apellido
				+ ", tut_cedula=" + tut_cedula + ", tut_telefono=" + tut_telefono + ", tut_mail=" + tut_mail
				+ ", tut_contrasena=" + tut_contrasena + "]";
	}
	
	
}
