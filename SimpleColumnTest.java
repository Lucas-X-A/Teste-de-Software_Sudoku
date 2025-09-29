public class SimpleColumnTest {
    public static void main(String[] args) {
        // Sudoku que é válido exceto por duplicata na primeira coluna
        int[][] columnDuplicateOnly = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 1, 5, 6, 4, 8, 9, 7},
            {5, 6, 4, 8, 9, 7, 2, 3, 1},
            {8, 9, 7, 2, 3, 1, 5, 6, 4},
            {3, 1, 2, 6, 4, 5, 9, 7, 8},
            {6, 4, 5, 9, 7, 8, 3, 1, 2},
            {1, 7, 8, 3, 1, 2, 6, 4, 5}  // 1 repetido na primeira coluna (posições [0,0] e [8,0])
        };
        
        System.out.println("Teste simples - duplicata apenas na coluna:");
        System.out.println("G2_Sudoku_ok resultado: " + G2_Sudoku_ok.isValidSudoku(columnDuplicateOnly));
        System.out.println("G2_Sudoku_nok resultado: " + G2_Sudoku_nok.isValidSudoku(columnDuplicateOnly));
    }
}