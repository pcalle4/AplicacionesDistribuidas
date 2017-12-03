package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modulos.LugarNivelacion;

@Stateless
public class LugaNiveDAO {

	@Inject
	private EntityManager em;
	
	public void guardar(LugarNivelacion lv) {
		LugarNivelacion aux = leer(lv.getCodigo());
		if(aux!=null) {
			actualizar(lv);
		}else {
			insertar(lv);
		}
	}
	public void insertar(LugarNivelacion lv) {
		em.persist(lv);
	}
	
	public void actualizar(LugarNivelacion lv) {
		em.merge(lv);
	}
	
	public void borrar(int id) {
		LugarNivelacion lv = leer(id);
		em.remove(lv);
	}
	
	public LugarNivelacion  leer(int id) {
		LugarNivelacion lv = em.find(LugarNivelacion.class, id);
		return lv;
	}
	
	public List<LugarNivelacion> listadoLugNive(){
		Query query = em.createQuery("SELECT lv FROM LugarNivelacion lv", LugarNivelacion.class);
		List<LugarNivelacion> listalv = query.getResultList();
		return listalv;
	}
}
