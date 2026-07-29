//./Main


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    // Listas para gerir os dados em memória
    private static List<Filme> filmes = new ArrayList<>();
    private static List<Sala> salas = new ArrayList<>();
    private static List<Sessao> sessoes = new ArrayList<>();
    private static PersistenciaDados persistencia = new PersistenciaDados();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== Sistema de Gestão de Cinema ===");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Listar Filmes");
            System.out.println("3. Criar Sala");
            System.out.println("4. Criar Sessão");
            System.out.println("5. Mostrar Mapa da Sala");
            System.out.println("6. Reservar Assento");
            System.out.println("7. Cancelar Reserva");
            System.out.println("8. Salvar Dados");
            System.out.println("9. Carregar Dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    cadastrarFilme();
                    break;
                case 2:
                    listarFilmes();
                    break;
                case 3:
                    criarSala();
                    break;
                case 4:
                    criarSessao();
                    break;
                case 5:
                    mostrarMapa();
                    break;
                case 6:
                    reservarAssentoMenu();
                    break;
                case 7:
                    cancelarReservaMenu();
                    break;
                case 8:
                    persistencia.salvarReservas(sessoes);
                    break;
                case 9:
                    persistencia.carregarReservas();
                    break;
                case 0:
                    System.out.println("A encerrar o sistema do Cinema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // --- Implementação das Possíveis Funções Exigidas ---

    private static void cadastrarFilme() {
        System.out.print("Título do Filme: ");
        String titulo = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Duração (minutos): ");
        int duracao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Classificação Indicativa: ");
        String classificacao = scanner.nextLine();

        Filme novoFilme = new Filme(titulo, genero, duracao, classificacao);
        filmes.add(novoFilme);
        System.out.println("Filme cadastrado com sucesso!");
    }

    private static void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println("[" + i + "] " + filmes.get(i).toString());
        }
    }

    private static void criarSala() {
        System.out.print("Número da Sala: ");
        int numero = scanner.nextInt();
        System.out.print("Total de Linhas: ");
        int linhas = scanner.nextInt();
        System.out.print("Total de Colunas: ");
        int colunas = scanner.nextInt();

        Sala novaSala = new Sala(numero, linhas, colunas);
        salas.add(novaSala);
        System.out.println("Sala " + numero + " criada com sucesso (Matriz 2D " + linhas + "x" + colunas + ").");
    }

    private static void criarSessao() {
        if (filmes.isEmpty() || salas.isEmpty()) {
            System.out.println("É necessário ter pelo menos um filme e uma sala cadastrados.");
            return;
        }

        System.out.println("Selecione o Filme:");
        listarFilmes();
        int indexFilme = scanner.nextInt();

        System.out.println("Selecione a Sala:");
        for (int i = 0; i < salas.size(); i++) {
            System.out.println("[" + i + "] Sala " + salas.get(i).getNumeroSala());
        }
        int indexSala = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        System.out.print("Horário da Sessão (ex: 20:00): ");
        String horario = scanner.nextLine();

        int idSessao = sessoes.size() + 1;
        Sessao novaSessao = new Sessao(idSessao, filmes.get(indexFilme), salas.get(indexSala), horario);
        sessoes.add(novaSessao);
        System.out.println("Sessão " + idSessao + " criada com sucesso!");
    }

    private static Sessao selecionarSessao() {
        if (sessoes.isEmpty()) {
            System.out.println("Nenhuma sessão disponível.");
            return null;
        }
        System.out.println("Sessões disponíveis:");
        for (int i = 0; i < sessoes.size(); i++) {
            System.out.println("[" + i + "] Sessão " + sessoes.get(i).getIdSessao() + " - " + sessoes.get(i).getFilme().getTitulo());
        }
        System.out.print("Selecione o ID da Sessão na lista: ");
        int index = scanner.nextInt();
        return sessoes.get(index);
    }

    private static void mostrarMapa() {
        Sessao sessao = selecionarSessao();
        if (sessao != null) {
            sessao.getSala().mostrarSala();
            System.out.println("Assentos disponíveis nesta sala: " + sessao.getSala().assentoDisponivel());
        }
    }

    private static void reservarAssentoMenu() {
        Sessao sessao = selecionarSessao(); // Selecionar automaticamente a sessão solicitada
        if (sessao != null) {
            sessao.getSala().mostrarSala();
            System.out.print("Indique a Linha do assento: ");
            int linha = scanner.nextInt();
            System.out.print("Indique a Coluna do assento: ");
            int coluna = scanner.nextInt();
            sessao.getSala().reservarAssento(linha, coluna);
        }
    }

    private static void cancelarReservaMenu() {
        Sessao sessao = selecionarSessao();
        if (sessao != null) {
            sessao.getSala().mostrarSala();
            System.out.print("Indique a Linha do assento a cancelar: ");
            int linha = scanner.nextInt();
            System.out.print("Indique a Coluna do assento a cancelar: ");
            int coluna = scanner.nextInt();
            sessao.getSala().cancelarReserva(linha, coluna);
        }
    }
}