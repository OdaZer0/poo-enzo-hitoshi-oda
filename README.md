# Biblioteca Comunitaria

Projeto didático de Programação Orientada a Objetos em Java sobre o catálogo
de uma biblioteca comunitária.

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
