package interciclo.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import interciclo.modulos.Academicas;

@Stateless
public class AcademicasDAO {

	@Inject
	private EntityManager em;
	
	public void guardarAcademica(Academicas ar) {
		Academicas aux = leer(ar.getAre_id());
		if(aux!=null) {
			actualizar(ar);
		}else {
			insertar(ar);
		}
	}
	public void insertar(Academicas ar) {
		em.persist(ar);
	}
	public void actualizar (Academicas ar) {
		em.merge(ar);
	}
	public void borrar(int id) {
		Academicas ar = leer(id);
		em.remove(ar);
	}
	public Academicas leer(int id) {
		Academicas ar = em.find(Academicas.class, id);
		return ar;
	}
	public List<Academicas>listadoAcademicas(){
		Query query = em.createQuery("SELECT ar FROM Academicas ar",Academicas.class);
		List<Academicas> listado = query.getResultList();
		return listado;
	}
	
}
