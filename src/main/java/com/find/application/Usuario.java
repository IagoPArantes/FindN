package com.find.application;

public class Usuario {

    private int id;  // ADICIONADO - necessário para o banco
    private String nome;
    private String email;
    private String senha;
    private Telefone telefone;
    private Cidade cidade;
    private Cep cep;
    private Local local;
    private Reservas reservas;

    // Construtor vazio (necessário para o DAO)
    public Usuario() {
    }

    // Construtor com os 3 parâmetros básicos (o que você estava tentando usar)
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Construtor completo (opcional)
    public Usuario(String nome, String email, String senha, Telefone telefone,
                   Cidade cidade, Cep cep, Local local, Reservas reservas) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cidade = cidade;
        this.cep = cep;
        this.local = local;
        this.reservas = reservas;
    }

    // ADICIONAR getter e setter do id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Reservas getReservas() {
        return reservas;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }

    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Senha: " + senha);

        // Telefone
        if (telefone != null) {
            System.out.println("Telefone: " + telefone.getTelefone());
        } else {
            System.out.println("Telefone: não informado");
        }

        // Cidade
        if (cidade != null) {
            System.out.println("Cidade: " + cidade.getCidade());
            System.out.println("Rua: " + cidade.getRua());
            System.out.println("Bairro: " + cidade.getBairro());
        } else {
            System.out.println("Cidade: não informada");
        }

        // CEP
        if (cep != null) {
            System.out.println("CEP: " + cep.getCep());
        } else {
            System.out.println("CEP: não informado");
        }

        // Local e Reservas
        if (local != null && reservas != null) {
            System.out.println(local.getNome() + " reservado para: " + nome);
            System.out.println("Data de início: " + reservas.getData_inicio());
            System.out.println("Data de fim: " + reservas.getData_fim());
        } else {
            System.out.println("Nenhuma reserva cadastrada.");
        }

        System.out.println();
    }
}