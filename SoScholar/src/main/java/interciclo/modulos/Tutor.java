package interciclo.modulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.GenerationType;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="Tutor")
public class Tutor implements Serializable {

	@Id
	@TableGenerator(name="tabTutor", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabTutor")
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

	@NotNull
	@Column(name = "tut_area")
	private String tut_area;
	
	@NotNull
	@Column(name = "tut_especialidad")
	private String tut_especialidad;
	
	@NotNull
	@Column(name = "tut_anivel")
	private String tut_anivel;
	
	@NotNull
	@Column(name = "tut_precio")
	private double tut_precio;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="tutor", referencedColumnName="tut_id")
	private List<Horarios> horarios;

	@OneToMany(mappedBy = "tutor")
	private List<Calificacion> calificaciones;

	@OneToMany(mappedBy = "tutor")
	private List<SolicitudCita> solicitudCitas;
	
	
	
	@OneToOne(fetch=FetchType.EAGER) 
	private LogIn logIn;
	
	
	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public List<Horarios> getHorarios() {
		return horarios;
	}




	public void setHorarios(List<Horarios> horarios) {
		this.horarios = horarios;
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




	public String getTut_area() {
		return tut_area;
	}




	public void setTut_area(String tut_area) {
		this.tut_area = tut_area;
	}




	public String getTut_anivel() {
		return tut_anivel;
	}




	public void setTut_anivel(String tut_anivel) {
		this.tut_anivel = tut_anivel;
	}







	public double getTut_precio() {
		return tut_precio;
	}




	public String getTut_especialidad() {
		return tut_especialidad;
	}




	public void setTut_especialidad(String tut_especialidad) {
		this.tut_especialidad = tut_especialidad;
	}




	public void setTut_precio(double tut_precio) {
		this.tut_precio = tut_precio;
	}


	public List<Calificacion> getCalificaciones() {
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




	public LogIn getLogIn() {
		return logIn;
	}




	public void setLogIn(LogIn logIn) {
		this.logIn = logIn;
	}

	public void addHorarios(Horarios horario) {
		if(horarios==null)
		horarios = new ArrayList<>();
		horarios.add(horario);
	}




	@Override
	public String toString() {
		return "Tutor [tut_id=" + tut_id + ", tut_nombre=" + tut_nombre + ", tut_apellido=" + tut_apellido
				+ ", tut_cedula=" + tut_cedula + ", tut_telefono=" + tut_telefono + ", tut_mail=" + tut_mail
				+ ", tut_contrasena=" + tut_contrasena + ", tut_area=" + tut_area + ", tut_especialidad="
				+ tut_especialidad + ", tut_anivel=" + tut_anivel + ", tut_precio=" + tut_precio + "]";
	}












	


	
	

}
