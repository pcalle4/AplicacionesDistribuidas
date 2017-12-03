package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modulos.Calificacion;


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
}
