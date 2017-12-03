package modulos;

import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="SolicitudCita")
public class SolicitudCita implements Serializable{
	
	@Id
	@Column(name="sol_codigo")
	private int codigo;
	
	@NotNull
	@ManyToOne
	@Column(name="sol_cod_est")
	private int codest;
	
	@NotNull
	@ManyToOne
	@Column(name="sol_cod_tut")
	private int codtut;
	
	@NotNull
	@Column(name="sol_fecha",length=10)
	@Size(max=10)
	private Date fecha;
	
	
	@NotNull
	@ManyToOne
	@Column(name="sol_cod_lugar")
	private int lugar;
	
	@NotNull
	@ManyToOne
	@Column(name="sol_cod_precio")
	private int precio;
	
	@NotNull
	@ManyToOne
	@Column(name="sol_cod_hor")
	private int horario;
	
	@NotNull
	@ManyToOne
	@Column(name="sol_cod")
	private int horatutor;

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getLugar() {
		return lugar;
	}
	public void setLugar(int lugar) {
		this.lugar = lugar;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getCodest() {
		return codest;
	}

	public void setCodest(int codest) {
		this.codest = codest;
	}

	public int getCodtut() {
		return codtut;
	}

	public void setCodtut(int codtut) {
		this.codtut = codtut;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public int getHoratutor() {
		return horatutor;
	}

	public void setHoratutor(int horatutor) {
		this.horatutor = horatutor;
	}

	@Override
	public String toString() {
		return "SolicitudCita [codigo=" + codigo + ", fecha=" + fecha + ", lugar=" + lugar + ", precio=" + precio + "]";
	}
	
}
