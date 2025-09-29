public class DebugColumnTest {
    public static void main(String[] args) {
        // Sudoku com duplicata APENAS na primeira coluna, sem duplicatas em linhas ou sub-grades
        int[][] duplicateColumn = {
            {1, 3, 4, 6, 7, 8, 9, 5, 2},  // linha válida
            {6, 7, 2, 5, 9, 1, 3, 4, 8},  // linha válida  
            {5, 9, 8, 3, 4, 2, 1, 6, 7},  // linha válida
            {8, 1, 9, 7, 6, 5, 4, 2, 3},  // linha válida
            {4, 2, 6, 8, 1, 3, 7, 9, 5},  // linha válida
            {7, 5, 3, 9, 2, 4, 8, 1, 6},  // linha válida
            {9, 6, 1, 4, 3, 7, 2, 8, 5},  // linha válida (mudei 5 para 4)
            {2, 8, 7, 1, 5, 9, 6, 3, 4},  // linha válida (mudei 4 para 1)
            {3, 4, 5, 2, 8, 6, 5, 7, 9}   // linha válida (mudei 1 para 5), mas agora há 1 na primeira coluna (pos 0) e 1 na primeira coluna (pos 7 da primeira linha)
        };
        
        // Na verdade, vou criar um caso mais simples
        int[][] simpleColumnDup = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {1, 1, 2, 3, 4, 5, 6, 7, 8}  // 1 repetido na primeira coluna
        };
        
        System.out.println("=== TESTE SIMPLES ===");
        System.out.println("Sudoku com duplicata apenas na primeira coluna:");
        System.out.println("OK: " + G2_Sudoku_ok.isValidSudoku(simpleColumnDup));
        System.out.println("NOK: " + G2_Sudoku_nok.isValidSudoku(simpleColumnDup));
    }
}