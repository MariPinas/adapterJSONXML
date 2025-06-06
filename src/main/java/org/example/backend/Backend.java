package org.example.backend;

/**
 * Implementação concreta do XML processor. Simula um backend que só
 * entende XML. Aqui imprimimos no console, mas pode haver outras chamadas de serviços.
 */
public class Backend implements XMLprocessor {

    @Override
    public void processXML(String xmlData) {
        // Simulação de processamento:
        System.out.println("[Backend] Recebeu XML para processar:");
        System.out.println(xmlData);
        System.out.println("[Backend] Processamento concluído.\n");
    }
}