/**
 * SudokuTest.java
 * 
 * Conjunto de testes para validar as implementações do validador de Sudoku.
 * Inclui casos de teste para verificar que G2_Sudoku_ok passa todos os testes
 * e que G2_Sudoku_nok falha nos testes apropriados devido a bugs intencionais.
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
    
    // Sudoku com problema APENAS na última linha de uma coluna (expõe bug da coluna)
    private static final int[][] INVALID_COLUMN_LAST_ROW = {
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {2, 3, 4, 5, 6, 7, 8, 9, 1},
        {3, 4, 5, 6, 7, 8, 9, 1, 2},
        {4, 5, 6, 7, 8, 9, 1, 2, 3},
        {5, 6, 7, 8, 9, 1, 2, 3, 4},
        {6, 7, 8, 9, 1, 2, 3, 4, 5},
        {7, 8, 9, 1, 2, 3, 4, 5, 6},
        {8, 9, 1, 2, 3, 4, 5, 6, 7},
        {1, 9, 2, 3, 4, 5, 6, 7, 8}  // 1 na primeira coluna = duplicata com linha 0
    };
    
    // Sudoku com problema na terceira linha da sub-grade (expõe bug da sub-grade)
    private static final int[][] INVALID_BOX_THIRD_ROW = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {5, 9, 8, 3, 4, 2, 1, 6, 7}, // 5 repetido na primeira sub-grade (terceira linha)
        {8, 1, 9, 7, 6, 5, 4, 2, 3},
        {4, 2, 6, 8, 1, 3, 7, 9, 5},
        {7, 5, 3, 9, 2, 4, 8, 1, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 5, 9, 6, 3, 1},
        {3, 4, 5, 2, 8, 6, 5, 7, 9}
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
    
    public static void main(String[] args) {
        System.out.println("=== TESTES PARA VALIDADOR DE SUDOKU ===\n");
        
        // Testa implementação correta
        System.out.println(">>> Testando G2_Sudoku_ok (implementação correta):");
        testCorrectImplementation();
        
        System.out.println("\n>>> Testando G2_Sudoku_nok (implementação com bugs):");
        testBuggyImplementation();
        
        System.out.println("\n=== ANÁLISE DOS BUGS ===");
        analyzeBugs();
    }
    
    private static void testCorrectImplementation() {
        System.out.println("Teste 1 - Sudoku válido: " + 
            (G2_Sudoku_ok.isValidSudoku(VALID_SUDOKU) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 2 - Linha inválida: " + 
            (!G2_Sudoku_ok.isValidSudoku(INVALID_ROW) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 3 - Coluna inválida (último elemento): " + 
            (!G2_Sudoku_ok.isValidSudoku(INVALID_COLUMN_LAST_ROW) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 4 - Sub-grade inválida (3ª linha): " + 
            (!G2_Sudoku_ok.isValidSudoku(INVALID_BOX_THIRD_ROW) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 5 - Números inválidos: " + 
            (!G2_Sudoku_ok.isValidSudoku(INVALID_NUMBERS) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 6 - Matriz nula: " + 
            (!G2_Sudoku_ok.isValidSudoku(null) ? "PASSOU" : "FALHOU"));
    }
    
    private static void testBuggyImplementation() {
        System.out.println("Teste 1 - Sudoku válido: " + 
            (G2_Sudoku_nok.isValidSudoku(VALID_SUDOKU) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 2 - Linha inválida: " + 
            (!G2_Sudoku_nok.isValidSudoku(INVALID_ROW) ? "PASSOU" : "FALHOU"));
        
        System.out.println("Teste 3 - Coluna inválida (último elemento): " + 
            (!G2_Sudoku_nok.isValidSudoku(INVALID_COLUMN_LAST_ROW) ? "PASSOU" : "FALHOU (bug esperado)"));
        
        System.out.println("Teste 4 - Sub-grade inválida (3ª linha): " + 
            (!G2_Sudoku_nok.isValidSudoku(INVALID_BOX_THIRD_ROW) ? "PASSOU" : "FALHOU (bug esperado)"));
        
        System.out.println("Teste 5 - Números inválidos: " + 
            (!G2_Sudoku_nok.isValidSudoku(INVALID_NUMBERS) ? "PASSOU" : "FALHOU (bug esperado)"));
        
        System.out.println("Teste 6 - Matriz nula: " + 
            (!G2_Sudoku_nok.isValidSudoku(null) ? "PASSOU" : "FALHOU"));
    }
    
    private static void analyzeBugs() {
        System.out.println("Bugs intencionais na implementação G2_Sudoku_nok:");
        System.out.println("1. Bug na validação de colunas: ignora o último elemento de cada coluna");
        System.out.println("2. Bug na validação de sub-grades: verifica apenas 2 das 3 linhas de cada sub-grade");
        System.out.println("3. Bug na validação de números: aceita números 0 e 10 como válidos");
        
        // Teste específico para demonstrar os bugs
        boolean correctColumn = !G2_Sudoku_ok.isValidSudoku(INVALID_COLUMN_LAST_ROW);
        boolean buggyColumn = !G2_Sudoku_nok.isValidSudoku(INVALID_COLUMN_LAST_ROW);
        System.out.println("\nBug da coluna exposto: " + (correctColumn != buggyColumn));
        
        boolean correctBox = !G2_Sudoku_ok.isValidSudoku(INVALID_BOX_THIRD_ROW);
        boolean buggyBox = !G2_Sudoku_nok.isValidSudoku(INVALID_BOX_THIRD_ROW);
        System.out.println("Bug da sub-grade exposto: " + (correctBox != buggyBox));
        
        boolean correctNumbers = !G2_Sudoku_ok.isValidSudoku(INVALID_NUMBERS);
        boolean buggyNumbers = !G2_Sudoku_nok.isValidSudoku(INVALID_NUMBERS);
        System.out.println("Bug dos números exposto: " + (correctNumbers != buggyNumbers));
    }
}