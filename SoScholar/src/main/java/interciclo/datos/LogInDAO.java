package interciclo.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import interciclo.modulos.*;

@Stateless
public class LogInDAO {
	@Inject
	private EntityManager em;
	
	public void Guardar(LogIn l) {
		LogIn aux = leer(l.getCodigo());
		if(aux!=null) {
			Actualizar(l);
		}else {
			Insertar(l);
		}
	}
	
	public void Insertar(LogIn log) {
		em.persist(log);
	}
	public void Actualizar(LogIn log) {
		em.merge(log);
	}
	
	public void Borrar(int id) {
		LogIn log = leer(id);
		em.remove(log);
	}
	
	public LogIn leer(int id) {
		LogIn log = em.find(LogIn.class, id);
		return log;
	}
	
	public List<LogIn> listarLogins(){
		Query query = em.createQuery("SELECT hor FROM Horarios hor", LogIn.class);
		List<LogIn> listado = query.getResultList();
 		return listado;
	}
	
	public boolean usuarioExiste(String email,String contrasena) {
		Query query = em.createQuery("SELECT l FROM LogIn l where log_correo ="+email+" and log_cont="+contrasena+"", LogIn.class);
		return true;
		
	}
}
