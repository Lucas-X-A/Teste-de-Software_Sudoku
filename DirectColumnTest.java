public class DirectColumnTest {
    public static void main(String[] args) {
        // Vamos testar a função isValidColumn diretamente
        int[][] testMatrix = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {1, 1, 2, 3, 4, 5, 6, 7, 8}  // primeira coluna tem 1 duplicado
        };
        
        System.out.println("Testando primeira coluna [1,2,3,4,5,6,7,8,1] com duplicata:");
        System.out.println("G2_Sudoku_ok.isValidColumn: " + G2_Sudoku_ok.isValidColumn(testMatrix, 0));
        System.out.println("G2_Sudoku_nok.isValidColumn: " + G2_Sudoku_nok.isValidColumn(testMatrix, 0));
        
        System.out.println("\nTestando segunda coluna [2,3,4,5,6,7,8,9,1] sem duplicata:");
        System.out.println("G2_Sudoku_ok.isValidColumn: " + G2_Sudoku_ok.isValidColumn(testMatrix, 1));  
        System.out.println("G2_Sudoku_nok.isValidColumn: " + G2_Sudoku_nok.isValidColumn(testMatrix, 1));
    }
}