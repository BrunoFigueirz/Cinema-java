//./Sessao.java

public class Sessao {
    
    // Atributos da Sessão
    private int idSessao;
    private Filme filme;
    private Sala sala;
    private String horario;

    // Construtor
    public Sessao(int idSessao, Filme filme, Sala sala, String horario) {
        this.idSessao = idSessao;
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
    }

    // Getters e Setters
    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    // Método para exibir as informações completas da sessão
    public void exibirInformacoesSessao() {
        System.out.println("=== Sessão ID: " + idSessao + " ===");
        System.out.println("Horário: " + horario);
        System.out.println(filme.toString()); // Chama o toString() criado no ficheiro Filme.java
        sala.mostrarSala(); // Mostra o mapa da sala desta sessão específica
    }
}