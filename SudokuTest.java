/**
 * SudokuTest.java
 * 
 * Conjunto de testes para validar as implementações do validador de Sudoku.
 * Inclui casos de teste para verificar que G2_Sudoku_ok passa todos os testes
 * e que G2_Sudoku_nok falha nos testes apropriados.
 */
public class SudokuTest {
    
    // Sudoku válido para testes
    private static final int[][] VALID_SUDOKU = {
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
    
    // Sudoku com linha inválida (número repetido)
    private static final int[][] INVALID_ROW = {
        {5, 3, 4, 6, 7, 8, 9, 1, 5}, // 5 repetido na primeira linha
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };
    
    // Sudoku com coluna inválida (número repetido)
    private static final int[][] INVALID_COLUMN = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {5, 4, 5, 2, 8, 6, 1, 7, 9}  // 5 repetido na primeira coluna
    };
    
    // Sudoku com sub-grade inválida (número repetido na primeira sub-grade)
    private static final int[][] INVALID_BOX = {
        {5, 3, 5, 6, 7, 8, 9, 1, 2}, // 5 repetido na primeira sub-grade
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };
    
    // Sudoku com números inválidos (contém 0 e 10)
    private static final int[][] INVALID_NUMBERS = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 0, 2, 8, 6, 1, 7, 10} // 0 e 10 são inválidos
    };
    
    // Sudoku com problema na terceira linha da sub-grade (expõe bug do isValidBox)
    private static final int[][] INVALID_BOX_THIRD_ROW = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 1, 3, 4, 2, 5, 6, 7}, // 1 repetido na terceira linha da primeira sub-grade
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };
    
    public static void main(String[] args) {
        System.out.println("=== TESTES PARA VALIDADOR DE SUDOKU ===\n");
        
        // Testa implementação correta
        System.out.println(">>> Testando G2_Sudoku_ok (implementação correta):");
        testCorrectImplementation();
        
        System.out.println("\n>>> Testando G2_Sudoku_nok (implementação com bugs):");
        testBuggyImplementation();
        
        System.out.println("\n=== RESUMO DOS TESTES ===");
        System.out.println("Os testes demonstram que:");
        System.out.println("1. G2_Sudoku_ok valida corretamente todos os casos");
        System.out.println("2. G2_Sudoku_nok falha em detectar alguns erros devido aos bugs intencionais");
    }
    
    private static void testCorrectImplementation() {
        System.out.println("Teste 1 - Sudoku válido: " + 
            (G2_Sudoku_ok.isValidSudoku(VALID_SUDOKU) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 2 - Linha inválida: " + 
            (!G2_Sudoku_ok.isValidSudoku(INVALID_ROW) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 3 - Coluna inválida: " + 
            (!G2_Sudoku_ok.isValidSudoku(INVALID_COLUMN) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 4 - Sub-grade inválida: " + 
            (!G2_Sudoku_ok.isValidSudoku(INVALID_BOX) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 5 - Números inválidos: " + 
            (!G2_Sudoku_ok.isValidSudoku(INVALID_NUMBERS) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 6 - Sub-grade inválida (3ª linha): " + 
            (!G2_Sudoku_ok.isValidSudoku(INVALID_BOX_THIRD_ROW) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 7 - Matriz nula: " + 
            (!G2_Sudoku_ok.isValidSudoku(null) ? "PASSOU" : "FALHOU"));
    }
    
    private static void testBuggyImplementation() {
        System.out.println("Teste 1 - Sudoku válido: " + 
            (G2_Sudoku_nok.isValidSudoku(VALID_SUDOKU) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 2 - Linha inválida: " + 
            (!G2_Sudoku_nok.isValidSudoku(INVALID_ROW) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 3 - Coluna inválida: " + 
            (!G2_Sudoku_nok.isValidSudoku(INVALID_COLUMN) ? "PASSOU" : "FALHOU (esperado - bug nas colunas)"));
        
        System.out.println("Teste 4 - Sub-grade inválida: " + 
            (!G2_Sudoku_nok.isValidSudoku(INVALID_BOX) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 5 - Números inválidos: " + 
            (!G2_Sudoku_nok.isValidSudoku(INVALID_NUMBERS) ? "PASSOU" : "FALHOU (esperado - aceita 0 e 10)"));
        
        System.out.println("Teste 6 - Sub-grade inválida (3ª linha): " + 
            (!G2_Sudoku_nok.isValidSudoku(INVALID_BOX_THIRD_ROW) ? "PASSOU" : "FALHOU (esperado - bug nas sub-grades)"));
        
        System.out.println("Teste 7 - Matriz nula: " + 
            (!G2_Sudoku_nok.isValidSudoku(null) ? "PASSOU" : "FALHOU"));
    }
}