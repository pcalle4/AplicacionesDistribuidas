package interciclo.datos;

//Clase Objeto de Acceso a Datos de Tutor
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
		/*Tutor aux = leer(t.getTut_id());
		if(aux!=null) {
			actualizar(t);
		}else {
			insertar(t);
		}*/
		System.out.println("id="+t);
		if(t.getTut_id()!=0) {
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
	
	public Tutor read(int id){
		Tutor tutor = em.find(Tutor.class, id);
		tutor.getTut_cedula();
		tutor.getTut_nombre();
		tutor.getTut_apellido();
		return tutor;
	}
	
	public Tutor getTutorById(Integer id) {
		String sql = "SELECT t FROM Tutor t where tut_id=:id";
	
		Query query = em.createQuery(sql, Tutor.class);
		query.setParameter("id", id);
		Tutor tutor =(Tutor) query.getSingleResult();
		tutor.getTut_cedula();
		tutor.getTut_nombre();
		return tutor;
	}

	/*public Tutor getMateriaByid(Integer id) {
	    
		String sql = "SELECT tut_area FROM Tutor t WHERE tut_id=:id";
		Query query = em.createQuery(sql, Tutor.class);
		query.setParameter("id", id);
		List<Tutor> listado =query.getResultList();
		return listado;
		
	}*/

	
	

}
