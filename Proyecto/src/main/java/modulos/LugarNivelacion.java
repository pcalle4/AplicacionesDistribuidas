package modulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="LugarNivelacion")
public class LugarNivelacion implements Serializable {

	@Id
	@NotNull
	@Column(name="lug_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="lug_Lugar")
	private String lugar;
	
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
	
	public void addSoliCita(Soli_Cita solicitas) {
		if(solicita == null)
			solicita = new ArrayList<>();
		solicita.add(solicitas);
	}
}
