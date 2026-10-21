# Biblioteca Comunitaria

Projeto didático de Programação Orientada a Objetos em Java sobre o catálogo
de uma biblioteca comunitária.

Os dados do livro são encapsulados e informados por um construtor que valida
os campos obrigatórios. A entidade oferece operações básicas para emprestar e
devolver um exemplar.

## Estrutura atual

- `src/main`: demonstração do empréstimo.
- `src/model`: item de acervo, livro, revista, leitor e empréstimo.

`Livro` e `Revista` herdam os dados e o controle de disponibilidade de
`ItemAcervo`. `Emprestimo` associa um leitor a qualquer item do acervo.
O prazo é polimórfico: livros podem ser emprestados por 14 dias e revistas
por 7 dias, regra consultada pelo empréstimo por meio da classe abstrata.

## Executar

Requer um JDK instalado. A partir desta pasta, no PowerShell:

```powershell
$sources = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $sources
java -cp out main.SistemaBiblioteca
```
