package interciclo.modulos;

import java.io.Serializable; 
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SolicitudCita")
public class SolicitudCita implements Serializable{
	
	@Id
	@TableGenerator(name="tabSolCita", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabSolCita")
	@Column(name="sol_codigo")
	private int codigo;
	
	
	//@NotNull
	@Column(name="sol_fecha",length=10)
	//@Size(max=10)
	private Date fecha;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Tutor tutor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	//@JoinColumn(name="est_id", nullable=false)
	private Estudiante estudiante;
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	private Hor_Tut hor_tut;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private LugarNivelacion lugarNivelaciones;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Horarios horarios;
//	
//	@ManyToOne(fetch=FetchType.EAGER)
//	private Precios precios;
//	
	@Column(name="sol_aceptado")
	private String aceptado;
	
	
	
	
	public String getAceptado() {
		return aceptado;
	}

	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public LugarNivelacion getLugarNivelaciones() {
		return lugarNivelaciones;
	}

	public void setLugarNivelaciones(LugarNivelacion lugarNivelaciones) {
		this.lugarNivelaciones = lugarNivelaciones;
	}

	public Horarios getHorarios() {
		return horarios;
	}

	public void setHorarios(Horarios horarios) {
		this.horarios = horarios;
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

//	@Override
//	public String toString() {
//		return "SolicitudCita [codigo=" + codigo + ", fecha=" + fecha + ", tutor=" + tutor + ", estudiante="
//				+ estudiante + ", hor_tut=" + hor_tut + ", lugarNivelaciones=" + lugarNivelaciones + ", precios="
//				+ precios + "]";
//	}
}
