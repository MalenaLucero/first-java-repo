package ejerciciosAda.base.util;

public class ResponseUtil {
	public static void addMessage(int res) {
		if(res == 1) {
			System.out.println("Se agrego el elemento");
		} else{
			System.err.println("No se agrego el elemento");
		}
	}
	
	public static void editMessage(int res) {
		if(res == 1) {
			System.out.println("Se realizo la modificacion");
		} else{
			System.err.println("No se realizo la modificacion");
		}
	}
	
	public static void deleteMessage(int res) {
		if(res == 1) {
			System.out.println("Se elimino el elemento");
		} else{
			System.err.println("No se elimino el elemento");
		}
	}
}
