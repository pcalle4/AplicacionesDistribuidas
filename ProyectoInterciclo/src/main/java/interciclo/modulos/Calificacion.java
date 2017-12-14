package interciclo.modulos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Calificacion implements Serializable {

	@Id
	//@GeneratedValue
	@Column(name="esp_codigo")
	private int codigo;
	
	@NotNull
	@Digits(fraction = 0, integer = 12)
	@Column(name="esp_calificacion",length=1)
	private int esp_calificacion;
	
	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Ingrese solo letras")
	@Column(name="esp_descripcion")
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Tutor tutor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Estudiante estudiante;
	
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getEsp_calificacion() {
		return esp_calificacion;
	}
	public void setEsp_calificacion(int esp_calificacion) {
		this.esp_calificacion = esp_calificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Especialidad [codigo=" + codigo + ", calificacion=" + esp_calificacion + ", descripcion=" + descripcion
				+ "]";
	}
	
	
}
