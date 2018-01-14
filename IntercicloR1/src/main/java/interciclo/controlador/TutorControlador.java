package interciclo.controlador;
//Clase Controlador de Tutor
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;


import interciclo.datos.TutorDAO;
import interciclo.modulos.Estudiante;
import interciclo.modulos.Horarios;
import interciclo.modulos.Tutor;

@ManagedBean
@SessionScoped
public class TutorControlador {

	private Tutor tutor;
	private int id;
	private String impri;
	
	@Inject
	private TutorDAO tdao;
	private List<Tutor>tutores;
	
	
	public List<Tutor> getTutores() {
		return tutores;
	}
	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}
	
	@PostConstruct
	public void init() {
		tutor = new Tutor();
		tutores=new ArrayList<>();
		tutor.addHorarios(new Horarios());
		loadTutor();
		
	
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public void loadTutor() {	//datos de lista
		tutores = tdao.listadoTutor();
	}
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos"+ id);
		tutor = tdao.leer(id);
		return "crearTutor";
	}
	
	public String addHorarios() {
		tutor.addHorarios(new Horarios());
		return null;
	}
	public String nuevo() {
		tutor=new Tutor();
		return "crearTutor";
	}
	public String cancelar() {
		return "listado-tutores";
	}
	public String guardar() {
		System.out.println(tutor);
		tdao.guardarTutor(tutor);
		loadTutor();
		return "listado-tutores";
	}
   public String borrarTutor(int id) {
	   tdao.borrar(id);
	   loadTutor();
	   return "listado-tutores";
   }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String doRead(){
	Tutor orden = tdao.read(this.id);
	System.out.println(orden.toString());
	impri = orden.toString();
	return null;
}


public String doList(){		
	List<Tutor> tutores = tdao.listadoTutor();
	for(Tutor aux : tutores) {
		System.out.println("Tutor=[id="+aux.getTut_id()+", "
				+ "cedula="+aux.getTut_cedula()+","
				+ "nombre="+aux.getTut_nombre()+","
				+ "direccion="+aux.getTut_apellido()+"]");
	}		
	return null;
}

public String getImpri() {
	return impri;
}
public void setImpri(String impri) {
	this.impri = impri;
}

/*public String doFind(){
	Tutor orden = tdao.getMateriaByid(this.id);
	System.out.println(orden.toString());
	impri = orden.toString();
	return null;
}*/

}
