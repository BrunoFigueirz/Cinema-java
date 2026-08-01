//./Sessao.java

public class Sessao {
    
    // Atributos da Sess\u00e3o
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

    // M\u00e9todo para exibir as informa\u00e7\u00f5es completas da sess\u00e3o
    public void exibirInformacoesSessao() {
        System.out.println("=== Sess\u00e3o ID: " + idSessao + " ===");
        System.out.println("Hor\u00e1rio: " + horario);
        System.out.println(filme.toString()); // Chama o toString() criado no ficheiro Filme.java
        sala.mostrarSala(); // Mostra o mapa da sala desta sess\u00e3o espec\u00edfica
    }
}