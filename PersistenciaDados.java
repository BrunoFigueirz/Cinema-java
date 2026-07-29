//./PersistenciaDados.java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersistenciaDados {

    // Define o nome do arquivo onde os dados serão salvos
    private static final String ARQUIVO_RESERVAS = "reservas.txt";

    // Método para guardar os dados e não perdê-los ao fechar o programa
    public void salvarReservas(List<Sessao> sessoes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_RESERVAS))) {
            
            for (Sessao sessao : sessoes) {
                // Aqui você pode formatar os dados que deseja salvar
                // Exemplo: ID da Sessão e a situação dos assentos
                writer.write("SessaoID:" + sessao.getIdSessao() + "\n");
                
                // Lógica complementar: você iteraria sobre a Matriz 2D da Sala 
                // desta sessão para salvar a posição exata de cada 'X' (ocupado).
            }
            System.out.println("Dados salvos com sucesso no arquivo!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar as reservas: " + e.getMessage());
        }
    }

    // Método para ler os dados salvos ao iniciar o sistema
    public void carregarReservas() {
        File arquivo = new File(ARQUIVO_RESERVAS);
        
        // Verifica se o arquivo já existe antes de tentar ler
        if (!arquivo.exists()) {
            System.out.println("Nenhum arquivo anterior encontrado. O sistema iniciará vazio.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            
            while ((linha = reader.readLine()) != null) {
                // Lógica complementar: Ler cada linha, identificar o ID da Sessão 
                // e remarcar os assentos como 'X' na Matriz 2D da respectiva Sala.
                System.out.println("Carregando dado: " + linha);
            }
            System.out.println("Reservas carregadas com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao carregar as reservas: " + e.getMessage());
        }
    }
}