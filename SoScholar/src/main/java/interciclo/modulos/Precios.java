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
	@TableGenerator(name="tabPrecios", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabPrecios")
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((preciototal == null) ? 0 : preciototal.hashCode());
		result = prime * result + ((precioxhora == null) ? 0 : precioxhora.hashCode());
		result = prime * result + ((solicitudCitas == null) ? 0 : solicitudCitas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Precios other = (Precios) obj;
		if (codigo != other.codigo)
			return false;
		if (preciototal == null) {
			if (other.preciototal != null)
				return false;
		} else if (!preciototal.equals(other.preciototal))
			return false;
		if (precioxhora == null) {
			if (other.precioxhora != null)
				return false;
		} else if (!precioxhora.equals(other.precioxhora))
			return false;
		if (solicitudCitas == null) {
			if (other.solicitudCitas != null)
				return false;
		} else if (!solicitudCitas.equals(other.solicitudCitas))
			return false;
		return true;
	}

	@Override	
	public String toString() {
		return "Precios [codigo=" + codigo + ", precioxhora=" + precioxhora + ", preciototal=" + preciototal
				+ "] ->prueba";
	}
}
