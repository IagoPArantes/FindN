package application;

public class Cidade {

    private String cidade;
    private String rua;
    private String bairro;
    private String estado;
    private Cep cep;

    public Cidade(String cidade, String estado, String rua, String bairro, Cep cep) {
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.estado = estado;
        this.cep= cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getRua() {
        return rua;
    }
    public String getBairro() {
        return bairro;
    }

    public Cep getCep() {
        return cep;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void seCIdade(String cidade) {
        this.cidade = cidade;
    }

    public void exibirCidade() {
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("Rua: " + rua);
        System.out.println("Bairro: " + bairro);
        System.out.println("Cep: " + cep.getCep());

    }

}
