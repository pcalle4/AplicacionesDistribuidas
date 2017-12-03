package modulos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Estudiante implements Serializable {
	

	@Id
	@Column(name="est_id")
	private int id;
	
	@NotNull
	@Column(name="est_nombre")
	@Size(min=4, max=10)
	private String nombre;
	
	@NotNull
	@Column(name="est_apellido")
	@Size(min=4, max=10)
	private String apellido;
	
	@NotNull
	@Column(name="est_cedula",length=10)
	private String cedula;
	
	@NotNull
	@Column(name="est_telefono")
	private String telefono;
	
	@NotNull
	@Email
	@Column(name="est_email")
	private String email;
	
	@NotNull
	@Column(name="est_contrasena")
	private String contrasena;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", telefono=" + telefono + ", email=" + email + ", contrasena=" + contrasena + "]";
	}
	
	
	

}
