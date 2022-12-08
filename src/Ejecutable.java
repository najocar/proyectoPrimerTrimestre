import controller.Functions;
import model.Player;

public class Ejecutable {

	public static void main(String[] args) {
		Player jugador1 = new Player();
		Player jugador2 = new Player();
		Functions.menu(jugador1, jugador2);

	}

}
