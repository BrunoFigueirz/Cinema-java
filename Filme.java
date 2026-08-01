//./Filme.java

public class Filme {
    
    // Atributos do filme
    private String titulo;
    private String genero;
    private int duracaoEmMinutos;
    private String classificacaoIndicativa;

    // Construtor
    public Filme(String titulo, String genero, int duracaoEmMinutos, String classificacaoIndicativa) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    // M\u00e9todo para exibir as informa\u00e7\u00f5es do filme formatadas
    @Override
    public String toString() {
        return "Filme: " + titulo + 
               " | G\u00eanero: " + genero + 
               " | Dura\u00e7\u00e3o: " + duracaoEmMinutos + " min" +
               " | Classifica\u00e7\u00e3o: " + classificacaoIndicativa;
    }
}