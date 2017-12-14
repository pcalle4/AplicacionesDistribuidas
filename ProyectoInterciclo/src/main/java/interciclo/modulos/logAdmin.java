package interciclo.modulos;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import interciclo.datos.logAdminDAO;

@ManagedBean
@RequestScoped
public class logAdmin {

	
	@Id
	//@GeneratedValue
	@Column(name="adminid")
	private int adminid;
	
	@NotNull
	@Column(name="adminuser")
	private String adminuser;
	
	@NotNull
	@Column(name="adminpass")
	private String adminpass;

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminuser() {
		return adminuser;
	}

	public void setAdminuser(String adminuser) {
		this.adminuser = adminuser;
	}

	public String getAdminpass() {
		return adminpass;
	}

	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}

	@Override
	public String toString() {
		return "logAdmin [adminid=" + adminid + ", adminuser=" + adminuser + ", adminpass=" + adminpass + "]";
	}
	
	
	public String datos(){
		
		String admin=adminuser;
		String pass= adminpass;
		System.out.println(admin);
		System.out.println(pass);
	
		
		return null;
	}
	
}
