package ejerciciosAda.collection;

public class AppException {
	public static void main(String[] args) {
		int valor = 0;
		int valorUsuario = 3;
		try {
			System.out.println(valorUsuario / valor);
		} catch(Exception e) {
			System.out.println("Division no valida");
		}
		
		try {
			throwsException();
		} catch (MadeUpException e) {
			e.printStackTrace();
		}
	}
	
	private static void throwsException() throws MadeUpException {
		throw new MadeUpException();
	}
}
