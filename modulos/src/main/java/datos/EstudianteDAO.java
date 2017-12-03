package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modulos.Estudiante;


@Stateless
public class EstudianteDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Estudiante e) {
		Estudiante aux=  leer(e.getId());
		if(aux!=null) {
			actualizar(e);
		}else {
			insertar(e);
		}
	}
	
	public void insertar(Estudiante estudiante) {
		em.persist(estudiante);
	}
	
	public void actualizar(Estudiante estudiante) {
		em.merge(estudiante);
		
	}
	
	public void borrar(int id) {
		Estudiante e=leer(id);
		em.remove(e);
	}
	
	public Estudiante leer(int id) {
		Estudiante e=em.find(Estudiante.class, id);
		return e;
	}
	
	public List<Estudiante> listadoEstudiantes(){
		Query query = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		List<Estudiante> listado = query.getResultList();
		return listado;
	}
	
}
