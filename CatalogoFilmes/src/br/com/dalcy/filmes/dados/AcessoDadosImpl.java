package br.com.dalcy.filmes.dados;

import br.com.dalcy.filmes.domain.Filmes;
import br.com.dalcy.filmes.exceptions.AcessoDadosEx;
import br.com.dalcy.filmes.exceptions.EscreverDadosEx;
import br.com.dalcy.filmes.exceptions.LeituraDadosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dalcimar
 */
public class AcessoDadosImpl implements IAcessoDados {

    @Override
    public boolean existe(String nomeRecurso) {
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
            while (linha != null) {
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
        var arquivo = new File(nomeRecurso);
        try {
            var saida = new PrintWriter(new FileWriter(arquivo, anexar));
            saida.println(filmes.toString());
            saida.close();
            System.out.println("As informações foram gravadas no arquivo: " + filmes);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscreverDadosEx("Exceção ao listar filmes: " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nomeRecurso, String buscar) throws LeituraDadosEx {
        var arquivo = new File(nomeRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            linha = entrada.readLine();
            int indice = 1;
            while (linha != null) {
                if(buscar != null && buscar.equalsIgnoreCase(linha)) {
                    resultado = "Filme " + linha + " encontrado no índice " + indice;
                    break;
                }
                linha = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LeituraDadosEx("Exceção ao listar filmes: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LeituraDadosEx("Exceção ao listar filmes: " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void criar(String nomeRecurso) throws AcessoDadosEx {
        var arquivo = new File(nomeRecurso);
        try {
            var saida = new PrintWriter(new FileWriter(arquivo));
            saida.close();
            System.out.println("O arquivo foi criado");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AcessoDadosEx("Exceção ao criar arquivo: " + ex.getMessage());
        }
    }

    @Override
    public void excluir(String nomeRecurso) {
        var arquivo = new File(nomeRecurso);
        if(arquivo.exists()) 
            arquivo.delete();
        System.out.println("O arquivo foi deletado");
    }

}
