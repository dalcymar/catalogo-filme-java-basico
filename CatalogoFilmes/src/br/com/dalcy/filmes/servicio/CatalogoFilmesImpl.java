package br.com.dalcy.filmes.servicio;

import br.com.dalcy.filmes.dados.AcessoDadosImpl;
import br.com.dalcy.filmes.dados.IAcessoDados;
import br.com.dalcy.filmes.domain.Filmes;
import br.com.dalcy.filmes.exceptions.AcessoDadosEx;

/**
 *
 * @author Dalcimar
 */
public class CatalogoFilmesImpl implements ICatalogoFilmes {

    private final IAcessoDados dados;

    public CatalogoFilmesImpl() {
        this.dados = new AcessoDadosImpl();
    }
    
    @Override
    public void agregarFilme(String nomeFilme) {
        Filmes filme = new Filmes(nomeFilme);
        boolean anexar = false;
        try {
            anexar = dados.existe(NOME_RECURSOS);
            dados.escrever(filme, NOME_RECURSOS, anexar);
        } catch (AcessoDadosEx ex) {
            System.out.println("Erro de acesso a dados");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarFilmes() {
        try {
            var filmes = this.dados.listar(NOME_RECURSOS);
            for(var filme: filmes) {
                System.out.println("filme : " + filme);
            }
        } catch (AcessoDadosEx ex) {
            System.out.println("Erro de acesso a dados");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarFilme(String buscar) {
        String resultado = null;
        try {
            resultado = this.dados.buscar(NOME_RECURSOS, buscar);
        } catch (AcessoDadosEx ex) {
            System.out.println("Erro de acesso a dados");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado: " + resultado);
    }

    @Override
    public void iniciarCatalogoFilmes() {
        try {
            if(this.dados.existe(NOME_RECURSOS)) {
                dados.excluir(NOME_RECURSOS);
                dados.criar(NOME_RECURSOS);
            } else {
                dados.criar(NOME_RECURSOS);
            }
        } catch (AcessoDadosEx ex) {
            System.out.println("Error ao iniciar catalogo de filmes");
            ex.printStackTrace(System.out);
        }
        
    }

}
