package com.dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProcessaBoletos {
    public static DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public List<Boleto> lerArquivo(String nomeArquivo){
        List<Boleto> lista = new ArrayList<>();
        if (nomeArquivo.contains("banco-brasil")){
            try {
                BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] vetor = linha.split(";");
                    Boleto boleto = new Boleto();
                    boleto.setId(Integer.parseInt(vetor[0]));
                    boleto.setCodBanco(vetor[1]);
                    boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                    boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));

                    boleto.setCpfCliente(vetor[4]);
                    boleto.setValor(Double.parseDouble(vetor[5]));
                    boleto.setMulta(Double.parseDouble(vetor[6]));
                    boleto.setJuros(Double.parseDouble(vetor[7]));
                    lista.add(boleto);
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        } else if (nomeArquivo.contains("bradesco")) {
            try {
                BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] vetor = linha.split(";");
                    Boleto boleto = new Boleto();
                    boleto.setId(Integer.parseInt(vetor[0]));
                    boleto.setCodBanco(vetor[1]);
                    boleto.setAgencia(vetor[2]);
                    boleto.setContaBancaria(vetor[3]);
                    boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                    boleto.setDataPagamento(LocalDate.parse(vetor[5], FORMATO_DATA_HORA).atTime(0, 0, 0));
                    boleto.setCpfCliente(vetor[6]);
                    boleto.setValor(Double.parseDouble(vetor[7]));
                    boleto.setMulta(Double.parseDouble(vetor[8]));
                    boleto.setJuros(Double.parseDouble(vetor[9]));
                    lista.add(boleto);
                }

            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        return lista;
    };

    public void processar(String nomeArquivo) {
        List<Boleto> boletos = lerArquivo(nomeArquivo);
        boletos.forEach(boleto -> System.out.println("ID: " + boleto.getId() + " | Banco: "
                + boleto.getCodBanco() + " | CPF Cliente: "
                + boleto.getCpfCliente()));
    }
}
