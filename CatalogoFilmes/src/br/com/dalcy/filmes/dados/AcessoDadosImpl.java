package br.com.dalcy.filmes.dados;

import br.com.dalcy.filmes.domain.Filmes;
import br.com.dalcy.filmes.exceptions.AcessoDadosEx;
import br.com.dalcy.filmes.exceptions.EscreverDadosEx;
import br.com.dalcy.filmes.exceptions.LeituraDadosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dalcimar
 */
public class AcessoDadosImpl implements IAcessoDados {

    @Override
    public boolean existe(String nomeRecurso) throws AcessoDadosEx {
        File arquivo = new File(nomeRecurso);
        return arquivo.exists();
    }

    @Override
    public List<Filmes> listar(String nomeRecurso) throws LeituraDadosEx {
        var arquivo = new File(nomeRecurso);
        List<Filmes> filmes = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            linha = entrada.readLine();
            while(linha != null) {
                var filme = new Filmes(linha);
                filmes.add(filme);
                linha = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LeituraDadosEx("Exceção ao listar filmes: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LeituraDadosEx("Exceção ao listar filmes: " + ex.getMessage());
        }
        return filmes;
    }

    @Override
    public void escrever(Filmes filmes, String nomeRecurso, boolean anexar) throws EscreverDadosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String buscar(String nomeRecurso, String buscar) throws LeituraDadosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criar(String nomeRecurso) throws AcessoDadosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(String nomeRecurso) throws AcessoDadosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
