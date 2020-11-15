

/**
 * @author Nicolas Jimenez
 * @version 1.0
 * @created 15-nov.-2020 16:07:32
 */
public class Laboratorio {

	private static int cantEstudiosRealizados;

	public Laboratorio(){
		
	}

	public static int getCantEstudiosRealizados() {
		return cantEstudiosRealizados;
	}

	public void setCantEstudiosRealizados() {
		Laboratorio.cantEstudiosRealizados++;
	}

	public boolean realizarEstudio(Estudio estudio){
		// sumar uno a la cantidad de estudios realizados
		return false;
	}

}