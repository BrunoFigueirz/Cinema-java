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

    // Método para instanciar as salas com a matriz 2D (tudo vazio 'O')
    private void criarSala() {
        for (int i = 0; i < totalLinhas; i++) {
            for (int j = 0; j < totalColunas; j++) {
                assentos[i][j] = 'O'; // 'O' representa assento disponível
            }
        }
    }

    // Método para exibir o mapa da sala visualmente no ecrã
    public void mostrarSala() {
        System.out.println("\n--- Mapa da Sala " + numeroSala + " ---");
        System.out.print("  ");
        for (int j = 0; j < totalColunas; j++) {
            System.out.print(j + " "); // Imprime o número das colunas
        }
        System.out.println();

        for (int i = 0; i < totalLinhas; i++) {
            System.out.print(i + " "); // Imprime o número da linha
            for (int j = 0; j < totalColunas; j++) {
                System.out.print(assentos[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------\n");
    }

    // Método para marcar o assento (trocar 'O' por 'X')
    public void reservarAssento(int linha, int coluna) {
        // Verifica se a linha e coluna são válidas
        if (linha >= 0 && linha < totalLinhas && coluna >= 0 && coluna < totalColunas) {
            if (assentos[linha][coluna] == 'O') {
                assentos[linha][coluna] = 'X';
                System.out.println("Reserva efetuada com sucesso!");
            } else {
                System.out.println("Erro: O assento já está ocupado ('X').");
            }
        } else {
            System.out.println("Erro: Assento inválido.");
        }
    }

    // Método para desmarcar um assento ocupado
    public void cancelarReserva(int linha, int coluna) {
        if (linha >= 0 && linha < totalLinhas && coluna >= 0 && coluna < totalColunas) {
            if (assentos[linha][coluna] == 'X') {
                assentos[linha][coluna] = 'O';
                System.out.println("Reserva cancelada com sucesso!");
            } else {
                System.out.println("Erro: O assento já se encontra livre ('O').");
            }
        } else {
            System.out.println("Erro: Assento inválido.");
        }
    }

    // Método para a consulta de lugares disponíveis
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
}