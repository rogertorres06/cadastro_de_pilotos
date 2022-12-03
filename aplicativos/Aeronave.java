package aplicativos;

public class Aeronave {

    private String planoDeVoo;
    private int numeroDeSerie;
    private Pessoa pessoa;


    //CONSTRUTOR
    public Aeronave(String planoDeVoo, int numeroDeSerie, Pessoa pessoa) {

        this.planoDeVoo = planoDeVoo;
        this.numeroDeSerie = numeroDeSerie;
        this.pessoa = pessoa;
    }

    //METODOS
    public String getPlanoDeVoo() {
        return planoDeVoo;
    }

    public void setPlanoDeVoo(String planoDeVoo) {
        this.planoDeVoo = planoDeVoo;
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(int numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
