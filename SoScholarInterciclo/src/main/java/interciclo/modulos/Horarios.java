package interciclo.modulos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Horarios")
public class Horarios implements Serializable{
	
	@Id
	@TableGenerator(name="tabHorarios", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabHorarios")
	@Column(name="hor_codigo")
	private int codigo;	
	
	@NotNull
	@Column(name="hor_horario")
	private String horario;
	

	@Column(name="hor_precio")
	private Double precio;
	
//	@OneToMany(mappedBy = "horarios")
//	private List<Hor_Tut> hor_Tuts;

	
	public int getCodigo() {
		return codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Horarios [codigo=" + codigo + ", horario=" + horario
				+ "]";
	}
	

}
