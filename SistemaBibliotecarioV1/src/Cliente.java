public abstract class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private Double MultaPendente;
    public Cliente(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.MultaPendente = 0.0;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public Double getMultaPendente() {
        return MultaPendente;
    }

    public void setMultaPendente(Double multaPendente) {
        MultaPendente = multaPendente;
    }
}
