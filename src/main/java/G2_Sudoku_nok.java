/*
 * Gerado com o prompt: 
 * "Gere outra classe chamada G2_Sudoku_nok.java, que será uma cópia da classe G2_Sudoku_ok, 
 * porém, com algum erro na implementação. Assim como na classe original essa nova classe também 
 * terá que ter um comentário em seu início com o prompt que a formou."
 *  
 * Gerado com: Gemini 2.5 Pro
 * 
 * ERRO : A validação de colunas não verifica a última coluna (j < 8).
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class G2_Sudoku_nok {

    private final int[][] board = new int[9][9];

    /**
     * Construtor que lê um tabuleiro de Sudoku de um arquivo de recurso.
     * @param resourcePath O caminho para o arquivo de recurso contendo o tabuleiro.
     */
    public G2_Sudoku_nok(String resourcePath) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourcePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < 9) {
                String[] values = line.trim().split(",\\s*|\\s+");
                for (int col = 0; col < 9; col++) {
                    board[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
        } catch (IOException | NullPointerException | NumberFormatException e) {
            System.err.println("Erro ao ler o tabuleiro do recurso: " + resourcePath);
            e.printStackTrace();
        }
    }

    /**
     * Verifica se o tabuleiro de Sudoku é uma solução válida.
     * @return true se o tabuleiro for válido, false caso contrário.
     */
    public boolean valido() {
        // 1. Validar Linhas
        for (int i = 0; i < 9; i++) {
            if (!isSetValid(board[i])) {
                return false;
            }
        }

        // 2. Validar Colunas (COM ERRO INTENCIONAL)
        // O loop vai até 8, ignorando a última coluna.
        for (int j = 0; j < 8; j++) { 
            int[] column = new int[9];
            for (int i = 0; i < 9; i++) {
                column[i] = board[i][j];
            }
            if (!isSetValid(column)) {
                return false;
            }
        }

        // 3. Validar Sub-grades 3x3
        for (int blockRow = 0; blockRow < 9; blockRow += 3) {
            for (int blockCol = 0; blockCol < 9; blockCol += 3) {
                int[] subgrid = new int[9];
                int index = 0;
                for (int i = blockRow; i < blockRow + 3; i++) {
                    for (int j = blockCol; j < blockCol + 3; j++) {
                        subgrid[index++] = board[i][j];
                    }
                }
                if (!isSetValid(subgrid)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Método auxiliar para verificar se um array de 9 inteiros contém
     * os números de 1 a 9 sem repetição.
     * @param data O array de inteiros a ser verificado.
     * @return true se o conjunto for válido, false caso contrário.
     */
    private boolean isSetValid(int[] data) {
        Set<Integer> seen = new HashSet<>();
        for (int num : data) {
            // Assumindo que o tabuleiro está bem formado (números de 1 a 9)
            if (!seen.add(num)) {
                return false; // Encontrou um duplicado
            }
        }
        return seen.size() == 9;
    }
}
