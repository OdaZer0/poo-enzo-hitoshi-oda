# Biblioteca Comunitária

## Informações do Aluno

- **Nome:** Enzo Hitoshi Oda
- **RM:** RM567313
- **Turma:** 2CCPS
- **Curso:** Ciência da Computação
- **GitHub:** [@OdaZer0](https://github.com/OdaZer0)

---

## Descrição do Projeto

Este projeto é o resultado do aprendizado das aulas 1 a 9 de Programação
Orientada a Objetos. Desenvolvemos uma biblioteca comunitária em Java, com
acervo, livros, revistas, leitores, empréstimos, validações e menu de terminal.

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Por que precisamos criar uma classe em vez de variáveis soltas?**

Uma classe reúne dados e comportamentos relacionados a uma mesma entidade. No
projeto, objetos como `Livro`, `Leitor` e `Emprestimo` evitam listas paralelas
de nomes, códigos e datas. Isso também permite que cada objeto controle suas
próprias informações. Para um acervo real, com milhares de itens ou usuários,
classes reduzem duplicação e tornam o código organizado e reutilizável.

### Aula 2 - Métodos

**Por que separar regras em métodos específicos?**

Métodos como `emprestar()`, `devolver()` e `cadastrarItem()` centralizam as
regras de negócio. Sem eles, cada tela poderia alterar diretamente o estado do
objeto e criar combinações inválidas, como emprestar novamente um item já
emprestado. A encapsulação dessas operações também facilita testar, reutilizar e
corrigir uma regra única sem alterar várias partes do programa.

### Aula 3 - Encapsulamento

**Por que os atributos privados precisam ser protegidos?**

Os atributos privados impedem alterações inesperadas vindas de qualquer classe.
Os getters permitem consultar informações sem entregar o controle de alteração,
e métodos específicos executam mudanças com validação. Isso é semelhante a
receber uma cópia de um documento para consulta, em vez do documento original
que poderia ser alterado livremente. No projeto, o estado de disponibilidade só
deve mudar pelas operações de empréstimo e devolução.

### Aula 4 - Construtores

**Por que não criar setters para todos os atributos automaticamente?**

Nem todo dado pode ou deve ser alterado depois que o objeto é criado. Em
`Leitor`, por exemplo, a matrícula e o nome são definidos pelo construtor; os
campos são finais para evitar mudanças accidentais. Também não criamos métodos
de alteração sem necessidade. Construtores não apenas inicializam objetos:
eles aplicam validações e garantem que o objeto nasça em um estado válido.

### Aula 5 - Associação

**Por que `Emprestimo` recebe objetos inteiros em vez de apenas Strings?**

A associação é necessária porque um empréstimo precisa conhecer o leitor e o
item do acervo, não apenas seus nomes. Guardar apenas textos poderia gerar
inconsistências e impedir que o sistema encontrasse o item devolvido ou
alterasse sua disponibilidade. Com os objetos, `Emprestimo` pode acessar o
leitor, o item e aplicar o prazo correspondente.

### Aula 6 - Herança

**Por que uma classe filha não acessa diretamente os atributos privados da mãe?**

Os atributos privados de `ItemAcervo` são protegidos pelo encapsulamento e
continuam sendo definidos pela própria classe mãe. `Livro` e `Revista` usam
`super(...)` para inicializá-los, sem alterar as regras internas diretamente.
Isso evita que subclasses quebrem invariantes da superclasse e mantém uma
hierarquia previsível.

### Aula 7 - Polimorfismo

**Por que o método deve existir na hierarquia base?**

O método `getPrazoEmprestimoDias()` precisa existir em `ItemAcervo`, pois a
aplicação trata itens de forma geral. Assim, uma referência genérica `ItemAcervo`
pode chamar o método sem conhecer se o objeto real é `Livro` ou `Revista`. O
Java executa a implementação sobrescrita da classe concreta, garantindo 14 dias
para livros e 7 dias para revistas.

### Aula 8 - Classes Abstratas

**Por que `ItemAcervo` é abstrata?**

Um item genérico representa o conceito comum, mas não deveria ser criado sem um
tipo concreto como livro ou revista. `abstract` impede a criação de objetos da
classe base incompletos e declara métodos como `getPrazoEmprestimoDias()` e
`getTipo()` que só podem ser definidos pelas subclasses. A decisão também deixa
explícito o contrato arquitetural, pois o Java não consegue inferir sozinho quais
conceitos são abstratos.

### Aula 9 - Interfaces

**Por que interfaces resolvem melhor múltiplos contratos?**

`Emprestavel` define um contrato separado para objetos que podem ser emprestados
e devolvidos, incluindo prazo mínimo como constante. Java permite uma única
herança, mas pode implementar vários contratos sem carregar implementações e
estados das “classes mães”. Assim, evita ambiguidades comuns da herança múltipla,
como dois métodos `ligar()` com implementações conflitantes, permitindo que cada
classe forneça seu comportamento conforme o contrato.

---

## Desafios Técnicos Implementados

### Desafio Pessoal: Biblioteca Comunitária

**Quais classes foram criadas?**

`Livro`, `Revista`, `Leitor`, `Emprestimo`, `ItemAcervo`, `Biblioteca`,
`SistemaBiblioteca` e a interface `Emprestavel`.

**Qual foi o maior desafio técnico e como foi resolvido?**

O maior desafio foi integrar herança, associação e regras de disponibilidade sem
permitir estados inválidos. A solução foi concentrar o empréstimo em
`Biblioteca` e `Emprestimo`, enquanto `ItemAcervo` controla
`disponivel`. O construtor de `Emprestimo` tenta reservar o item e lança uma
exceção se ele já estiver emprestado. Também centralizamos validações nos
construtores e usamos `IllegalArgumentException` ou `IllegalStateException`
quando uma operação não pode ser executada.

## Estrutura

- `src/main`: menu de linha de comando e dados iniciais de exemplo.
- `src/model`: classes de domínio, hierarquia de acervo e interface.
- `test`: verificações executáveis sem bibliotecas externas.

## Conclusão

O projeto permitiu aplicar encapsulamento, associações, herança, polimorfismo,
classes abstratas e interfaces em um cenário coerente. O conceito mais difícil
foi entender como o polimorfismo usa uma referência da classe base para executar
a implementação da classe concreta. Superando isso com testes e o fluxo do
prazo, a hierarquia ficou mais clara. Se fosse refazer, adicionaria persistência
de dados, identificação única de leitores, histórico completo de empréstimos e
testes automatizados separados por classe.

## Executar

Requer um JDK instalado. A partir desta pasta, no PowerShell:

```powershell
$sources = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $sources
java -cp out main.SistemaBiblioteca
```

## Testar

```powershell
$sources = Get-ChildItem src,test -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $sources
java -ea -cp out test.TesteBiblioteca
```
