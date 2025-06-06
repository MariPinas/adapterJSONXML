package org.example.backend;

/**
 * Interface que define o contrato para quem processa XML.
 * O backend só conhece essa interface e só lida com XML.
 */
public interface XMLprocessor {
    /**
     * @param xmlData conteúdo do XML a ser processado
     *
     * Recebe uma String contendo XML e executa uma operação de negócio.
     */

    void processXML(String xmlData);
}