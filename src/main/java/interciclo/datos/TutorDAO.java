package interciclo.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import interciclo.modulos.Tutor;

@Stateless
public class TutorDAO {

	@Inject
	private EntityManager em;
	
	public void guardarTutor(Tutor t) {
		Tutor aux = leer(t.getTut_id());
		if(aux!=null) {
			actualizar(t);
		}else {
			insertar(t);
		}
	}
	public void insertar (Tutor t) {
		em.persist(t);
	}
	public void actualizar (Tutor t) {
		em.merge(t);
	}
	public void borrar(int id) {
		Tutor t = leer(id);
		em.remove(t);
		
	}
	public Tutor leer(int id) {
		Tutor t = em.find(Tutor.class, id);
		return t;
	}
	public List<Tutor>listadoTutor(){
		Query query = em.createQuery("SELECT t FROM Tutor t", Tutor.class);
		List<Tutor> listado =query.getResultList();
		return listado;
	}
}
