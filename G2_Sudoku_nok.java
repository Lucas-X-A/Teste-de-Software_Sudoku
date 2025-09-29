/**
 * G2_Sudoku_nok.java
 * 
 * Implementação com bugs intencionais de um validador de Sudoku.
 * Esta implementação deve falhar em alguns testes específicos.
 * 
 * Bugs intencionais incluídos:
 * 1. Bug na validação de colunas - não verifica duplicatas corretamente
 * 2. Bug na validação de sub-grades - erro no cálculo dos índices
 * 3. Bug na validação de números - aceita números fora do range 1-9
 */
public class G2_Sudoku_nok {
    
    /**
     * Valida se uma solução de Sudoku 9x9 está correta
     * @param sudoku Matriz 9x9 representando a solução do Sudoku
     * @return true se a solução está correta, false caso contrário
     */
    public static boolean isValidSudoku(int[][] sudoku) {
        // Verifica se a matriz tem o tamanho correto
        if (sudoku == null || sudoku.length != 9) {
            return false;
        }
        
        for (int i = 0; i < 9; i++) {
            if (sudoku[i] == null || sudoku[i].length != 9) {
                return false;
            }
        }
        
        // Verifica todas as colunas PRIMEIRO (para expor o bug)
        for (int j = 0; j < 9; j++) {
            if (!isValidColumn(sudoku, j)) {
                return false;
            }
        }
        
        // Verifica todas as linhas
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(sudoku, i)) {
                return false;
            }
        }
        
        // Verifica todas as sub-grades 3x3 (BUG: cálculo incorreto dos índices)
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                if (!isValidBox(sudoku, boxRow, boxCol)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Verifica se uma linha contém todos os números de 1 a 9 sem repetição
     * BUG: Aceita números fora do range válido (0 e números > 9)
     */
    private static boolean isValidRow(int[][] sudoku, int row) {
        boolean[] seen = new boolean[10]; // índices 1-9 usados
        
        for (int col = 0; col < 9; col++) {
            int num = sudoku[row][col];
            // BUG: Aceita 0 e números > 9, mas ainda detecta duplicatas normalmente
            if (num < 0 || num > 10) {
                return false;
            }
            if (num >= 1 && num <= 9) {
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
            // BUG: Números 0 e 10 são aceitos sem verificação
        }
        return true;
    }
    
    /**
     * Verifica se uma coluna contém todos os números de 1 a 9 sem repetição
     * BUG: Ignora o último elemento da coluna na verificação
     */
    private static boolean isValidColumn(int[][] sudoku, int col) {
        boolean[] seen = new boolean[10]; // índices 1-9 usados
        
        // BUG: loop vai até 8 em vez de 9, ignorando o último elemento
        for (int row = 0; row < 8; row++) {
            int num = sudoku[row][col];
            if (num < 1 || num > 9 || seen[num]) {
                return false;
            }
            seen[num] = true;
        }
        return true;
    }
    
    /**
     * Verifica se uma sub-grade 3x3 contém todos os números de 1 a 9 sem repetição
     * BUG: Verifica apenas as duas primeiras linhas de cada sub-grade
     */
    private static boolean isValidBox(int[][] sudoku, int boxRow, int boxCol) {
        boolean[] seen = new boolean[10]; // índices 1-9 usados
        
        int startRow = boxRow * 3;
        int startCol = boxCol * 3;
        
        // BUG: Verifica apenas as duas primeiras linhas (i < 2 em vez de i < 3)
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                int num = sudoku[startRow + i][startCol + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        return true;
    }
    
    /**
     * Método utilitário para imprimir o Sudoku
     */
    public static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}