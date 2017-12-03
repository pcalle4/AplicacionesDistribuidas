package modulos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Calificacion implements Serializable {

	@Id
	@Column(name="esp_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="esp_calificacion",length=1)
	private int calificacion;
	
	@NotNull
	@Column(name="esp_descripcion")
	private String descripcion;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Especialidad [codigo=" + codigo + ", calificacion=" + calificacion + ", descripcion=" + descripcion
				+ "]";
	}
	
	
}
