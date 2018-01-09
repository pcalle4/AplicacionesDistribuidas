package interciclo.modulos;
import javax.persistence.Column;
public class EstudianteLs {
	
	private Integer est_id;
	private String est_nombre;
	private String est_apellido;
	public Integer getEst_id() {
		return est_id;
	}
	public void setEst_id(Integer est_id) {
		this.est_id = est_id;
	}
	public String getEst_nombre() {
		return est_nombre;
	}
	public void setEst_nombre(String est_nombre) {
		this.est_nombre = est_nombre;
	}
	public String getEst_apellido() {
		return est_apellido;
	}
	public void setEst_apellido(String est_apellido) {
		this.est_apellido = est_apellido;
	}
	
	

}
