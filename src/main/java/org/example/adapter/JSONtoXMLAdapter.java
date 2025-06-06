package org.example.adapter;


import org.json.JSONException;
import org.example.backend.XMLprocessor;
import org.json.JSONObject;
import org.json.XML;

/**
 * Adapter que converte uma String JSON em XML e envia o XMLprocessor para processamento.
 *
 * Exemplo:
 *     JSONtoXMLAdapter adapter = new JSONtoXMLAdapter(new Backend());
 *     String meuJson =
 *     "{
 *     \"nome\":\"Maria\",
 *     \"idade\":21,
 *     \"ativo\":true
 *     }";
 *     adapter.processJSON(meuJson) -> converte para XML;
 */

public class JSONtoXMLAdapter {

    // Referência ao componente “legado” que só entende XML
    private final XMLprocessor xmlProcessor;

    /**
     * Construtor do Adapter.
     * @param xmlProcessor objeto legado que processa apenas XML
     */
    public JSONtoXMLAdapter(XMLprocessor xmlProcessor) {
        this.xmlProcessor = xmlProcessor;
    }

    /**
     * Recebe a String JSON de entrada, converte para XML e chama
     * xmlProcessor.processXML() para realizar a operação real (printar no console).
     *
     * @param jsonData String JSON que será convertida para XML
     */

    public void processJSON(String jsonData) {
        try {
            // Converte a String JSON para um JSONObject
            JSONObject jsonObject = new JSONObject(jsonData);

            // Converte JSONObject em XML (root element = "root")
            String xml = XML.toString(jsonObject, "root");

            // Delegar ao backend que processa XML
            xmlProcessor.processXML(xml);

        } catch (JSONException e) {
            // Em caso de JSON inválido
            System.err.println("[Adapter] Erro ao converter JSON para XML: " + e.getMessage());
        }
    }
}
