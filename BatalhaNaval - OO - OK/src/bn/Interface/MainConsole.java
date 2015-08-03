package bn.Interface;

import bn.Codigos.BatalhaNaval;

import java.util.Random;
import java.util.Scanner;

public class MainConsole {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BatalhaNaval batalha = new BatalhaNaval();

		int x, X, y, i, j;
		int z = 0, ok; // CONTADOR PARA SAÍDA
		int finish = 0, finish2 = 0;

		do {
			x = batalha.time(); // VEZ DO JOGADOR
			System.out.println("VEZ DO JOGADOR(0) = " + x);
			z = 0;
			while (z == 0 && finish <= 8) {

				// LÊ ENTRADA DO JOGADOR HUMANO
				System.out.println("-------------------------");
				System.out.println("JOGADOR");
				System.out.println("Digite linha e coluna: ");
				i = scan.nextInt();
				j = scan.nextInt();

				ok = batalha.validPlayer(i, j); // Método validar
				if (ok == -1) {
					System.out.println("Jogada fora da matriz!");
					z++; // PARA SAIR DO LOOP
				} else if (ok == 0) {
					System.out.println("Jogada repetida.");
					z++; // PARA SAIR DO LOOP
				} else if (ok == 1) {
					y = batalha.play(i, j); // Método Jogar

					String msg = getMessage(y);
					System.out.println("O jogador " + msg);
					System.out.println(batalha.printOceanPlayer());
					if (y == -1)
						z++;
					else {
						finish++;
					}
				}
				
			}

			if (finish != 8) {
				X = batalha.time(); // VEZ DO JOGADOR
				System.out.println("VEZ DO COMPUTADOR(1) = " + X);
				z = 0;
				while (z == 0) {
					Random rand = new Random();
					System.out.println();
					System.out.println("######################");
					// Sorteio do computador
					int L = rand.nextInt(5);
					int C = rand.nextInt(5);

					System.out.println("JOGADA DO COMPUTADOR É " + L + " E "
							+ C);
					ok = 0;
					ok = batalha.validComputer(L, C); // Método validar

					if (ok == -1) {
						System.out.println("Jogada fora da matriz!");
						z++; // PARA SAIR DO LOOP
					} else if (ok == 0) {
						System.out.println("Jogada repetida.");
						z++; // PARA SAIR DO LOOP
					} else if (ok == 1) {
						y = batalha.play(L, C); // Método Jogar

						String msg = getMessage(y);
						System.out.println("O computador " + msg);
						System.out.println(batalha.printOceanComputer());

						if (y == -1)
							z++;
						else {
							finish2++;
						}

					}
				}
			}
			batalha.setCheckEnd();
		} while (finish < 9 && finish2 < 9);

		System.out.println("Acertos do jogador = " + finish);
		System.out.println("Acertos do computador = " + finish2);
		System.out.println("Game Over - " + batalha.winner());
	}

	private static String getMessage(int y) {
		if (y == 1)
			return "acertou um BARCO!";

		else if (y == 2)
			return "acertou um SUBMARINO!";

		else if (y == 3)
			return "acertou um PORTA-AVIÕES!";

		else if (y == -1)
			return "gastou uma bala e acertou o oceano!";
		return null;
	}
}