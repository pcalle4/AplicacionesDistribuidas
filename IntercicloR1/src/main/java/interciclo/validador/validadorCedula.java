package interciclo.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



@FacesValidator("interciclo.validador.validadorCedula")
public class validadorCedula implements Validator {
	public static  final int num_provincias = 24; 
	private static int[] coeficientes = {4,3,2,7,6,5,4,3,2};
	private static int constante = 11;
	

	
	public boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1))
								* coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out
					.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}
  /*
		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
		}
	*/
		return cedulaCorrecta;
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		if(!validadorDeCedula(value.toString())){
			FacesMessage msg = new FacesMessage("Numero de cedula invalida", 
					"Numero de cedula invalida");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);	
	}
	
}
}
