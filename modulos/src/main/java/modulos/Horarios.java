package modulos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Horarios")
public class Horarios {
	
	@Id
	@Column(name="hor_codigo")
	private int codigo;	
	
	@NotNull
	@Column(name="hor_horario")
	private String horario;

	public int getCodigo() {
		return codigo;
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
