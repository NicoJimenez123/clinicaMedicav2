import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaseDeDatos {
	
	private Map<String, ArrayList<Object>> users;
	public BaseDeDatos() {
		this.users = new HashMap<String, ArrayList<Object>>();
	}
	public boolean anadirUsuario(String user, String pass, boolean esSistemas) {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(pass);
		values.add(esSistemas);
		this.users.put(user, values);
		return true;
	}
	public boolean usuarioValido(String user, String pass) {
		// Pregunto si hay una persona con el mismo usuario en la BD
		if(this.users.containsKey(user)) {
			System.out.println("Encontrado");
			// Comparo la contraseña pasada con la del usuario de la BD
			if(this.users.get(user).get(0).equals(pass)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public void verUsuarios() {
		for(String user : this.users.keySet()) {
			System.out.println(user);
			for(Object value : this.users.get(user)) {
				System.out.println(value);
			}
		}
	}
	public boolean esDeSistemas(String user) {
		if(this.users.containsKey(user)) {
			return (boolean) this.users.get(user).get(1);
		}
		else {
			return false;
		}
	}
}
