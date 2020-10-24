package com.dev;

import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class ProcessaBoletos {
    protected abstract List<Boleto> lerArquivo(String nomeArquivo);

    public static DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public void processar(String nomeArquivo) {
        List<Boleto> boletos = lerArquivo(nomeArquivo);
        boletos.forEach(boleto -> System.out.println("ID: " + boleto.getId() + " | Banco: "
                + boleto.getCodBanco() + " | CPF Cliente: "
                + boleto.getCpfCliente()));
    }
}
