import java.util.Scanner;

public class Main {
	public static Scanner s;
	public static SistemaInterno sI;
	public static void main(String[] args) {
		sI = new SistemaInterno();
		s = new Scanner(System.in);
	}
	
	public static void menu() {
		while(true){
			System.out.println("Opcion 1) Brindar Turno");
			System.out.println("Opcion 2) Consultar Turno");
			System.out.println("Opcion 3) Concurrir Turno");
			System.out.println("Opcion 4) Obtener Reporte de Estudios Realizados");
			System.out.println("Ingrese una Opcion: ");
			int opcion = 0;
			opcion = s.nextInt();
			switch(opcion) {
			case 1:break;
			case 2:{
						System.out.println("Ingrese el numero de DNI del Paciente: ");
						int dni = s.nextInt();
						Turno t = sI.obtenerProximoTurno(dni);
						System.out.println("Proximo turno del paciente: " + t.obtenerFechaYHora());
						break;
					}
			case 3:{
						System.out.println("Ingrese el numero de DNI del Paciente: ");
						int dni = s.nextInt();
						Turno t = sI.tieneTurnoHoy(dni);
						if(t != null) {
							System.out.println("El turno del paciente está programado para las " + t.getHoraInicio().toString());
						}
						else {
							System.out.println("El paciente no tiene ningún turno programado en el día de la fecha");
						}
						break;
					}
			case 4:{
						int cant = sI.cantidadEstudiosRealizados();
						System.out.println("La cantidad de estudios realizados hasta el día de la fecha es: " + cant);
						break;
					}
			}
		}
	}
}

