package interciclo.modulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="LugarNivelacion")
public class LugarNivelacion implements Serializable {

	@Id
	@TableGenerator(name="tabLugNiv", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabLugNiv")
	@Column(name="lug_codigo")
	private int codigo;
	
	@NotNull
	@NotEmpty
	@Column(name="lug_Lugar")
	private String lugar;
	
	@OneToMany(mappedBy = "lugarNivelaciones")
	private List<SolicitudCita> solicitudCitas;

	
	

	public List<SolicitudCita> getSolicitudCitas() {
		return solicitudCitas;
	}

	public void setSolicitudCitas(List<SolicitudCita> solicitudCitas) {
		this.solicitudCitas = solicitudCitas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	@Override
	public String toString() {
		return "LugarNivelacion [codigo=" + codigo + ", lugar=" + lugar + "]";
	}
	
	
}
