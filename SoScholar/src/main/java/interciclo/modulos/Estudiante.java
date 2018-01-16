package interciclo.modulos;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.TableGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity// Anotación que indica que la clase es una entidad 
@Table(name="Estudiante")// Designación del nombre de la tabla
public class Estudiante implements Serializable {// Implementes serializable indica en una secuencia de bytes que pueden ser posteriormente leídos para restaurar el objeto original.

	@Id// Anotación que indica que el campo id es un primary key 
	@TableGenerator(name="tabEstudiante", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabEstudiante")// Anotación que indica la autoincrementación en el campo id 
	@Column(name = "est_id")//Anotación que designa el nombre del campo.
	private int est_id;//Declaración de la variable que representa el id dela tabla de tipo int.

	@NotNull//Anotación que indica que el campo no puede quedar vacío.
	@Pattern(regexp = "[^0-9]*", message = "El campo debe contener solo letras")//Validación mediante una expresión regular que indica que el campo debe contener solo letras.
	@Column(name = "est_nombre")//Anotación que designa el nombre del campo.
	private String est_nombre;// Declaración de la variable que representa el nombre en este caso del estudiante de tipo String.

	@NotNull//Anotación que indica que el campo no puede quedar en blanco.
	@Pattern(regexp = "[^0-9]*", message = "El campo debe contener solo letras")//Validación mediante una expresión regular que indica que el campo debe contener solo letras.
	@Column(name = "est_apellido")//Anotación que designa el nombre del campo.
	private String est_apellido;//Declaración de la variable que representa el apellido en este caso del estudiante de tipo String.

	@NotNull//Anotación que indica que el campo no puede quedar vacío.
	@Digits(fraction = 0, integer = 10)
	@Column(name = "est_cedula", length=10)//Anotación que designa el nombre de la columna y validación para que el campo tenga un tamaño unicamente de 
	private String est_cedula;//Declaración de la variable que representa la cédula en este caso del estudiante de tipo String.

	@NotNull//Anotación que indica que el campo no puede quedar vacío.
	@Digits(fraction = 0, integer = 12)// Validación del campo para que unicamente se puedan ingresar números.
	@Column(name = "est_telefono")//Anotación que designa el nombre del campo.
	private String est_telefono;//Declaración de la variable que representa el teléfono en este caso del estudiante de tipo String.

	@NotNull//Anotación que indica que el campo no puede quedar vacío.
	@Email//Anotación que valida que el email ingresado sea válido.
	@Column(name = "est_mail")//Anotación que designa el nombre del campo.
	private String est_mail;//Declaración de la variable que representa el mail en este caso del estudiante de tipo String.

	@NotNull//Anotación que indica que el campo no puede quedar vacío.
	@NotEmpty
	@Column(name = "est_contrasena")//Anotación que designa el nombre del campo.
	private String est_contrasena;//Declaración de la variable que representa la contraseña en este caso del estudiante de tipo String.

	@OneToMany(mappedBy = "estudiante")//Anotación que indica la creación de una relación de uno a muchos que va desde esta tabla con destino a otra.
	private List<Calificacion> calificaciones;// Creación de una lista para poder almacenar varios datos que se registren producto de la relación antes creada.

	@OneToOne(fetch = FetchType.EAGER)// Anotación que indica la creación de una relación de uno a uno que viene desde la tabla Login.
	private LogIn logIn;

	/*
	@OneToMany(mappedBy = "estudiante") 
	private List<LogIn> logIns;*/
	 

	@OneToMany(mappedBy = "estudiante")//Anotación que indica la creación de la relación uno a muchos con la tabla Solicitud citas.
	private List<SolicitudCita> solicitudCitas;// Creación de una lista para poder almacenar varios datos que se registren producto de la relación antes creada.
	
	public Estudiante() {// Creación de un constructor para la tabla Estudiante.
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEst_id() {// Métodos getters y setters Getters se utiliza para definir una propieda y Setters
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

	@Override
	public String toString() {
		return "EstudianteControlador [est_id=" + est_id + ", est_nombre=" + est_nombre + ", est_apellido="
				+ est_apellido + ", est_cedula=" + est_cedula + ", est_telefono=" + est_telefono + ", est_mail="
				+ est_mail + ", est_contrasena=" + est_contrasena + "]";
	}

}
