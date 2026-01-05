package com.find.application;

public class Reservas {

    private String data_inicio;
    private String data_fim;

    public Reservas(String data_inicio, String data_fim) {
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public String exibirReservas() {
        System.out.println("Data de inicio da reserva: " + data_inicio);
        System.out.println("Data de fim da reserva: " + data_fim);
        System.out.println();
        return "Reservas realizada com sucesso!";
    }
}
