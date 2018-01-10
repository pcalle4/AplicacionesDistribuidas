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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="SolicitudCita")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SolicitudCita implements Serializable{
	
	@Id
	@TableGenerator(name="tabSolCita", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabSolCita")
	@Column(name="sol_codigo")
	private int codigo;
	
	
	@NotNull
	@Column(name="sol_fecha",length=10)
	@Size(max=10)
	private Date fecha;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Tutor tutor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Estudiante estudiante;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Hor_Tut hor_tut;
	
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	

	
}
