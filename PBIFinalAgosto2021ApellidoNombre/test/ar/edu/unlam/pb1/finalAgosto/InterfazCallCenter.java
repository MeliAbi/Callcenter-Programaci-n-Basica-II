package ar.edu.unlam.pb1.finalAgosto;


import java.util.Scanner;

public class InterfazCallCenter {
	final static int INCORPORAR = 1, DAR_ALTA = 2, NUEVA_LLAMADA = 3, VER_INFO = 4, SALIR = 9;
	
	public static void main(String args[]) {
		
		Scanner teclado = new Scanner(System.in);
		Empresa nuevaEmpresa = new Empresa("Doofenshmirtz Malvados y Asociados");
		int opcion=0;
		
		System.out.println("Bienvenido al callcenter");
		do {
			menu();
			opcion = teclado.nextInt();
			switch (opcion){
			case INCORPORAR:
				incorporarZonaDeCobertura(teclado,nuevaEmpresa);
				break;
			case DAR_ALTA:
				darDeAltaNuevoContacto(teclado, nuevaEmpresa);
				break;
			case NUEVA_LLAMADA:
				break;
			case VER_INFO:
				break;
			case SALIR:
				System.out.println("Fin del programa");
				break;
			default: 
				System.out.println("Opcion incorrecta");
				break;
			}
		}while(opcion!=SALIR);
			
	}

	private static void menu() {
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Incorporar zona de cobertura");
		System.out.println("2 - Dar de alta un nuevo contacto");
		System.out.println("3 - Realizar nueva llamada");
		System.out.println("4 - Ver informaci�n del contacto");
		System.out.println("9 - Salir");
		System.out.println("************************");
	}
	
	private static void incorporarZonaDeCobertura(Scanner teclado, Empresa nueva) {
		/*
		 * Se registra un nuevo c�digo postal dentro de la zona de cobertura de la empresa
		 */
		int codPost = 0;
		
		System.out.println("**********************");
		System.out.println("Ingrese codigo postal: ");
		System.out.println("**********************");
		
		codPost = teclado.nextInt();
		
		if(nueva.agregarNuevaZonaDeCobertura(codPost)== false) {
			System.out.println("!!!!!!!!!!!!!!!");
			System.out.println("Cobertura llena");
			System.out.println("!!!!!!!!!!!!!!!");
		}
	}
	
	private static void darDeAltaNuevoContacto(Scanner teclado, Empresa nuevaEmpresa) {
		/*
		 * Registra un nuevo contacto en la empresa
		 */
		String nombre="";
		String apellido="";
		String email="";
		String direccion="";
		double celular=0;
		int codigoPostal=0;
		String localidad="";
		int provinciaElegida=0;
		Provincia provincia=null;
		Contacto nuevo=null;
		
		System.out.println("Ingrese el Nombre:");
		nombre=teclado.next();
		System.out.println("Ingrese el Apellido:");
		apellido= teclado.next();
		System.out.println("Ingrese el Numero de Telefono:");
		celular=teclado.nextDouble();
		System.out.println("Ingrese el Email: (debe contener @ y .)");
		email=teclado.next();
		System.out.println("Ingrese el Codigo Postal:");
		codigoPostal=teclado.nextInt();
		System.out.println("Ingrese la Localidad:");
		localidad=teclado.next();
		System.out.println("Ingrese la Provincia:");
		mostrarProvincias();
		provinciaElegida=teclado.nextInt();
		provincia=Provincia.values()[provinciaElegida-1];
		
		nuevo=new Contacto(nombre,apellido,celular,email,codigoPostal,localidad,provincia);
		
		if (nuevo.esEmailValido(email)==true) {
			nuevaEmpresa.agregarNuevoContacto(nuevo);
			System.out.println("Registrado con éxito.");
			/////
		}else {
			System.out.println("Contacto no registrado, vuelva a ingresar el Email.");
			
			do{
			System.out.println("Ingrese el Email: (debe contener @ y .)");
			email=teclado.next();
			}while (nuevo.esEmailValido(email)==false);
			
			nuevo.setEmail(email);
			nuevaEmpresa.agregarNuevoContacto(nuevo);
		}
		
		
	}
	private static void mostrarProvincias() {
		System.out.println("1- BUENOS_AIRES");
		System.out.println("2- CABA");	
		System.out.println("CATAMARCA");		
		System.out.println("CHACO");		
		System.out.println("CHUBUT");		
		System.out.println("CORDOBA");	
		System.out.println("CORRIENTES");		
		System.out.println("ENTRE_RIOS");		
		System.out.println("FORMOSA");		
		System.out.println("JUJUY");		
		System.out.println("LA_PAMPA");		
		System.out.println("LA_RIOJA");		
		System.out.println("MENDOZA");		
		System.out.println("MISIONES");		
		System.out.println("NEUQUEN");		
		System.out.println("RIO_NEGRO");		
		System.out.println("SALTA");		
		System.out.println("SAN_JUAN");		
		System.out.println("SAN_LUIS");		
		System.out.println("SANTA_CRUZ");		
		System.out.println("SANTA_FE");		
		System.out.println("SANTIAGO_DEL_ESTERO");		
		System.out.println("TIERRA_DEL_FUEGO");		
		System.out.println("TUCUMAN");		
	}
	
	private static void realizarNuevaLlamada() {
		/*
		 * Busca un candidato,  muestra los datos del mismo, y permite almacenar el resultado de la llamada.
		 * 
		 * a.	Si la llamada fue exitosa (en ese caso el contacto pasa a ser cliente, y no se lo debe volver a 
		 * llamar).
		 * b.	Si el contacto no desea ser llamado nuevamente (la llamada pudo no haber sido exitosa, pero se haga 
		 * un nuevo intento en el futuro).
		 * c.	Observaciones: Texto libre donde el operador deja registro de lo conversado.
		 */
	}
	
	private static void verInformacionDelContacto() {
		/*
		 * Se visualiza la informaci�n del contacto, incluso el listado de las llamadas que se le hicieron
		 */
	}
}
