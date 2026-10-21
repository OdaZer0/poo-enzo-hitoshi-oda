# Biblioteca Comunitaria

Projeto didático de Programação Orientada a Objetos em Java sobre o catálogo
de uma biblioteca comunitária.

Os dados do livro são encapsulados e informados por um construtor que valida
os campos obrigatórios. A entidade oferece operações básicas para emprestar e
devolver um exemplar.

## Estrutura atual

- `src/main`: demonstração do empréstimo.
- `src/model`: livro, leitor e empréstimo.

`Emprestimo` associa um leitor a um livro e controla as datas e a devolução.

## Executar

Requer um JDK instalado. A partir desta pasta, no PowerShell:

```powershell
$sources = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $sources
java -cp out main.SistemaBiblioteca
```
