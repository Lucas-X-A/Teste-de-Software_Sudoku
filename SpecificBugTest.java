/**
 * SpecificBugTest.java
 * 
 * Testes específicos para expor os bugs na implementação G2_Sudoku_nok
 */
public class SpecificBugTest {
    
    public static void main(String[] args) {
        System.out.println("=== TESTES ESPECÍFICOS PARA EXPOR BUGS ===\n");
        
        testColumnBug();
        testBoxBug();
        testNumberRangeBug();
    }
    
    /**
     * Testa o bug na validação de colunas
     * O bug faz com que duplicatas em colunas não sejam detectadas
     */
    private static void testColumnBug() {
        System.out.println(">>> Teste do Bug nas Colunas:");
        
        // Sudoku com coluna inválida (número 1 repetido na primeira coluna, mas trocando 5 por 1)
        int[][] invalidColumn = {
            {1, 3, 4, 6, 7, 8, 9, 5, 2},  // mudei 5 para 1, e 1 para 5
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {5, 9, 8, 3, 4, 2, 1, 6, 7},  // mudei 1 para 5, e 5 para 1
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {1, 4, 5, 2, 8, 6, 5, 7, 9}  // 1 repetido na primeira coluna, 5 repetido na terceira
        };
        
        boolean correctResult = G2_Sudoku_ok.isValidSudoku(invalidColumn);
        boolean buggyResult = G2_Sudoku_nok.isValidSudoku(invalidColumn);
        
        System.out.println("Implementação correta detecta erro: " + !correctResult);
        System.out.println("Implementação com bug detecta erro: " + !buggyResult);
        System.out.println("Bug exposto: " + (correctResult != buggyResult));
        System.out.println();
    }
    
    /**
     * Testa o bug na validação de sub-grades
     * O bug faz com que apenas as duas primeiras linhas de cada sub-grade sejam verificadas
     */
    private static void testBoxBug() {
        System.out.println(">>> Teste do Bug nas Sub-grades:");
        
        // Sudoku com erro apenas na terceira linha da primeira sub-grade
        int[][] invalidBoxThirdRow = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {5, 9, 8, 3, 4, 2, 5, 6, 7}, // 5 repetido na terceira linha da primeira sub-grade
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        
        boolean correctResult = G2_Sudoku_ok.isValidSudoku(invalidBoxThirdRow);
        boolean buggyResult = G2_Sudoku_nok.isValidSudoku(invalidBoxThirdRow);
        
        System.out.println("Implementação correta detecta erro: " + !correctResult);
        System.out.println("Implementação com bug detecta erro: " + !buggyResult);
        System.out.println("Bug exposto: " + (correctResult != buggyResult));
        System.out.println();
    }
    
    /**
     * Testa o bug na validação de range de números
     * O bug aceita números 0 e 10 como válidos
     */
    private static void testNumberRangeBug() {
        System.out.println(">>> Teste do Bug no Range de Números:");
        
        // Sudoku com números fora do range válido
        int[][] invalidNumbers = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 0, 2, 8, 6, 1, 7, 10} // 0 e 10 são números inválidos
        };
        
        boolean correctResult = G2_Sudoku_ok.isValidSudoku(invalidNumbers);
        boolean buggyResult = G2_Sudoku_nok.isValidSudoku(invalidNumbers);
        
        System.out.println("Implementação correta detecta erro: " + !correctResult);
        System.out.println("Implementação com bug detecta erro: " + !buggyResult);
        System.out.println("Bug exposto: " + (correctResult != buggyResult));
        System.out.println();
    }
}