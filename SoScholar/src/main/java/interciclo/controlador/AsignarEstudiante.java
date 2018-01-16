package interciclo.controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import interciclo.datos.EstudianteDAO;
import interciclo.datos.HorarioDAO;
import interciclo.datos.LugaNiveDAO;
import interciclo.datos.PrecioDAO;
import interciclo.datos.SolicitudCitaDAO;
import interciclo.modulos.Estudiante;
import interciclo.modulos.Horarios;
import interciclo.modulos.LugarNivelacion;
import interciclo.modulos.Precios;
import interciclo.modulos.SolicitudCita;
import interciclo.modulos.Tutor;

@ManagedBean
@SessionScoped
//@FacesConverter(forClass = Precios.class)
public class AsignarEstudiante{
	
	@Inject
	private EstudianteDAO estudianteDAO;
	
	@Inject
	private LugaNiveDAO lugaNiveDAO;
	
	@Inject
	private PrecioDAO precioDAO;
	
	@Inject
	private HorarioDAO horarioDAO;
	
	@Inject
	private SolicitudCitaDAO solicitudCitaDAO;
	
	private Tutor tutor;
	private SolicitudCita solicitudCita;
	
	
	private int idprecio;
	private int idlugar;
	private int idhorario;
	
	private String nombreEstudiante;
	private List<Estudiante> ltsEstudiantes;
	private Estudiante studentSelected;
	private List<LugarNivelacion> ltslugar;
	private List<Precios> ltsPrecio;
	private List<Horarios> ltsHora;
	
	
	public AsignarEstudiante(){
		
	        
	}
	
	 @PostConstruct
	 public void init() {
		 
		 try {
	            tutor=new Tutor();
	            tutor = (Tutor) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tutor");
	            //listarNotas(usuarioNivel.getId());
	            
	            ltsHora = tutor.getHorarios();
	            ltslugar = lugaNiveDAO.listadoLugNive();
	            ltsPrecio = precioDAO.listadoPrecios();
	   		 	for(int i=0;i<ltsHora.size();i++){
	   		 		System.out.println(ltsHora.get(i).getHorario());
	   		 	}
	        } catch (Exception ex) {
	            Logger.getLogger(AsignarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
	        }
	 }
	
	public void ltsStudenbyid(){
		ltsEstudiantes = estudianteDAO.ltsEstudianteByCedula(nombreEstudiante);	
	}
	
	public void seleccionarEst(Estudiante est){
		studentSelected=est;
	}
	
	public void guardar(){
		if(studentSelected!=null){
			System.out.println("tutor "+tutor.toString());
			System.out.println("estudiante "+ studentSelected.toString());
			Precios p = precioDAO.leer(idprecio);
			System.out.println("precio "+ p.toString());
			LugarNivelacion lug = lugaNiveDAO.leer(idlugar);
			System.out.println("lugar " + lug.toString());
			Horarios h = horarioDAO.leer(idhorario);
			System.out.println("horario "+h);
			
			//creacion de la cita
			solicitudCita = new SolicitudCita();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			//solicitudCita.setFecha(dateFormat.format(date));
			solicitudCita.setEstudiante(studentSelected);
			solicitudCita.setLugarNivelaciones(lug);
			solicitudCita.setPrecios(p);
			solicitudCita.setTutor(tutor);
			solicitudCita.setHorarios(h);
			
			solicitudCitaDAO.Insertar(solicitudCita);
		}
	}
	
	/*
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
        	System.out.println("->"+precioDAO.leer(Integer.valueOf(submittedValue)).toString());
        	precioselected=precioDAO.leer(Integer.valueOf(submittedValue));
        	idprecio=precioselected.getCodigo();
            return precioselected;
            
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", submittedValue)), e);
        }
    }

   */
	
	public LugaNiveDAO getLugaNiveDAO() {
		return lugaNiveDAO;
	}

	public void setLugaNiveDAO(LugaNiveDAO lugaNiveDAO) {
		this.lugaNiveDAO = lugaNiveDAO;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public List<Estudiante> getLtsEstudiantes() {
		return ltsEstudiantes;
	}

	public void setLtsEstudiantes(List<Estudiante> ltsEstudiantes) {
		this.ltsEstudiantes = ltsEstudiantes;
	}

	public Estudiante getStudentSelected() {
		return studentSelected;
	}

	public void setStudentSelected(Estudiante studentSelected) {
		this.studentSelected = studentSelected;
	}

	public List<LugarNivelacion> getLtslugar() {
		return ltslugar;
	}

	public void setLtslugar(List<LugarNivelacion> ltslugar) {
		this.ltslugar = ltslugar;
	}

	public List<Precios> getLtsPrecio() {
		return ltsPrecio;
	}

	public void setLtsPrecio(List<Precios> ltsPrecio) {
		this.ltsPrecio = ltsPrecio;
	}

	public List<Horarios> getLtsHora() {
		return ltsHora;
	}

	public void setLtsHora(List<Horarios> ltsHora) {
		this.ltsHora = ltsHora;
	}

	public SolicitudCita getSolicitudCita() {
		return solicitudCita;
	}

	public void setSolicitudCita(SolicitudCita solicitudCita) {
		this.solicitudCita = solicitudCita;
	}

	
	public int getIdprecio() {
		return idprecio;
	}

	public void setIdprecio(int idprecio) {
		this.idprecio = idprecio;
	}

	public int getIdlugar() {
		return idlugar;
	}

	public void setIdlugar(int idlugar) {
		this.idlugar = idlugar;
	}

	public int getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}

	
	/*
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Precios) {
        	System.out.println("code "+String.valueOf(((Precios) modelValue).getCodigo()));
            return String.valueOf(((Precios) modelValue).getCodigo());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid User", modelValue)));
        }
	}
	*/
	
	
	
}
