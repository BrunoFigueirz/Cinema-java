//./Sala.java

public class Sala {
    
    // Atributos da Sala
    private int numeroSala;
    private char[][] assentos; // Matriz 2D para as poltronas
    private int totalLinhas;
    private int totalColunas;

    // Construtor
    public Sala(int numeroSala, int linhas, int colunas) {
        this.numeroSala = numeroSala;
        this.totalLinhas = linhas;
        this.totalColunas = colunas;
        this.assentos = new char[linhas][colunas];
        criarSala(); // Inicializa a matriz ao criar a sala
    }

    // M\u00e9todo para instanciar as salas com a matriz 2D (tudo vazio 'O')
    private void criarSala() {
        for (int i = 0; i < totalLinhas; i++) {
            for (int j = 0; j < totalColunas; j++) {
                assentos[i][j] = 'O'; // 'O' representa assento dispon\u00edvel
            }
        }
    }

    // M\u00e9todo para exibir o mapa da sala visualmente no ecr\u00e3
    public void mostrarSala() {
        System.out.println("\n--- Mapa da Sala " + numeroSala + " ---");
        System.out.print("  ");
        for (int j = 0; j < totalColunas; j++) {
            System.out.print(j + " "); // Imprime o n\u00famero das colunas
        }
        System.out.println();

        for (int i = 0; i < totalLinhas; i++) {
            System.out.print(i + " "); // Imprime o n\u00famero da linha
            for (int j = 0; j < totalColunas; j++) {
                System.out.print(assentos[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------\n");
    }

    // M\u00e9todo para marcar o assento (trocar 'O' por 'X')
    public void reservarAssento(int linha, int coluna) {
        // Verifica se a linha e coluna s\u00e3o v\u00e1lidas
        if (linha >= 0 && linha < totalLinhas && coluna >= 0 && coluna < totalColunas) {
            if (assentos[linha][coluna] == 'O') {
                assentos[linha][coluna] = 'X';
                System.out.println("Reserva efetuada com sucesso!");
            } else {
                System.out.println("Erro: O assento j\u00e1 est\u00e1 ocupado ('X').");
            }
        } else {
            System.out.println("Erro: Assento inv\u00e1lido.");
        }
    }

    // M\u00e9todo para desmarcar um assento ocupado
    public void cancelarReserva(int linha, int coluna) {
        if (linha >= 0 && linha < totalLinhas && coluna >= 0 && coluna < totalColunas) {
            if (assentos[linha][coluna] == 'X') {
                assentos[linha][coluna] = 'O';
                System.out.println("Reserva cancelada com sucesso!");
            } else {
                System.out.println("Erro: O assento j\u00e1 se encontra livre ('O').");
            }
        } else {
            System.out.println("Erro: Assento inv\u00e1lido.");
        }
    }

    // M\u00e9todo para a consulta de lugares dispon\u00edveis
    public int assentoDisponivel() {
        int contadorLivres = 0;
        for (int i = 0; i < totalLinhas; i++) {
            for (int j = 0; j < totalColunas; j++) {
                if (assentos[i][j] == 'O') {
                    contadorLivres++;
                }
            }
        }
        return contadorLivres;
    }

    // Getters
    public int getNumeroSala() {
        return numeroSala;
    }

    public int getTotalLinhas() {
        return totalLinhas;
    }

    public int getTotalColunas() {
        return totalColunas;
    }

    public char getAssento(int linha, int coluna) {
        return assentos[linha][coluna];
    }

    // Usado apenas pela persist\u00eancia para restaurar o estado sem passar
    // pelas valida\u00e7\u00f5es de "j\u00e1 ocupado"/"j\u00e1 livre" da reserva normal.
    public void definirAssentoDireto(int linha, int coluna, char status) {
        if (linha >= 0 && linha < totalLinhas && coluna >= 0 && coluna < totalColunas) {
            assentos[linha][coluna] = status;
        }
    }
}