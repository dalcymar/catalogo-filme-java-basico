package br.com.dalcy.filmes.dados;

import br.com.dalcy.filmes.domain.Filmes;
import br.com.dalcy.filmes.exceptions.AcessoDadosEx;
import br.com.dalcy.filmes.exceptions.EscreverDadosEx;
import br.com.dalcy.filmes.exceptions.LeituraDadosEx;
import java.util.List;

/**
 *
 * @author Dalcimar
 */
public interface IAcessoDados {

    boolean existe(String nomeRecurso) throws AcessoDadosEx;
    
    List<Filmes> listar(String nomeRecurso) throws LeituraDadosEx;
    
    void escrever(Filmes filmes, String nomeRecurso, boolean anexar) throws EscreverDadosEx;
    
    String buscar(String nomeRecurso, String buscar) throws LeituraDadosEx;
    
    void criar(String nomeRecurso) throws AcessoDadosEx;
    
    void excluir(String nomeRecurso) throws AcessoDadosEx;
}
