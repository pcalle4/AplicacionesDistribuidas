package interciclo.datos;
//Clase Objeto de Acceso a Datos de Horario
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import interciclo.modulos.*;


@Stateless
public class HorarioDAO {
	
	@Inject
	private EntityManager em;
	
	public void Guardar(Horarios h) {
		Horarios aux = leer(h.getCodigo());
		if(aux!=null) {
			Actualizar(h);
		}else {
			Insertar(h);
		}
	}
	
	public void Insertar(Horarios hor) {
		em.persist(hor);
	}
	public void Actualizar(Horarios hor) {
		em.merge(hor);
	}
	
	public void Borrar(int id) {
		Horarios hor = leer(id);
		em.remove(hor);
	}
	
	public Horarios leer(int id) {
		Horarios hor = em.find(Horarios.class, id);
		return hor;
	}
	
	public List<Horarios> listarHorarios(){
		Query query = em.createQuery("SELECT hor FROM Horarios hor",Horarios.class);
		List<Horarios> listado = query.getResultList();
 		return listado;
	}
	
	public List<Horarios>ltsHorariosByTutor(String id){
		TypedQuery<Horarios> query = em.createQuery(
	    		"SELECT e FROM Horarios e WHERE e.tutor = "+id, Horarios.class);
	    //query.setParameter("tutor", id);
	    try{
	    	List<Horarios> listado =query.getResultList();
	    	return listado;
	    }catch(NoResultException e){
	    	
	    	return null;
	    }
	}

}
