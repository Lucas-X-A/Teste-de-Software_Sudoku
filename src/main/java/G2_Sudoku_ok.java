/*
 * Gerado com o prompt: 
 * "Crie um código em Linguagem Java, que seja um avalidador de Sudoku. 
 * A classe se chamará "G2_Sudoku_ok.java", o pacote da classe deve ser o pacote default de java. 
 * Tem como comentário no início da classe se a mesma foi gerada com qual prompt e com que LLM (ex: GPT, Gemini, etc). 
 * A classe possui construtor do mesmo nome da classe, que recebe o caminho para um arquivo de texto contendo um 
 * tabuleiro de Sudoku 9x9 no formato da imagem anexada. A classe deve possuir um método "public boolean valido()" 
 * que retorna true se o tabuleiro é uma solução para o Sudoku, false se não for válido. O método não precisa ver 
 * se os tabuleiros estão bem formados. Assuma que os tabuleiros são bem formados, isto é, possuem apenas números 
 * de 1 a 9 e segue estritamente o formato do exemplo fornecido na imagem."
 *  
 * Gerado com: Gemini 2.5 Pro
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class G2_Sudoku_ok {

    private final int[][] board = new int[9][9];

    /**
     * Construtor que lê um tabuleiro de Sudoku.
     * @param path O caminho para o arquivo do tabuleiro.
     */
    public G2_Sudoku_ok(String path) {
        InputStream inputStream = null;

        // 1. Tenta carregar como recurso (para estrutura Maven)
        inputStream = getClass().getClassLoader().getResourceAsStream(path);

        // 2. Se não encontrou como recurso, tenta como arquivo direto (para estrutura simples)
        if (inputStream == null) {
            try {
                inputStream = new FileInputStream(path);
            } catch (IOException e) {
                // Ignora o erro aqui, o próximo passo vai tratar o inputStream nulo
            }
        }

        // 3. Se o arquivo foi encontrado de alguma forma, processa. Senão, lança erro.
        if (inputStream != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                int row = 0;
                while ((line = br.readLine()) != null && row < 9) {
                    String[] values = line.split(", "); 
                    for (int col = 0; col < 9; col++) {
                        // Remove espaços de cada número individualmente antes de converter
                        board[row][col] = Integer.parseInt(values[col].trim());
                    }
                    row++;
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Erro ao processar o tabuleiro: " + path);
                e.printStackTrace();
            }
        } else {
            System.err.println("Não foi possível encontrar o arquivo do tabuleiro em lugar nenhum: " + path);
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

        // 2. Validar Colunas
        for (int j = 0; j < 9; j++) {
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
            // Ignora zeros, que podem indicar um tabuleiro não preenchido ou erro de leitura.
            if (num == 0) continue; 

            // Verifica se o número está fora do intervalo válido [1,9] ou se é um duplicado.
            if (num < 1 || num > 9 || !seen.add(num)) {
                return false;
            }
        }
        // Se o loop terminar, significa que não há duplicatas ou números inválidos.
        return true;
    }
}
