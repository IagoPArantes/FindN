package com.find.application;

public class Local  {

    private String nome;
    private String descricao_local;
    private float valor_diaria;
    private Cidade cidade;
    private Telefone telefone;
    private Cep cep;
    private Reservas reservas;
    private Usuario usuario;
    private int id_local;

    public Local() {

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao_local() {
        return descricao_local;
    }

    public void setDescricao_local(String descricao_local) {
        this.descricao_local = descricao_local;
    }

    public float getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(float valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Reservas getReservas() {
        return reservas;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {

    }

    public int getId_local() {
        return id_local;
    }
    public void setId_local(int id_local) {
        this.id_local = id_local;
    }


    public void exibirLocal() {
        System.out.println("Nome do Local: " + nome);
        System.out.println("Descrição do Local: " + descricao_local);
        System.out.println("Valor diária do Local: R$ " + valor_diaria);

        if (telefone != null) {
            System.out.println("Telefone: " + telefone.getTelefone());
        } else {
            System.out.println("Telefone: null");
        }

        System.out.println("Cidade: " + cidade.getCidade());
        System.out.println("Rua: " + cidade.getRua());
        System.out.println("Bairro: " + cidade.getBairro());
        System.out.println("Cep: " + cep.getCep());

    }


}
