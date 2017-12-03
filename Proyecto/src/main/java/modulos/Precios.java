package modulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Precios")
public class Precios implements Serializable {

	@Id
	@Column(name="pre_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="pre_precioxhora")
	private String precioxhora;
	
	@Column(name="pre_total")
	private String preciototal;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="Soli_Cita", referencedColumnName="sol_codigo")
	private List<Soli_Cita> solicita;
	
	

	public List<Soli_Cita> getSolicita() {
		return solicita;
	}

	public void setSolicita(List<Soli_Cita> solicita) {
		this.solicita = solicita;
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
	
	public void addSoliCita(Soli_Cita solicitas) {
		if(solicita == null)
			solicita = new ArrayList<>();
		solicita.add(solicitas);
	}
}
