package interciclo.modulos;

import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="SolicitudCita")
public class SolicitudCita implements Serializable{
	
	@Id
	@TableGenerator(name="tabSolCita", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabSolCita")
	@Column(name="sol_codigo")
	private int codigo;
	
	
	@NotNull
	@Column(name="sol_fecha",length=10)
	@Size(max=10)
	private String fecha;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Tutor tutor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Estudiante estudiante;
	
	/*
	@ManyToOne(fetch=FetchType.EAGER)
	private Hor_Tut hor_tut;
	*/
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Horarios horarios;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private LugarNivelacion lugarNivelaciones;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Precios precios;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
/*
	public Hor_Tut getHor_tut() {
		return hor_tut;
	}

	public void setHor_tut(Hor_Tut hor_tut) {
		this.hor_tut = hor_tut;
	}
*/
	public LugarNivelacion getLugarNivelaciones() {
		return lugarNivelaciones;
	}

	public void setLugarNivelaciones(LugarNivelacion lugarNivelaciones) {
		this.lugarNivelaciones = lugarNivelaciones;
	}

	public Precios getPrecios() {
		return precios;
	}

	public void setPrecios(Precios precios) {
		this.precios = precios;
	}

	public Horarios getHorarios() {
		return horarios;
	}

	public void setHorarios(Horarios horarios) {
		this.horarios = horarios;
	}
	
	
	

	
}
