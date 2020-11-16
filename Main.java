import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static Scanner s;
	public static SistemaInterno sI;
	public static void main(String[] args) {
		sI = new SistemaInterno();
		s = new Scanner(System.in);
		menu();
	}
	
	public static void menu() {
		cargarDatos();
		while(true){
			System.out.println();
			System.out.println("Opcion 1) Brindar Turno");
			System.out.println("Opcion 2) Consultar Turno");
			System.out.println("Opcion 3) Concurrir Turno");
			System.out.println("Opcion 4) Obtener Reporte de Estudios Realizados");
			System.out.println("Opcion 5) Registrar un Paciente");
			System.out.println("Ingrese una Opcion: ");
			int opcion = 0;
			opcion = s.nextInt();
			switch(opcion) {
			case 1:{
						brindarUnTurno();
						break;
					}
			case 2:{
						System.out.println("Ingrese el numero de DNI del Paciente: ");
						int dni = s.nextInt();
						Turno t = sI.consultarTurno(dni);
						if(t != null)
							System.out.println("Proximo turno del paciente: " + t.obtenerFechaYHora());
						else {
							System.out.println("El Paciente no posee un turno proximo");
						}
						break;
					}
			case 3:{
						System.out.println("Ingrese el numero de DNI del Paciente: ");
						int dni = s.nextInt();
						sI.concurrirTurno(dni);
						break;
					}
			case 4:{
						int cant = sI.cantidadEstudiosRealizados();
						System.out.println("La cantidad de estudios realizados hasta el día de la fecha es: " + cant);
						break;
					}
			case 5: Paciente p = crearPaciente();sI.agregarPaciente(p); break;
			case 33: cargarDatos();break;
			}
		}
	}
	
	public static Paciente crearPaciente(){
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
		nuevoPaciente.setNumeroTelefono(telefono);
		return nuevoPaciente;
	}
	
	public static void brindarUnTurno(){

		System.out.println("\nIngrese el numero de consultorio: ");
		String nroConsultorio = s.next();
		System.out.println("\nIngrese costo: ");
		String costo = s.next();
		System.out.println("\nIngrese fecha (yyyy-mm-dd): ");
		String fecha = s.next();
		System.out.println("\nIngrese la hora de inicio (hh-mm): ");
		String hrInicio = s.next();
		System.out.println("\nIngrese la hora de finalizacion: ");
		String hrFin = s.next();
		System.out.println("\nIngrese el DNI del paciente: ");
		int dni = s.nextInt();

		Paciente paciente = sI.obtenerPaciente(dni);
		if(paciente != null) {
			sI.brindarTurno(
				Integer.parseInt(nroConsultorio),
				Float.parseFloat(costo),
				parseFecha(fecha),
				parseTiempo(hrFin),
				parseTiempo(hrInicio),
				paciente
			);
		}
		else {
			System.out.println("No existe un paciente registrado con ese numero de DNI");
		}

	}

	/**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto LocalDate
     */
    public static LocalDate parseFecha(String fecha)
    {
        LocalDate fechaDate = null;
        fechaDate = LocalDate.parse(fecha); 
        return fechaDate;
    }

    /**
     * Permite convertir un String en localTime (Date).
     * @return Objeto LocalTime
     */
    public static LocalTime parseTiempo(String tiempo)
    {
        LocalTime tiempo2 = null;
        tiempo2 = LocalTime.parse(tiempo);
        return tiempo2;
    }
    
    public static void cargarDatos() {
    	AreaMedica a = new AreaMedica();
    	a.setCodigoArea(0);
    	a.setNombreArea("Especialidades Medico-Quirurgicas");
    	List<Consultorio> c = new ArrayList<Consultorio>();
    	Consultorio c2 = new Consultorio();
    	c2.setMedico(new Medico("Nico", new Especialidad("Dermatologia")));
    	c2.setNumeroConsultorio(0);
    	c.add(c2);
    	a.setConsultorios(c);
    	sI.agregarAreaMedica(a);
    	sI.agregarPaciente(new Paciente("Jimenez",1,"Lugar","Nicolas","123"));
    }
	
}
