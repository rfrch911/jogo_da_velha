import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] tabuleiro = new char[3][3];
		inicializarTabuleiro(tabuleiro);
		char jogadorAtual = 'x';
		
		while (tabuleiroCompleto(tabuleiro) == false && jogadorVenceu(tabuleiro, jogadorAtual) == false) {
			realizarJogada(tabuleiro, jogadorAtual, scanner);
			exibirTabuleiro(tabuleiro);
			if (jogadorVenceu(tabuleiro, jogadorAtual) == false) {
	            jogadorAtual = trocarJogador(jogadorAtual);
	        }
		}
		if (jogadorVenceu(tabuleiro, jogadorAtual) == true) {
	        System.out.println("O jogador " + jogadorAtual + " venceu!");
	    } else {
	        System.out.println("A partida terminou empatada!");
	    }

	    scanner.close();
	}
	
	public static void inicializarTabuleiro(char[][] tabuleiro) {
		for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = ' ';
            }
        }
		
	}

	public static void exibirTabuleiro(char[][] tabuleiro) {
		for (int linha = 0; linha < 3; linha++) {
			System.out.println("+---+---+---+");
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print("| " + tabuleiro[linha][coluna] + " ");
            }
            System.out.println("|");
            
        }
		System.out.println("+---+---+---+");
		
	}
	
	public static boolean posicaoValida(char[][] tabuleiro, int linha, int coluna) {
		if(linha <0 || linha >2 || coluna <0 || coluna >2) {
			return false;
		}
		if(tabuleiro[linha][coluna] == ' ') {
			return true;
		} else {
			return false;
		}
	}
	
	public static void realizarJogada(char[][] tabuleiro, char jogadorAtual, Scanner scan) {
	    int linha, coluna;

	    do {
	        System.out.println("jogador " + jogadorAtual + " digite a linha:");
	        linha = scan.nextInt();
	        System.out.println("jogador " + jogadorAtual + " digite a coluna:");
	        coluna = scan.nextInt();

	        if (posicaoValida(tabuleiro, linha, coluna) == false) {
	            System.out.println("Essa posição já está ocupada ou é inválida. Escolha outra posição.");
	        }

	    } while (posicaoValida(tabuleiro, linha, coluna) == false);

	    tabuleiro[linha][coluna] = jogadorAtual;
	}

	
	public static char trocarJogador(char jogadorAtual) {
		if (jogadorAtual == 'x') {
			return 'o';
		} else {
			return 'x';
		}
	}
	public static boolean tabuleiroCompleto(char[][] tabuleiro) {
	    for (int linha = 0; linha < 3; linha++) {
	        for (int coluna = 0; coluna < 3; coluna++) {
	            if (tabuleiro[linha][coluna] == ' ') {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	public static boolean jogadorVenceu(char[][] tabuleiro, char jogador) {
		// Linhas
	    for (int linha = 0; linha < 3; linha++) {
	        if (tabuleiro[linha][0] == jogador &&
	            tabuleiro[linha][1] == jogador &&
	            tabuleiro[linha][2] == jogador) {
	            return true;
	        }
	    }

	    // Colunas
	    for (int coluna = 0; coluna < 3; coluna++) {
	        if (tabuleiro[0][coluna] == jogador &&
	            tabuleiro[1][coluna] == jogador &&
	            tabuleiro[2][coluna] == jogador) {
	            return true;
	        }
	    }

	    // Diagonal principal
	    if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
	        return true;
	    }

	    // Diagonal secundária
	    if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
	        return true;
	    }

	    return false;

	}

}
