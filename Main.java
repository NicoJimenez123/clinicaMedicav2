import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
	public static Scanner s;
	public static SistemaInterno sI;
	public Main() {
	}
	public static void main(String[] args) {
		s = new Scanner(System.in);
		sI = new SistemaInterno();
		menu();
	}
	
	public static void menu() {
		while(true) {
			System.out.println("Opcion 1) Login.");
			System.out.println("Opcion 2) Registrar un Administrador.");
			System.out.print("Ingrese una Opción: ");
			int opc = s.nextInt();
			switch(opc) {
			case 1: pantallaLogin();break;
			case 2: registrarAdmin();break;
			default: System.out.println("Opción no Valida");
			}
		}
	}
	public static void pantallaLogin() {
		System.out.println("\nIngrese el nombre de usuario: ");
		String user = s.next();
		System.out.println("\nIngrese la constraseña: ");
		String pass = s.next();
		System.out.println(sI.loginAdmin(user, pass));
	}
	public static void registrarAdmin() {
		System.out.println("\nIngrese el nombre de usuario: ");
		String user = s.next();
		System.out.println("\nIngrese la constraseña: ");
		String pass = s.next();
		System.out.println("\n¿Es un Administrador de Sistemas?: ");
		boolean esSistemas = s.nextBoolean();
		sI.registrarAdmin(user, pass, esSistemas);
		//db.verUsuarios();
		//System.out.println(db.esDeSistemas("nico"));
	}

	public static void crearPaciente(){
		Paciente nuevoPaciente = new Paciente();


		System.out.println("\nIngrese el nombre de paciente: ");
		String nombre = s.next();
		System.out.println("\nIngrese el apellido del paciente: ");
		String apellido = s.next();
		System.out.println("\nIngrese DNI: ");
		String dni = s.next();
		System.out.println("\nIngrese la domicilio: ");
		String domicilio = s.next();
		System.out.println("\nIngrese telefono: ");
		String telefono = s.next();


		nuevoPaciente.setNombre(nombre);
		nuevoPaciente.setApellido(apellido);
		nuevoPaciente.setDni(Integer.parseInt(dni));
		nuevoPaciente.setDomicilio(domicilio);
		nuevoPaciente.setTelefono(telefono);
	}

	public static void brindarUnTurno(){

		System.out.println("\nIngrese el numero de consultorio: ");
		String nroConsultorio = s.next();
		System.out.println("\nIngrese costo: ");
		String costo = s.next();
		System.out.println("\nIngrese fecha: ");
		String fecha = s.next();
		System.out.println("\nIngrese la hora de inicio: ");
		String hrInicio = s.next();
		System.out.println("\nIngrese la hora de finalizacion: ");
		String hrFin = s.next();
		System.out.println("\nIngrese nombre paciente: ");
		String nombrePaciente = s.next();

		Paciente paciente = new Paciente();
		paciente.setNombre(nombrePaciente);

		SistemaInterno nuevoSistema = new SistemaInterno();
		nuevoSistema.brindarTurno(
			Integer.parseInt(nroConsultorio),
			Float.parseFloat(costo),
			parseFecha(fecha),
			parseTiempo(hrInicio),
			parseTiempo(hrFin),
			paciente
		);


	}

	/**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    public static LocalDate parseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

    /**
     * Permite convertir un String en localTime (Date).
     * @return Objeto LocalTime
     */
    public static LocalTime parseTiempo(String tiempo)
    {
        SimpleDateFormat formato = new SimpleTimeFormat("hh:mm");
        LocalTime tiempo = null;
        try {
            tiempo = formato.parse(tiempo);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return tiempo;
    }
}
