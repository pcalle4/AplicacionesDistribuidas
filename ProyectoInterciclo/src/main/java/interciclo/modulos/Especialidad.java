package interciclo.modulos;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Especialidad {

	@Id
	/*@TableGenerator(name="tabEspecialidad", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabEspecialidad")*/
	@Column(name="esp_id")
	private int esp_id;
	
	@NotNull
	@Pattern(regexp = "[^0-9]*", message = "Ingrese solo letras")
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
