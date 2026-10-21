# Biblioteca Comunitária

Projeto didático de Programação Orientada a Objetos em Java sobre o catálogo
de uma biblioteca comunitária.

## Estrutura

- `src/main`: menu de linha de comando e dados iniciais de exemplo.
- `src/model`: item de acervo, livro, revista, leitor e empréstimo.
- `src/service`: regras de catálogo, empréstimo e devolução.
- `test`: verificações executáveis sem bibliotecas externas.

`Livro` e `Revista` herdam os dados e o controle de disponibilidade de
`ItemAcervo`. `Emprestimo` associa um leitor a qualquer item do acervo.
O prazo é polimórfico: livros podem ser emprestados por 14 dias e revistas
por 7 dias, regra consultada pelo empréstimo por meio da classe abstrata.

## Conceitos e progressão didática

O histórico do projeto registra as etapas de forma incremental:

1. Classe `Livro` e criação de uma instância.
2. Métodos de comportamento para emprestar e devolver.
3. Encapsulamento e validação por construtor.
4. Associação entre `Leitor`, `Livro` e `Emprestimo`.
5. Herança com `ItemAcervo`, `Livro` e `Revista`.
6. Polimorfismo para os prazos de empréstimo.
7. Integração dos casos de uso, menu e testes.

As etapas descrevem o desenvolvimento deste projeto e não atribuem a ele o
histórico ou as contribuições do repositório usado como referência.

## Executar

Requer um JDK instalado. A partir desta pasta, no PowerShell:

```powershell
$sources = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $sources
java -cp out main.SistemaBiblioteca
```

O menu permite listar o acervo, registrar empréstimos e devolver itens. Os
dados são mantidos apenas durante a execução.

## Testar

```powershell
$sources = Get-ChildItem src,test -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $sources
java -ea -cp out test.TesteBiblioteca
```
