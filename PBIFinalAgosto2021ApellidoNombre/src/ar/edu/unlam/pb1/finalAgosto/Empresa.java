package ar.edu.unlam.pb1.finalAgosto;

public class Empresa {

	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	private String nombre = "";
	private int cobertura [];
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		cobertura = new int [2];
	}
	
	public String getNombreEmpresa() {
		
		return this.nombre;
	}
	
	public boolean agregarNuevoContacto(Contacto nuevo) {
	
		/*
		 * Incorpora un nuevo contacto a la empresa
		 */
		
		return false;
	}
	
	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican por el codigo postal)
		 */
		boolean seAgrego=false;
		
		for(int i=0; i<cobertura.length; i++) {
			if(cobertura[i]==0 && seAgrego == false) {
				cobertura[i]=codigoPostal;
				seAgrego = true;
			}
		}
		
		return seAgrego;
	}	
	
	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {
		/*
		 * Determina si un c�digo postal est� dentro de la zona de cobertura
		 */
		return false;
	}
	
	public Contacto buscarCandidato() {
		/*
		 * Para determinar qu� contacto el sistema debe mostrar, se debe realizar la siguiente b�squeda:
		 * 1.	El contacto NO debe ser cliente a�n.
		 * 2.	El contacto desea ser llamado o al menos no inform� lo contrario.
		 * 3.	El c�digo postal del contacto debe existir en las zonas de cobertura existente.
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el pr�ximo llamado.
		 */

		return null;
	}
}
