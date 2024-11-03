package TreeApi.TreeApi.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Analyzer {

    private String words;
    private Long id;
    private Integer depth;
    private String result;

    // Função para transformar o texto em uma lista de palavras
    public List<String> transformarTextoParaLista(String texto) {
        // Remover pontuação e caracteres especiais
        String textoLimpo = texto.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

        // Dividir o texto em palavras com base nos espaços
        String[] palavrasArray = textoLimpo.split("\\s+");

        // Converter o array em uma lista
        List<String> palavrasLista = new ArrayList<>();
        for (String palavra : palavrasArray) {
            if (!palavra.isEmpty()) {
                palavrasLista.add(palavra);
            }
        }
        return palavrasLista;
    }

}
