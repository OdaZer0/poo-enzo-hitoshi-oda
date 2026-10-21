# Biblioteca Comunitaria

Projeto didático de Programação Orientada a Objetos em Java sobre o catálogo
de uma biblioteca comunitária.

Os dados do livro são encapsulados e informados por um construtor que valida
os campos obrigatórios. A entidade oferece operações básicas para emprestar e
devolver um exemplar.

## Estrutura inicial

- `src/main`: demonstração inicial do domínio.
- `src/model`: entidades da biblioteca.

## Executar

Requer um JDK instalado. A partir desta pasta, no PowerShell:

```powershell
$sources = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $sources
java -cp out main.SistemaBiblioteca
```
