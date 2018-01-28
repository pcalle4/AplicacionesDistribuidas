package interciclo.modulos;

import java.util.List;

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

@Entity
@Table(name="Hor_Tut")
public class Hor_Tut {
	
	@Id
	@TableGenerator(name="tabHorTut", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabHorTut")
	@Column(name="hor_codigo")
	private int codigo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Tutor tutor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Horarios horarios;
	
//	@OneToMany(mappedBy = "hor_tut")
//	private List<SolicitudCita> solicitudCitas;

	public Hor_Tut() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Horarios getHorarios() {
		return horarios;
	}

	public void setHorarios(Horarios horarios) {
		this.horarios = horarios;
	}

//	public List<SolicitudCita> getSolicitudCitas() {
//		return solicitudCitas;
//	}
//
//	public void setSolicitudCitas(List<SolicitudCita> solicitudCitas) {
//		this.solicitudCitas = solicitudCitas;
//	}

	@Override
	public String toString() {
		return "Hor_Tut [codigo=" + codigo + "]";
	}
	
	

}
