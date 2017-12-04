package interciclo.modulos;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Especialidad {

	@Id
	@GeneratedValue
	@Column(name="esp_id")
	private int esp_id;
	
	@NotNull
	@Column(name="esp_nombre")
	private String esp_nombre;

	public int getEsp_id() {
		return esp_id;
	}

	public void setEsp_id(int esp_id) {
		this.esp_id = esp_id;
	}

	public String getEsp_nombre() {
		return esp_nombre;
	}

	public void setEsp_nombre(String esp_nombre) {
		this.esp_nombre = esp_nombre;
	}

	@Override
	public String toString() {
		return "Especialidad [esp_id=" + esp_id + ", esp_nombre=" + esp_nombre + "]";
	}
	
	
}
