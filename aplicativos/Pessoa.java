package aplicativos;

import java.util.InputMismatchException;

public class Pessoa {

    private String nome;
    private String cpf;
    

    // CONSTRUTOR
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        setCpf(cpf);
    }

    // METODO
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!cpf.matches( "\\d{11}")){
            throw new InputMismatchException("O CPF precisa conter 11 digitos.");
        }
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "[Nome: " + nome + " CPF: " + cpf + "]";
    }

}
