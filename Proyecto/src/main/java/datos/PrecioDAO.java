package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modulos.Precios;

@Stateless
public class PrecioDAO {

	@Inject
	private EntityManager em;
	
	public void guardar(Precios p) {
		Precios aux = leer(p.getCodigo());
		if(aux!=null) {
			actualizar(p);
		}else {
			insertar(p);
		}
	}
	public void insertar(Precios p) {
		em.persist(p);
	}
	
	public void actualizar(Precios p) {
		em.merge(p);
	}
	
	public void borrar(int id) {
		Precios p = leer(id);
		em.remove(p);
	}
	
	public Precios leer(int id) {
		Precios p = em.find(Precios.class, id);
		return p;
	}
	
	public List<Precios> listadoPrecios(){
		Query query = em.createQuery("SELECT p FROM Precios p", Precios.class);
		List<Precios> listadop = query.getResultList();
		return listadop;
	}
	
	
}
