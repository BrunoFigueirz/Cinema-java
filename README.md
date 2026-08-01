# Sistema de Gestão de Cinema

Sistema em Java para gerenciar filmes, salas, sessões e reservas de assentos de um cinema, via terminal (linha de comando).

## Funcionalidades

O sistema é operado por um menu no terminal com as seguintes opções:

| Opção | Ação |
|---|---|
| 1 | Cadastrar Filme |
| 2 | Listar Filmes |
| 3 | Criar Sala |
| 4 | Criar Sessão |
| 5 | Mostrar Mapa da Sala |
| 6 | Reservar Assento |
| 7 | Cancelar Reserva |
| 8 | Salvar Dados |
| 9 | Carregar Dados |
| 0 | Sair |

## Estrutura do projeto

```
Cinema_Java_Jorge/
├── Main.java                # Ponto de entrada; menu principal e interação com o usuário
├── Filme.java                # Representa um filme (título, gênero, duração, classificação)
├── Sala.java                 # Representa uma sala, com matriz 2D de assentos ('O' = livre, 'X' = ocupado)
├── Sessao.java                # Representa uma sessão (filme + sala + horário)
├── PersistenciaDados.java     # Salva/carrega o estado das reservas em reservas.txt
└── README.md
```

### Como as classes se relacionam

- Uma **Sessão** liga um **Filme** a uma **Sala** em um horário específico.
- Uma **Sala** guarda o mapa de assentos como uma matriz `char[][]` — cada posição é `'O'` (livre) ou `'X'` (ocupado).
- A **PersistenciaDados** salva, para cada sessão, apenas as posições dos assentos ocupados (não salva filmes/salas/sessões em si — ao carregar, as sessões precisam já existir em memória com os mesmos IDs).

## Como compilar e executar

Pré-requisito: JDK 17 ou superior instalado (`java -version` para conferir).

```bash
# Compilar
javac *.java

# Executar
java Main
```

### ⚠️ Nota sobre acentuação (importante)

O código já força a saída (`System.out`) e a leitura de teclado (`Scanner`) a usarem UTF-8 explicitamente no `Main.java`, então os acentos (Gestão, Sessão, opção etc.) devem aparecer corretos **independente do terminal usado** — inclusive no Prompt de Comando do Windows, que por padrão não usa UTF-8 e costuria fazer acentos aparecerem como `?`.

Se ainda assim aparecerem caracteres estranhos no seu terminal, tente rodar com:

```bash
java -Dfile.encoding=UTF-8 Main
```

## Persistência de dados

Ao escolher **8 (Salvar Dados)**, o estado dos assentos ocupados de cada sessão é salvo em `reservas.txt`, no formato:

```
SessaoID:1
2,2
3,4
FIM_SESSAO
```

Cada linha `linha,coluna` representa um assento ocupado (`'X'`) daquela sessão.

**Atenção:** a opção **9 (Carregar Dados)** só restaura os assentos corretamente se as *mesmas sessões* (mesmos IDs, na mesma ordem de criação) já tiverem sido recriadas em memória antes de carregar — o arquivo guarda só o estado dos assentos, não os filmes/salas/sessões em si.

## Autor

Jorge — projeto desenvolvido em Java como parte do trabalho de Sistema de Reserva de Cinema.
