package org.example;

import org.example.adapter.JSONtoXMLAdapter;
import org.example.backend.Backend;
import org.example.backend.XMLprocessor;

/**
 * Classe main para demonstrar como o adapter faz a ponte JSON -> XML -> Backend (XMLprocessor).
 */

public class Main {
    public static void main(String[] args) {
        // Instancia o backend que só entende XML
        XMLprocessor backend = new Backend();

        // Cria o Adapter, passando o backend
        JSONtoXMLAdapter adapter = new JSONtoXMLAdapter(backend);

        // Exemplo de JSON entrada (poderia vir de um controller, arquivo....)
        String exemploJson = """
            {
                "usuario": {
                    "id": 123,
                    "nome": "Mariana",
                    "email": "mari@emailteste.com",
                    "roles": ["admin", "user"],
                    "ativo": true
                },
                "detalhes": {
                    "cidade": "SP",
                    "idade": 21
                }
            }
            """;

        // Chama o Adapter para processar esse JSON
        adapter.processJSON(exemploJson);

        // Outro JSON de teste para ilustrar que funciona com outros formatos
        String outroJson = """
            {
                "produto": {
                    "id": "14",
                    "preco": 129.90,
                    "estoque": 50
                }
            }
            """;

        adapter.processJSON(outroJson);
    }
}