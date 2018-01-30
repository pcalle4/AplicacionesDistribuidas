package interciclo.datos;
import java.util.ArrayList;
//Clase Objeto de Acceso a Datos de Calificaciones
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import interciclo.modulos.*;


@Stateless
public class CalificacionDAO {

	@Inject
	private EntityManager em;
	
	public void guardar(Calificacion c) {
		Calificacion aux = leer(c.getCodigo());
				if(aux!=null) {
					actualizar(c);
				}else {
					insertar(c);
				}
	}
	
	public void insertar(Calificacion calificacion) {
		em.persist(calificacion);
	}
	
	public void actualizar(Calificacion calificacion) {
		em.merge(calificacion);
	}
	
	public void borrar(int id) {
		Calificacion c=leer(id);
		em.remove(c);
	}
	

	public Calificacion leer(int id) {
			Calificacion c=em.find(Calificacion.class, id);
			return c;
	}
	
	public List<Calificacion> listadoCalificaciones(){
		Query query = em.createQuery("SELECT c FROM Calificacion c", Calificacion.class);
		List<Calificacion> listado = query.getResultList();
		return listado;
	}
	
	public List<Calificacion> listacalif(SolicitudCita sc, Estudiante est) {
		String  jpql = "SELECT c FROM Calificacion c";
		Query query = em.createQuery(jpql, Calificacion.class);
		List<Calificacion> listado = query.getResultList(); 
		
		ArrayList<Calificacion> lc = new ArrayList<Calificacion>();
		if(listado.size()>0) {
			for(Calificacion cal:listado) {
				if(cal.getEstudiante()!=null) {
				if (cal.getSolicitudCita().getCodigo()==sc.getCodigo()&&cal.getEstudiante().getEst_id()==est.getEst_id()) {
					lc.add(cal);
				}
				}
			}
		}
		return lc;
	}
	public List<Calificacion> listacalifT(SolicitudCita sc, Tutor tut) {
		String  jpql = "SELECT c FROM Calificacion c";
		Query query = em.createQuery(jpql, Calificacion.class);
		List<Calificacion> listado = query.getResultList(); 
		
		ArrayList<Calificacion> lc = new ArrayList<Calificacion>();
			if(listado.size()>0) {
				for(Calificacion cal:listado) {
					if(cal.getTutor()!=null) {
					if (cal.getSolicitudCita().getCodigo()==sc.getCodigo()&&cal.getTutor().getTut_id()==tut.getTut_id()) {
						lc.add(cal);
					}
					}
				}
			}
			
		return lc;
	}
	public List<Calificacion> listadoComentarios(){
		Query query = em.createQuery("SELECT esp_descripcion FROM Calificacion", Calificacion.class);
		List<Calificacion> listado = query.getResultList();
		return listado;
	}
	
public List<Calificacion> getComentarios(int id) {
		
		
		String sql = "SELECT c FROM Calificacion c WHERE c.tutor.id=:id";
		Query query = em.createQuery(sql, Calificacion.class);
		query.setParameter("id", id);
		List<Calificacion> listado = query.getResultList();
		
		return listado;
		
}

public List<String> getComenta(int id) {
	
	List<String> comentarios = new ArrayList<>();
	String sql = "SELECT c FROM Calificacion c WHERE c.tutor.id=:id";
	Query query = em.createQuery(sql, Calificacion.class);
	query.setParameter("id", id);
	List<Calificacion> listado = query.getResultList();
	
	for(int i=0;i<listado.size();i++) {
		comentarios.add(listado.get(i).getDescripcion());
	}
	
	return comentarios;

}
}
