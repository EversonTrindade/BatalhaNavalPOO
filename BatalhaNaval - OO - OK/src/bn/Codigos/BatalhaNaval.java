package bn.Codigos;

/*
 * Aqui está toda a lógica da Batalha Naval
 */
public class BatalhaNaval {

	private int[][] oceanPlayer = new int[5][5];
	private int[][] oceanComputer = new int[5][5];

	// Player = 0(JOGADOR) / Player = 1(COMPUTADOR)
	public int Player;
	private int endPlayer;
	private int endComputer;
	public String winner;
	
	// Método para verificação do fim do jogo
	public void setCheckEnd() {
		if (endPlayer == 9) {
			winner = "Você Venceu!";
			// gameover();
		}

		else if (endComputer == 9) {
			winner = "O Computador Venceu!";
			// gameover();
		}
		// return endPlayer;
	}

	// Método para seber o vencedor
	public String winner() {
		return winner;
	}

	// Método para trocar de Jogador
	public void setChange(int C) {

		// Player
		if (C == 0)
			Player = 1;

		// Computer
		if (C == 1)
			Player = 0;

	}

	// Método para saber a vez
	public int time() {
		return Player;
	}

	// Método para determinar se a jogada é valida
	public int validPlayer(int l, int c) {
		// Fora da matriz
		if (l < 0 || l > 4 || c < 0 || c > 4) {
			setChange(0);
			return -1;
		}
		// Jogada repetida
		else if (oceanPlayer[l][c] != 0) {
			setChange(0);
			return 0;
		}
		return 1;
	}

	// Método para determinar se a jogada é valida
	public int validComputer(int l, int c) {
		if (l < 0 || l > 4 || c < 0 || c > 4) {
			setChange(1);
			return -1;
		} else if (oceanComputer[l][c] != 0) {
			setChange(1);
			return 0;
		}
		return 1;
	}

	// Método para determinar a posição dos alvos PARA O JAGADOR e COMPUTADOR
	public int play(int l, int c) {

		// Barcos
		if ((l == 4 && c == 2) || (l == 4 && c == 3) || (l == 4 && c == 4)) {
			if (Player == 0) {
				oceanPlayer[l][c] = 1;
				endPlayer = endPlayer + 1;

			} else if (Player == 1) {
				oceanComputer[l][c] = 1;
				endComputer = endComputer + 1;
			}
			return 1;
		}
		// Submarinos
		else if ((l == 0 && c == 1) || (l == 1 && c == 3)) {
			if (Player == 0) {
				oceanPlayer[l][c] = 2;
				endPlayer = endPlayer + 1;
			} else if (Player == 1) {
				oceanComputer[l][c] = 2;
				endComputer = endComputer + 1;
			}
			return 2;
		}
		// Porta-aviões
		else if ((l == 2 && c == 0) || (l == 2 && c == 1) || (l == 2 && c == 2)
				|| (l == 2 && c == 3)) {
			if (Player == 0) {
				oceanPlayer[l][c] = 3;
				endPlayer = endPlayer + 1;
			} else if (Player == 1) {
				oceanComputer[l][c] = 3;
				endComputer = endComputer + 1;
			}
			return 3;
		} else {
			if (Player == 0)
				oceanPlayer[l][c] = 9;

			else if (Player == 1)
				oceanComputer[l][c] = 9;

			setChange(Player);
			return -1;
		}

	}

	// IMPRESSÃO DA MATRIZ JOGADOR
	public String printOceanPlayer() {
		String str = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				str += getOceanPlayer(i, j) + " ";
			}
			str += "\n";
		}
		return str;
	}

	public int getOceanPlayer(int i, int j) {
		return oceanPlayer[i][j];
	}

	// IMPRESSÃO DA MATRIZ COMPUTADOR
	public String printOceanComputer() {
		String str = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				str += getOceanComputer(i, j) + " ";
			}
			str += "\n";
		}
		return str;
	}

	public int getOceanComputer(int i, int j) {
		return oceanComputer[i][j];
	}

}
