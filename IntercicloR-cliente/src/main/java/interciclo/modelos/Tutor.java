package interciclo.modelos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tutor implements Serializable{
	
	private int tut_id;
	private String tut_nombre;
	private String tut_apellido;
	private String tut_cedula;
	private String tut_area;
	private String tut_especialidad;
	private String tut_mail;
	
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
	public String getTut_area() {
		return tut_area;
	}
	public void setTut_area(String tut_area) {
		this.tut_area = tut_area;
	}
	public String getTut_especialidad() {
		return tut_especialidad;
	}
	public void setTut_especialidad(String tut_especialidad) {
		this.tut_especialidad = tut_especialidad;
	}
	public String getTut_mail() {
		return tut_mail;
	}
	public void setTut_mail(String tut_mail) {
		this.tut_mail = tut_mail;
	}
	@Override
	public String toString() {
		return "Tutor [tut_id=" + tut_id + ", tut_nombre=" + tut_nombre + ", tut_apellido=" + tut_apellido
				+ ", tut_cedula=" + tut_cedula + ", tut_area=" + tut_area + ", tut_especialidad=" + tut_especialidad
				+ ", tut_mail=" + tut_mail + "]";
	}
	
	
	
	

}
