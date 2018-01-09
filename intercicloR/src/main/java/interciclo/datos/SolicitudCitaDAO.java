package interciclo.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import interciclo.modulos.*;

@Stateless
public class SolicitudCitaDAO {
	
	@Inject
	private EntityManager em;
	
	public void Guardar(SolicitudCita sol) {
		SolicitudCita aux = leer(sol.getCodigo());
		if (aux!=null) {
			Actualizar(sol);	
		} else {
			Insertar(sol);
		}
	}
	
	public void Insertar(SolicitudCita sol) {
		em.persist(sol);
	}
	public void Actualizar(SolicitudCita sol) {
		em.merge(sol);
	}
	public void borrar(int id) {
		SolicitudCita sol = leer(id);
		em.remove(sol);
	}
	public SolicitudCita leer(int id) {
		SolicitudCita sol = em.find(SolicitudCita.class, id);
		return sol;
	}
	
	public List<SolicitudCita> listarSolicitud(){
		Query query = em.createQuery("SELECT sol FROM SolicitudCita sol", SolicitudCita.class);
		List<SolicitudCita> listado = query.getResultList();
 		return listado;
	}

}
