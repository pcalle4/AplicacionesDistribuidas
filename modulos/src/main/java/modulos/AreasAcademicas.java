package modulos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AreasAcademicas implements Serializable {

	@Id
	@Column(name="ac_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="ac_nombre")
	private String nombre;
	
	@Column(name="ac_descripcion")
	private String descripcion;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "AreasAcademicas [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
