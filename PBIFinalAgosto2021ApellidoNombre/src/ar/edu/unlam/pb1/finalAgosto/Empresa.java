package ar.edu.unlam.pb1.finalAgosto;

public class Empresa {

	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	private String nombre = "";
	private int cobertura [];
	private Contacto contactosRegistrados[];
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		cobertura = new int [2];
		contactosRegistrados= new Contacto [3];
	}
	
	public String getNombreEmpresa() {
		
		return this.nombre;
	}
	
	public boolean agregarNuevoContacto(Contacto nuevo) {
	
		/*
		 * Incorpora un nuevo contacto a la empresa
		 * Comentario pruebita
		 * 
		 */
		boolean seAgrego=false;
		
		for(int i=0; i<contactosRegistrados.length; i++) {
			if(contactosRegistrados[i]==null && seAgrego == false) {
				contactosRegistrados[i]=nuevo;
				seAgrego = true;
			}
		}
		
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
		boolean codigoCorrecto=false;
		for (int i=0; i<cobertura.length;i++) {
			if (cobertura[i]!=0&&codigoCorrecto==false&&cobertura[i]==codigoPostal) {
				codigoCorrecto=true;
			}
		}
		return codigoCorrecto;
	}
	
	public Contacto buscarCandidato() {
		/*
		 * Para determinar qu� contacto el sistema debe mostrar, se debe realizar la siguiente b�squeda:
		 * 1.	El contacto NO debe ser cliente a�n.
		 * 2.	El contacto desea ser llamado o al menos no inform� lo contrario.
		 * 3.	El c�digo postal del contacto debe existir en las zonas de cobertura existente. 
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el pr�ximo llamado.
		 */
		Contacto candidatos[]=new Contacto[30];
		int contador=0;								// VARIABLES LOCALES
		Contacto candidatoAleatorio=null;
		int numeroRandom=0;
		
		for (int i=0; i<contactosRegistrados.length;i++) {
			if (contactosRegistrados[i]!=null&&contactosRegistrados[i].getCliente()==false&&contactosRegistrados[i].getDeseaSerLlamadoNuevamente()==true) {
				candidatos[contador]=contactosRegistrados[i];
				contador++;											//CONDICIONES PARA QUE EL CONTACTO PUEDA SER CANDIDATO A LLAMADO
			}
		}
			numeroRandom=(int)(Math.random()*contador);
			candidatoAleatorio= candidatos[numeroRandom];			//DE ESE VECTOR NUEVO DE CANDIDATOS, QUE ME MANDE UNO RANDOM

		return candidatoAleatorio;									// DEVUELVE EL RANDOM ELEGIDO
	}
	
	public Contacto getBuscarContacto(String mail) {
		for (int i = 0; i < contactosRegistrados.length; i++) {
			if (contactosRegistrados[i].getEmail().equals(mail)) {
				return contactosRegistrados[i];
			}
		}
		return null;
	}
	}
