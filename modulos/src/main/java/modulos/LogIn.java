package modulos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="LogIn")
public class LogIn {

	@Id
	@Column(name="log_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="log_correo")
	private String correo;
	@NotNull
	@Column(name="log_cont")
	private String cont;
	@NotNull
	@Column(name="log_cod_est")
	//@OneToOne
	private int codest;
	@NotNull
	@Column(name="log_cod_tut")
	//@OneToOne
	private int codtut;
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
	
	
}
