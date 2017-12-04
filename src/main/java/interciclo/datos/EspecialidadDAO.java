package interciclo.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import interciclo.modulos.Especialidad;

@Stateless
public class EspecialidadDAO {

	@Inject
	private EntityManager em;
	
	public void guardarEspecialidad(Especialidad e) {
		Especialidad aux = leer(e.getEsp_id());
		if(aux!=null) {
			actualizar(e);
		}else {
			insertar(e);
		}
	}
	public void insertar(Especialidad e) {
		em.persist(e);
	}
	public void actualizar (Especialidad e) {
		em.merge(e);
	}
	public void borrar(int id) {
		Especialidad e = leer(id);
		em.remove(e);
	}
	public Especialidad leer(int id) {
		Especialidad e = em.find(Especialidad.class, id);
		return e;
	}
	public List<Especialidad>listadoEspecialidad(){
		Query query = em.createQuery("SELECT e FROM Especialidad e", Especialidad.class);
		List<Especialidad> listado = query.getResultList();
		return listado;
	}
}
