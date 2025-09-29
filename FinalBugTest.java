/**
 * FinalBugTest.java
 * 
 * Testes finais para demonstrar os bugs na implementação G2_Sudoku_nok
 */
public class FinalBugTest {
    
    public static void main(String[] args) {
        System.out.println("=== TESTES FINAIS PARA DEMONSTRAR BUGS ===\n");
        
        testColumnBug();
        testBoxBug();
        testNumberRangeBug();
    }
    
    /**
     * Testa o bug na validação de colunas - colunas com duplicatas passam
     */
    private static void testColumnBug() {
        System.out.println(">>> Bug na Validação de Colunas:");
        
        // Sudoku com todas as linhas válidas, mas primeira coluna tem duplicatas
        int[][] columnBugTest = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 1, 5, 6, 4, 8, 9, 7},
            {5, 6, 4, 8, 9, 7, 2, 3, 1},
            {8, 9, 7, 2, 3, 1, 5, 6, 4},
            {3, 1, 2, 6, 4, 5, 9, 7, 8},
            {6, 4, 5, 9, 7, 8, 3, 1, 2},
            {9, 7, 8, 3, 1, 2, 6, 4, 5}
        };
        
        // Agora vou modificar para ter duplicata na primeira coluna sem afetar as linhas
        columnBugTest[0][0] = 2; // mudando de 1 para 2 
        columnBugTest[3][0] = 1; // mudando de 2 para 1
        // Agora a primeira coluna tem: [2,4,7,1,5,8,3,6,9] - todas diferentes
        
        // Mas vou criar uma duplicata real:
        columnBugTest[8][0] = 2; // mudando de 9 para 2
        // Agora a primeira coluna tem: [2,4,7,1,5,8,3,6,2] - 2 repetido
        
        boolean correctResult = G2_Sudoku_ok.isValidSudoku(columnBugTest);
        boolean buggyResult = G2_Sudoku_nok.isValidSudoku(columnBugTest);
        
        System.out.println("Sudoku com duplicata na primeira coluna:");
        System.out.println("  Implementação correta detecta erro: " + !correctResult);
        System.out.println("  Implementação com bug detecta erro: " + !buggyResult);
        System.out.println("  Bug exposto: " + (correctResult != buggyResult));
        System.out.println();
    }
    
    /**
     * Testa o bug na validação de sub-grades - terceira linha das sub-grades não é verificada
     */
    private static void testBoxBug() {
        System.out.println(">>> Bug na Validação de Sub-grades:");
        
        // Sudoku válido
        int[][] validSudoku = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        
        // Criar erro na terceira linha da primeira sub-grade (linha índice 2)
        // Mudando para criar duplicata na primeira sub-grade apenas na terceira linha
        int[][] boxBugTest = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boxBugTest[i][j] = validSudoku[i][j];
            }
        }
        
        // Criar duplicata na terceira linha da primeira sub-grade
        boxBugTest[2][0] = 5; // na posição [2,0], colocar 5 (que já existe em [0,0])
        boxBugTest[0][0] = 1; // na posição [0,0], colocar 1 (que estava em [2,0])
        
        boolean correctResult = G2_Sudoku_ok.isValidSudoku(boxBugTest);
        boolean buggyResult = G2_Sudoku_nok.isValidSudoku(boxBugTest);
        
        System.out.println("Sudoku com erro na 3ª linha da primeira sub-grade:");
        System.out.println("  Implementação correta detecta erro: " + !correctResult);
        System.out.println("  Implementação com bug detecta erro: " + !buggyResult);
        System.out.println("  Bug exposto: " + (correctResult != buggyResult));
        System.out.println();
    }
    
    /**
     * Testa o bug no range de números - aceita 0 e 10
     */
    private static void testNumberRangeBug() {
        System.out.println(">>> Bug no Range de Números:");
        
        int[][] numberRangeBugTest = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 0, 2, 8, 6, 1, 7, 10} // 0 e 10 na última linha
        };
        
        boolean correctResult = G2_Sudoku_ok.isValidSudoku(numberRangeBugTest);
        boolean buggyResult = G2_Sudoku_nok.isValidSudoku(numberRangeBugTest);
        
        System.out.println("Sudoku com números inválidos (0 e 10):");
        System.out.println("  Implementação correta detecta erro: " + !correctResult);
        System.out.println("  Implementação com bug detecta erro: " + !buggyResult);
        System.out.println("  Bug exposto: " + (correctResult != buggyResult));
        System.out.println();
    }
}