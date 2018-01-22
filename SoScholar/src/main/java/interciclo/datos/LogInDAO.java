package interciclo.datos;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import interciclo.modulos.*;

@Stateless
public class LogInDAO {
	
	@Inject
	private Logger log;

	@Inject
	private EntityManager em;
	
	public void Guardar(LogIn l) {

		em.persist(l);
		
	}
	
	public void Insertar(LogIn log) {
		em.persist(log);
	}
	public void Actualizar(LogIn log) {
		em.getTransaction().begin();
		if(em.getTransaction().isActive()){
			em.merge(log);
			em.getTransaction().commit();
		}
		else
		{
			em.getTransaction().rollback();
		}
	}
	
	public void Borrar(int id) {
		em.getTransaction().begin();
		if(em.getTransaction().isActive()){
			LogIn  login =em.find(LogIn.class, id);
			em.remove(login );
			em.getTransaction().commit();
			
		}
	}
	
	public LogIn leer(String usuario) {
		return  em.find(LogIn.class, usuario);
		
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
