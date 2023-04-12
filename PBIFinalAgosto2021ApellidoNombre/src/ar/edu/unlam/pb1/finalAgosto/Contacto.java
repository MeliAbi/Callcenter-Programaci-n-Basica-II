package ar.edu.unlam.pb1.finalAgosto;

public class Contacto {
	
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * �	Nombre y Apellido: No se aceptan n�meros. 
	 * �	Celular: Compuesto del c�digo de pa�s + c�digo de �rea + n�mero de celular.
	 * �	E-Mail: Debe contener al menos el s�mbolo �@� y el caracter �.�.
	 * �	Direcci�n: Valor alfanum�rico.
	 * �	C�digo Postal: Valor num�rico.
	 * �	Localidad: Valor alfanum�rico.
	 * �	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 * �	Es cliente (Si o No): Inicialmente se carga en �No�.
	 * �	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en �Si�.
	 */
	String nombre;
	String apellido;
	String email;
	String direccion;
	double celular;
	int codigoPostal;
	String localidad;
	Provincia provincia;
	boolean cliente;
	boolean deseaSerLlamadoNuevamente;
	private Llamada llamadas[];
	private static int cantidadMaximaDeLlamadas = 5;
	
	
	public Contacto(String nombre, String apellido, double celular, String email, int codigoPostal, String direccion,
			String localidad, Provincia provincia) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.celular=celular;
		this.email=email;
		this.codigoPostal=codigoPostal;
		this.direccion=direccion;
		this.localidad=localidad;
		this.provincia=provincia;
		cliente=false;
		deseaSerLlamadoNuevamente=true;
		llamadas=new Llamada[cantidadMaximaDeLlamadas];
	}
	/*public boolean verificarNombreCorrecto (String nombre){
		for con char at y que no tome como válidos los ascii diferentes a caracteres de letras
			}*/
	

	public boolean esEmailValido(String email) {
		/*
		 * Eval�a si un String determinado puede ser almacenado como E-MAIL.
		 * 
		 */
		boolean emailValido=false;
		boolean contieneArroba=false;
		boolean contienePunto=false;
		
		for (int i=0; i<email.length();i++) {
			if (email.charAt(i)==64) {
				contieneArroba=true;
			}
			if (email.charAt(i)==46) {
				contienePunto=true;
			}
		}
		
		if (contienePunto==true&&contieneArroba==true) {
			 emailValido=true;
		}
		return emailValido;
	}
	
	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
		for (int i = 0; i < llamadas.length; i++) {
			if (llamadas[i] == null) {
				llamadas[i] = nueva;}
			
			if (nueva.getFueExitosa()) {
					this.setCliente(true);
					this.setDeseaSerLlamadoNuevamente(false);
				}
				return true;
			}
		return false;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	public boolean getDeseaSerLlamadoNuevamente() {
		return deseaSerLlamadoNuevamente;
	}

	public void setDeseaSerLlamadoNuevamente(boolean deseaSerLlamadoNuevamente) {
		this.deseaSerLlamadoNuevamente = deseaSerLlamadoNuevamente;
	}
	public String toString() {
		/*
		 * Muestra los datos de un contacto, entre los que se debe incluir el registro de las llamadas realizadas.
		*/

		String mensaje = "Datos del contacto: "+"\nNombre y Apellido: " + nombre + " " + apellido 
				+ "\nCelular: "+celular +"\nEmail: "+email +"\nDireccion: "+direccion
				+ "\nProvincia: "+provincia+"\nCliente: "+ cliente +"\n";

		for (int i = 0; i < cantidadMaximaDeLlamadas; i++) {
			mensaje += llamadas[i].getObservaciones()+"\n";
		}
		return mensaje;
	}

	
	
}
