package interciclo.modulos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="Tutor")
public class Tutor implements Serializable {

	@Id
	//@GeneratedValue
	@Column(name = "tut_id")
	private int tut_id;

	@NotNull
	@Pattern(regexp = "[^0-9]*", message = "El campo debe contener solo letras")
	@Column(name = "tut_nombre")
	private String tut_nombre;

	@NotNull
	@Pattern(regexp = "[^0-9]*", message = "El campo debe contener solo letras")
	@Column(name = "tut_apellido")
	private String tut_apellido;

	@NotNull
	@Column(name = "tut_cedula", length=10)
	private String tut_cedula;

	@NotNull
	@Digits(fraction = 0, integer = 12)
	@Column(name = "tut_telefono")
	private String tut_telefono;

	@NotNull
	@Email
	@Column(name = "tut_mail")
	private String tut_mail;

	@NotNull
	@Column(name = "tut_contrasena")
	private String tut_contrasena;

/*	@OneToMany(mappedBy = "tutor")
	private List<Calificacion> calificaciones;

	@OneToMany(mappedBy = "tutor")
	private List<SolicitudCita> solicitudCitas;

	@OneToMany(mappedBy = "tutor")
	private List<Hor_Tut> hor_Tuts;*/

	
	@OneToOne(fetch=FetchType.EAGER) 
	private LogIn logIn;


	/*@OneToMany(mappedBy = "tutor")
	private List<LogIn> logIns;*/

	@ManyToMany
	private List<Academicas> academicas;

	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}

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

/*	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public List<SolicitudCita> getSolicitudCitas() {
		return solicitudCitas;
	}

	public void setSolicitudCitas(List<SolicitudCita> solicitudCitas) {
		this.solicitudCitas = solicitudCitas;
	}

	public List<Hor_Tut> getHor_Tuts() {
		return hor_Tuts;
	}

	public void setHor_Tuts(List<Hor_Tut> hor_Tuts) {
		this.hor_Tuts = hor_Tuts;
	}*/


	
	

	

	public LogIn getLogIn() {
		return logIn;
	}

	public void setLogIn(LogIn logIn) {
		this.logIn = logIn;
	}

	public List<Academicas> getAcademicas() {
		return academicas;
	}

	public void setAcademicas(List<Academicas> academicas) {
		this.academicas = academicas;
	}

	@Override
	public String toString() {
		return "Tutor [tut_id=" + tut_id + ", tut_nombre=" + tut_nombre + ", tut_apellido=" + tut_apellido
				+ ", tut_cedula=" + tut_cedula + ", tut_telefono=" + tut_telefono + ", tut_mail=" + tut_mail
				+ ", tut_contrasena=" + tut_contrasena + "]";
	}

}
