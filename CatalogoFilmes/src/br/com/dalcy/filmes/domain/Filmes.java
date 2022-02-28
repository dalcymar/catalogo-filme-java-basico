package br.com.dalcy.filmes.domain;

/**
 *
 * @author Dalcimar
 */
public class Filmes {

    private String nome;

    public Filmes() {
    }

    public Filmes(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
        //return "Filmes{" + "nome=" + nome + '}';
    }
    
}
