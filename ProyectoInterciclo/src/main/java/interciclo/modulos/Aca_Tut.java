/*package interciclo.modulos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Aca_Tut")
public class Aca_Tut {
	
	@Id
	//@GeneratedValue
	@Column(name="hor_codigo")
	private int codigo;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="Hor_Tut", referencedColumnName="hor_codigo")
	private List<Academicas> academica;
		
	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="Hor_Tut", referencedColumnName="hor_codigo")
	private List<Tutor>tutores;
	
/*	@ManyToOne(fetch=FetchType.EAGER)
	private Tutor tutor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Horarios horarios;
	
	@OneToMany(mappedBy = "hor_tut")
	private List<SolicitudCita> solicitudCitas;

	public Hor_Tut() {
		super();
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

	public List<SolicitudCita> getSolicitudCitas() {
		return solicitudCitas;
	}

	public void setSolicitudCitas(List<SolicitudCita> solicitudCitas) {
		this.solicitudCitas = solicitudCitas;
	}

	
	public List<Academicas> getAcademica() {
		return academica;
	}

	public void setAcademica(List<Academicas> academica) {
		this.academica = academica;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public void addAcademica(Academicas academicaas) {
		if(academica == null)
			academica = new ArrayList<>();
		academica.add(academicaas);
	}
	
	public void addTutor(Tutor tutors) {
		if(tutores == null)
			tutores = new ArrayList<>();
		tutores.add(tutors);
	}
	
	@Override
	public String toString() {
		return "Hor_Tut [codigo=" + codigo + "]";
	}
	
	

}*/
