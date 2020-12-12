package ejerciciosAda.base.util;

public class ResponseUtil {
	public static void DBMessage(int res, String message) {
		if(res == 1) {
			System.out.println(message);
		} else {
			System.out.println("Error");
		}
	}
}
