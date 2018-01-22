package interciclo.controlador;
import java.io.IOException;
//Clase Controlador de Tutor
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    
	private Tutor tutorActual;
	private String usuarioAdmin;
	private String claveAdmin;
	
	private String usuarioActual;
	private String passwordActual;
	private String passwordNuevo;
	private String passwordNuevo2;
	private String correoRecuperar;
	@Inject
	private TutorDAO tdao;
	private List<Tutor>tutores;
	
	private List<Tutor>ltsBusquedatutores = new ArrayList<>();
	private String area="";
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

public List<Tutor> getTutores1(){
	tutores = tdao.listadoTutor();
	System.out.println("Size: "+ tutores.size());
	System.out.println(tutores);
	return tutores;
	
}

public void setTutores1(List<Tutor> tutores) {
	this.tutores=tutores;
}

public String getImpri() {
	return impri;
}
public void setImpri(String impri) {
	this.impri = impri;
}

///metodos para la busqueda

	public void buscarTutor(){
		ltsBusquedatutores = tdao.ltsTutorByArea(area);
		
	}
	
	public void gestionarEstudiantes(Tutor tutor) {
		try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tutor", tutor);
                FacesContext contex = FacesContext.getCurrentInstance();
                contex.getExternalContext().redirect("asignarestudiante.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Tutor.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public String logear(){
		List<Tutor> usuarios = this.getTutores1();
		
		boolean encontrado = false;
		
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getTut_mail().equals(usuarioActual) && usuarios.get(i).getTut_contrasena().equals(passwordActual)){
				encontrado = true;
				 
				 tutorActual = tdao.read(usuarios.get(i).getTut_id());
			}
		}
		if(encontrado){
			return "listado-especialidades";
		}else{
			return "fallo";
		}
	}
	
	public String logearAdmin(){
		
		System.out.println(usuarioAdmin + " - "+claveAdmin);
		if(usuarioAdmin.equals("root") && claveAdmin.equals("root")){
			return "homepage";
		}else{
			return "fallo";
		}
	}
	
	public String cambiarPassword(){
		List<Tutor> usuarios = this.getTutores1();
		boolean encontrado = false;
		
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getLogIn().getCorreo().equals(usuarioActual) && usuarios.get(i).getLogIn().getCont().equals(passwordActual)){
				encontrado = true;
				tutorActual= usuarios.get(i);
			}
		}
		if(encontrado && passwordNuevo.equals(passwordNuevo2)){
			tutorActual.getLogIn().setCont(passwordNuevo);
			tdao.actualizarPassword(tutorActual);
			return "cambioCorrecto";
		}else{
			return "cambioIncorrecto";
		}
	}
	
	public String recuperar(){
		List<Tutor> usuarios = this.getTutores1();
		boolean encontrado = false;
		
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getTut_mail().equals(correoRecuperar)){
				encontrado = true;
				tutorActual = usuarios.get(i);
			}
		}
		
		if(encontrado){
			String generated = generarPasswordAleatorio();
			tutorActual.getLogIn().setCont(generated);
			tdao.actualizarPassword(tutorActual);
			System.out.println("Su nuevo password es: "+generated);
			return "cambioCorrecto2";
		}else{
			return "cambioIncorrecto2";
		}
	}
	
	public String generarPasswordAleatorio(){
		String cadena = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < 6){
			char c = (char)r.nextInt(255);
			if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
				cadena+= c;
				i ++;
			}
		}
		return cadena;
	}
	
	public Tutor getTutorActual() {
		return tutorActual;
	}
	public void setTutorActual(Tutor tutorActual) {
		this.tutorActual = tutorActual;
	}
	public String getUsuarioAdmin() {
		return usuarioAdmin;
	}
	public void setUsuarioAdmin(String usuarioAdmin) {
		this.usuarioAdmin = usuarioAdmin;
	}
	public String getClaveAdmin() {
		return claveAdmin;
	}
	public void setClaveAdmin(String claveAdmin) {
		this.claveAdmin = claveAdmin;
	}
	public List<Tutor> getLtsBusquedatutores() {
		return ltsBusquedatutores;
	}
	public void setLtsBusquedatutores(List<Tutor> ltsBusquedatutores) {
		this.ltsBusquedatutores = ltsBusquedatutores;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPasswordNuevo() {
		return passwordNuevo;
	}
	public void setPasswordNuevo(String passwordNuevo) {
		this.passwordNuevo = passwordNuevo;
	}
	public String getPasswordNuevo2() {
		return passwordNuevo2;
	}
	public void setPasswordNuevo2(String passwordNuevo2) {
		this.passwordNuevo2 = passwordNuevo2;
	}
	public String getCorreoRecuperar() {
		return correoRecuperar;
	}
	public void setCorreoRecuperar(String correoRecuperar) {
		this.correoRecuperar = correoRecuperar;
	}
	public String getUsuarioActual() {
		return usuarioActual;
	}
	public void setUsuarioActual(String usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	public String getPasswordActual() {
		return passwordActual;
	}
	public void setPasswordActual(String passwordActual) {
		this.passwordActual = passwordActual;
	}
   
	

	
}
