package interciclo.datos;

//Clase Objeto de Acceso a Datos de Tutor
import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import interciclo.modulos.Estudiante;
import interciclo.modulos.SolicitudCita;
import interciclo.modulos.Tutor;

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
	public List<Tutor>listadoTutor2(){
		String jpql = "SELECT distinct tut FROM Tutor tut";
		Query query = em.createQuery(jpql, Tutor.class);
		List<Tutor> tut = query.getResultList();
		return tut;
	}
	
	
	public Tutor read(int id){
		Tutor tutor = em.find(Tutor.class, id);
		tutor.getTut_cedula();
		tutor.getTut_nombre();
		tutor.getTut_apellido();
		return tutor;
	}
	
	public Tutor getTutorById(Integer id) {
		String sql = "SELECT t FROM Tutor t where t.id=:id";
	
		Query query = em.createQuery(sql, Tutor.class);
		query.setParameter("id", id);
		Tutor tutor =(Tutor) query.getSingleResult();
		tutor.getTut_cedula();
		tutor.getTut_nombre();
		return tutor;
	}

	/*public List<Tutor>ltsTutorByArea(String area){
		TypedQuery<Tutor> query = em.createQuery(
	    		"SELECT t FROM Tutor t WHERE t.tut_area like :tut_area", Tutor.class);
	    query.setParameter("tut_area", area);
	    try{
	    	List<Tutor> listado =query.getResultList();
	    	
	    	return listado;
	    }catch(NoResultException e){
	    	
	    	return null;
	    }*/
	    
		public List<Tutor> listadotutorLog(String un, String pass) {
			String  jpql = "SELECT t FROM Tutor t WHERE t.tut_mail=:un AND t.tut_contrasena=:pass";
			Query query = em.createQuery(jpql, Tutor.class);
			query.setParameter("un", un);
			query.setParameter("pass", pass);
			List<Tutor> listado = query.getResultList(); 
			return listado;
		}
	
	
	public void actualizarPassword(Tutor tutor){
		em.merge(tutor);
		em.merge(tutor.getLogIn());
		
	
	}


}
