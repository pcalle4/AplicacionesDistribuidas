package interciclo.modulos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="LogIn")
public class LogIn implements Serializable {

	@Id
	@TableGenerator(name="tabLogin", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabLogin")
	@Column(name="log_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="log_correo")
	private String correo;
	@NotNull
	@Column(name="log_cont")
	private String cont;
	
	
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="logIn")
	private Tutor tutor;
	
	/*@ManyToOne
	private Tutor tutor;*/
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="logIn")
	private Estudiante estudiante;
	
	
	
	/*@ManyToOne
	private Estudiante estudiante;*/
	
	public LogIn() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
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
	
	@Override
	public String toString() {
		return "LogIn [codigo=" + codigo + ", correo=" + correo + ", cont=" + cont + "]";
	}
	
	
	
}
