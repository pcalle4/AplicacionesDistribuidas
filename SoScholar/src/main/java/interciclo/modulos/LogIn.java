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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="LogIn")
public class LogIn implements Serializable {

	@Id
	@SequenceGenerator(name = "LOGIN_ID_GENERATOR",sequenceName = "LOG_CON_ID")
	@TableGenerator(name="tabLogIn", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tabLogIn")
	@Column(name="log_codigo")
	private int codigo;
	
	@NotNull(message="*Campo obligatorio. Ingresar el correo del usuario por favor.")
	@Column(name="log_correo")
	private String correo;
	@NotNull(message="*Campo obligatorio. Ingresar el password del usuario  por favor.")
	@Column(name="log_cont")
	private String cont;
	
	private boolean temporal;
	
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
	
	public boolean isTemporal() {
		return temporal;
	}
	public void setTemporal(boolean temporal) {
		this.temporal = temporal;
	}
	@Override
	public String toString() {
		return "LogIn [codigo=" + codigo + ", correo=" + correo + ", cont=" + cont + ", temporal=" + temporal
				+ ", tutor=" + tutor + ", estudiante=" + estudiante + "]";
	}
	
	
	
	
}
