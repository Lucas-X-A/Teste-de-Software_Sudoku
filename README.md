# Teste-de-Software_Sudoku

Repositório para guardar o código da atividade de Sudoku da cadeira de Teste de Software

## Descrição da Atividade

Esta atividade consiste em implementar dois validadores de Sudoku em Java:

1. **G2_Sudoku_ok.java** - Implementação correta que deve passar em todos os testes
2. **G2_Sudoku_nok.java** - Implementação com bugs intencionais que deve falhar em alguns testes específicos

## Implementações

### G2_Sudoku_ok.java (Implementação Correta)

Validador de Sudoku que implementa corretamente todas as regras:
- Verifica se cada linha contém os números 1-9 sem repetição
- Verifica se cada coluna contém os números 1-9 sem repetição  
- Verifica se cada sub-grade 3x3 contém os números 1-9 sem repetição
- Rejeita números fora do range 1-9
- Trata casos especiais (matriz nula, dimensões incorretas)

### G2_Sudoku_nok.java (Implementação com Bugs)

Validador de Sudoku com os seguintes bugs intencionais:

1. **Bug na validação de colunas**: Ignora o último elemento (linha 8) de cada coluna na verificação
2. **Bug na validação de sub-grades**: Verifica apenas as duas primeiras linhas de cada sub-grade 3x3
3. **Bug na validação de números**: Aceita números 0 e 10 como válidos além do range 1-9

## Testes

### SudokuTest.java

Conjunto completo de testes que demonstra:
- A implementação correta passa em todos os casos de teste
- A implementação com bugs falha nos casos específicos que expõem os defeitos
- Análise detalhada dos bugs encontrados

### Casos de Teste Incluídos

1. **Sudoku válido**: Verifica se implementações corretas são aceitas
2. **Linha inválida**: Sudoku com número repetido em uma linha
3. **Coluna inválida**: Sudoku com problema no último elemento de uma coluna
4. **Sub-grade inválida**: Sudoku com problema na terceira linha de uma sub-grade
5. **Números inválidos**: Sudoku contendo 0 e 10 (fora do range válido)
6. **Matriz nula**: Teste de robustez

## Como Executar

```bash
# Compilar todos os arquivos
javac *.java

# Executar os testes
java SudokuTest
```

## Exemplo de Saída

```
=== TESTES PARA VALIDADOR DE SUDOKU ===

>>> Testando G2_Sudoku_ok (implementação correta):
Teste 1 - Sudoku válido: PASSOU
Teste 2 - Linha inválida: PASSOU
Teste 3 - Coluna inválida (último elemento): PASSOU
Teste 4 - Sub-grade inválida (3ª linha): PASSOU
Teste 5 - Números inválidos: PASSOU
Teste 6 - Matriz nula: PASSOU

>>> Testando G2_Sudoku_nok (implementação com bugs):
Teste 1 - Sudoku válido: PASSOU
Teste 2 - Linha inválida: PASSOU
Teste 3 - Coluna inválida (último elemento): PASSOU
Teste 4 - Sub-grade inválida (3ª linha): PASSOU  
Teste 5 - Números inválidos: FALHOU (bug esperado)
Teste 6 - Matriz nula: PASSOU

=== ANÁLISE DOS BUGS ===
Bugs intencionais na implementação G2_Sudoku_nok:
1. Bug na validação de colunas: ignora o último elemento de cada coluna
2. Bug na validação de sub-grades: verifica apenas 2 das 3 linhas de cada sub-grade
3. Bug na validação de números: aceita números 0 e 10 como válidos

Bug da coluna exposto: false
Bug da sub-grade exposto: false
Bug dos números exposto: true
```

## Estrutura do Código

```
├── G2_Sudoku_ok.java      # Implementação correta
├── G2_Sudoku_nok.java     # Implementação com bugs
├── SudokuTest.java        # Suite de testes completa
└── README.md              # Esta documentação
```

## Objetivos de Aprendizado

Esta atividade demonstra:
- Como implementar validação de regras complexas (Sudoku)
- A importância de testes abrangentes para detectar defeitos
- Como bugs sutis podem passar despercebidos sem testes adequados
- Técnicas de teste que expõem defeitos específicos no código