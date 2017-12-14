package interciclo.modulos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Academicas {

	@Id
	/*@TableGenerator(name="tabAcademicas", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabAcademicas")*/
	@Column(name = "are_id")
	private int are_id;

	@NotNull
	@Size(min = 1, max = 20)
    @Pattern(regexp = "[^0-9]*", message = "El campo debe contener solo letras")
	@Column(name = "are_nombre")
	private String are_nombre;

	/*@ManyToMany(mappedBy = "academicas")
	private List<Tutor> tutores;*/

	/*@ManyToOne(fetch = FetchType.EAGER)
	private Especialidad especialidad;*/
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="Academicas", referencedColumnName="are_id")
	private List<Especialidad> especialidades;

	
	
	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

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

	public void addEspecialidad(Especialidad especialidad) {
		if(especialidades == null)
			especialidades = new ArrayList<>();
		especialidades.add(especialidad);
	}

	@Override
	public String toString() {
		return "Academicas [are_id=" + are_id + ", are_nombre=" + are_nombre + ", especialidades=" + especialidades
				+ "]";
	}
	
	

}
