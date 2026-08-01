//./PersistenciaDados.java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersistenciaDados {

    // Define o nome do arquivo onde os dados ser\u00e3o salvos
    private static final String ARQUIVO_RESERVAS = "reservas.txt";

    // M\u00e9todo para guardar os dados e n\u00e3o perd\u00ea-los ao fechar o programa
    public void salvarReservas(List<Sessao> sessoes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_RESERVAS))) {

            for (Sessao sessao : sessoes) {
                // ID da sess\u00e3o identifica o bloco de assentos que vem a seguir
                writer.write("SessaoID:" + sessao.getIdSessao() + "\n");

                // Percorre a Matriz 2D da Sala desta sess\u00e3o e grava a posi\u00e7\u00e3o
                // exata de cada assento ocupado ('X'), uma "linha,coluna" por vez.
                var sala = sessao.getSala();
                for (int i = 0; i < sala.getTotalLinhas(); i++) {
                    for (int j = 0; j < sala.getTotalColunas(); j++) {
                        if (sala.getAssento(i, j) == 'X') {
                            writer.write(i + "," + j + "\n");
                        }
                    }
                }
                writer.write("FIM_SESSAO\n");
            }
            System.out.println("Dados salvos com sucesso no arquivo!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar as reservas: " + e.getMessage());
        }
    }

    // M\u00e9todo para ler os dados salvos e remarcar os assentos nas sess\u00f5es atuais.
    // Requer que as sess\u00f5es (com os mesmos IDs) j\u00e1 tenham sido recriadas em
    // mem\u00f3ria antes de carregar, j\u00e1 que o arquivo s\u00f3 guarda o estado dos assentos.
    public void carregarReservas(List<Sessao> sessoes) {
        File arquivo = new File(ARQUIVO_RESERVAS);

        // Verifica se o arquivo j\u00e1 existe antes de tentar ler
        if (!arquivo.exists()) {
            System.out.println("Nenhum arquivo anterior encontrado. O sistema iniciar\u00e1 vazio.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            Sessao sessaoAtual = null;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("SessaoID:")) {
                    int id = Integer.parseInt(linha.substring("SessaoID:".length()).trim());
                    sessaoAtual = buscarSessaoPorId(sessoes, id);
                    if (sessaoAtual == null) {
                        System.out.println("Aviso: Sess\u00e3o " + id + " do arquivo n\u00e3o existe mais em mem\u00f3ria (ignorada).");
                    }
                } else if (linha.equals("FIM_SESSAO")) {
                    sessaoAtual = null;
                } else if (sessaoAtual != null && linha.contains(",")) {
                    String[] partes = linha.split(",");
                    int i = Integer.parseInt(partes[0].trim());
                    int j = Integer.parseInt(partes[1].trim());
                    sessaoAtual.getSala().definirAssentoDireto(i, j, 'X');
                }
            }
            System.out.println("Reservas carregadas com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao carregar as reservas: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro: arquivo de reservas corrompido ou em formato inesperado.");
        }
    }

    private Sessao buscarSessaoPorId(List<Sessao> sessoes, int id) {
        for (Sessao s : sessoes) {
            if (s.getIdSessao() == id) {
                return s;
            }
        }
        return null;
    }
}