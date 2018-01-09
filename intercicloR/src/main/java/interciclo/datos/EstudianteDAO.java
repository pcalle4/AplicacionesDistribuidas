package interciclo.datos;
//Clase Objeto de Acceso a Datos de Estudidiante
import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import interciclo.modulos.Estudiante;

@Stateless
public class EstudianteDAO {

	@Inject
	private EntityManager em;
	
	public void guardarEstudiante(Estudiante est) {
		Estudiante aux = leer(est.getEst_id());
		/*if(aux!=null) {
			actualizar(est);
		}else {
			insertar(est);
		}*/
		//add
		System.out.println("id="+est);
		if(est.getEst_id()!=0) {
			actualizar(est);
		}else {
			insertar(est);
		}//add
	}
	public void insertar (Estudiante est) {
		em.persist(est);
	}
	public void actualizar (Estudiante est) {
		em.merge(est);
	}
	public void borrar(int id) {
		Estudiante est = leer(id);
		em.remove(est);
	}
	public Estudiante leer(int id) {
		Estudiante est = em.find(Estudiante.class, id);
		return est;
	}
	public List<Estudiante>listadoEstudiante(){
		Query query = em.createQuery("SELECT est FROM Estudiante est", Estudiante.class);
		List<Estudiante> listado = query.getResultList();
		return listado;
	}
	
	
	public Estudiante read(int id){
		Estudiante estudiante = em.find(Estudiante.class, id);
		estudiante.getEst_nombre();
		estudiante.getEst_apellido();
		return estudiante;
	}
	
	/*public Estudiante read2(int id){
		Estudiante est = em.find(Estudiante.class, id);
		categoria.getProductos().size();
		return categoria;
	}*/
	
	public List<Estudiante> getEstudiantes(){
		String jpql = "SELECT est FROM Estudiante est JOIN FETCH est.id est";
		Query query = em.createQuery(jpql, Estudiante.class);
		List<Estudiante> categorias = query.getResultList();
		return categorias;
	}
	public List<Estudiante> getEstudiantes2(){
		String jpql = "SELECT distinct est FROM Estudiante est";
		Query query = em.createQuery(jpql, Estudiante.class);
		List<Estudiante> ests = query.getResultList();
		return ests;
	}
}
