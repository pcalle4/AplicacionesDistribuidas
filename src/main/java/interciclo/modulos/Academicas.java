package interciclo.modulos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Academicas {

	
	@Id
	@GeneratedValue
	@Column(name="are_id")
	private int are_id;
	
	@NotNull
	@Column(name="are_nombre")
	private String are_nombre;

	
	public int getAre_id() {
		return are_id;
	}



	public void setAre_id(int are_id) {
		this.are_id = are_id;
	}



	public String getAre_nombre() {
		return are_nombre;
	}



	public void setAre_nombre(String are_nombre) {
		this.are_nombre = are_nombre;
	}



	@Override
	public String toString() {
		return "Academicas [are_id=" + are_id + ", are_nombre=" + are_nombre + "]";
	}



	
	
	
}
