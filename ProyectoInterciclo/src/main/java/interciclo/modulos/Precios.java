package interciclo.modulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Precios")
public class Precios implements Serializable {

	@Id
	//@GeneratedValue
	@Column(name="pre_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="pre_precioxhora")
	private String precioxhora;
	
	@Column(name="pre_total")
	private String preciototal;
	
	@OneToMany(mappedBy = "precios")
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

	
	public String getPrecioxhora() {
		return precioxhora;
	}

	public void setPrecioxhora(String precioxhora) {
		this.precioxhora = precioxhora;
	}

	public String getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(String preciototal) {
		this.preciototal = preciototal;
	}
	 

	@Override	
	public String toString() {
		return "Precios [codigo=" + codigo + ", precioxhora=" + precioxhora + ", preciototal=" + preciototal
				+ "]";
	}
}
