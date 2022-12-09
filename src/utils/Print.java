package utils;

public class Print {
	
	/**
	 * Metodo p : imprime por pantalla la String pasada como argumento
	 * @param msg : String texto a imprimir por pantalla
	 */
	public static void p(String msg) {
		System.out.println(msg);
	}
	
	/**
	 * Metodo ph : salto de linea
	 */
	public static void ph() {
		System.out.println();
	}
	
	/**
	 * Introduce espacios en consola
	 * @param n número de espacios
	 */
	public static void espace(int n) {
		for (int i = 0; i < n; i++) {
			ph();
		}
	}

	
}
