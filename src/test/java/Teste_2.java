import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Teste_2 {

    private static final String CAMINHO_VALIDO = "2_solucao1_sim.txt";
    private static final String CAMINHO_INVALIDO = "2_solucao1_nao.txt";
    private static final String CAMINHO_INVALIDO_2 = "2_solucao2_nao.txt";

    // --- Testes para a classe G2_Sudoku_ok ---

    @Test
    @DisplayName("G2_Sudoku_ok: Deve retornar true para um Sudoku válido")
    void testeSudokuOkComSolucaoValida() {
        G2_Sudoku_ok sudoku = new G2_Sudoku_ok(CAMINHO_VALIDO);
        assertTrue(sudoku.valido(), "Deveria retornar true para um tabuleiro válido.");
    }

    @Test
    @DisplayName("G2_Sudoku_ok: Deve retornar false para um Sudoku inválido")
    void testeSudokuOkComSolucaoInvalida() {
        G2_Sudoku_ok sudoku = new G2_Sudoku_ok(CAMINHO_INVALIDO);
        assertFalse(sudoku.valido(), "Deveria retornar false para um tabuleiro com erro na primeira coluna.");
    }

    @Test
    @DisplayName("G2_Sudoku_ok: Deve retornar false para um Sudoku inválido")
    void testeSudokuOkComSolucaoInvalidaUltimaColuna() {
        G2_Sudoku_ok sudoku = new G2_Sudoku_ok(CAMINHO_INVALIDO_2);
        assertFalse(sudoku.valido(), "Deveria retornar false para um tabuleiro com erro na última coluna.");
    }


    // --- Testes para a classe G2_Sudoku_nok ---

    @Test
    @DisplayName("G2_Sudoku_nok: Deve retornar true para um Sudoku válido")
    void testeSudokuNokComSolucaoValida() {
        G2_Sudoku_nok sudoku = new G2_Sudoku_nok(CAMINHO_VALIDO);
        assertTrue(sudoku.valido(), "Deveria retornar true para um tabuleiro válido, pois o erro não afeta este caso.");
    }

    @Test
    @DisplayName("G2_Sudoku_nok: Deve retornar false para um Sudoku inválido")
    void testeSudokuNokComSolucaoInvalida() {
        G2_Sudoku_nok sudoku = new G2_Sudoku_nok(CAMINHO_INVALIDO);
        assertFalse(sudoku.valido(), "Deve retornar false.");
    }

    @Test
    @DisplayName("G2_Sudoku_nok: Deve retornar true para um Sudoku com erro apenas na última coluna e linha")
    void testeSudokuNokComErroNaoDetectado() {
        G2_Sudoku_nok sudoku = new G2_Sudoku_nok(CAMINHO_INVALIDO_2);
        assertTrue(sudoku.valido(), "Deveria retornar true, pois dá falso positivo.");
    }
}
