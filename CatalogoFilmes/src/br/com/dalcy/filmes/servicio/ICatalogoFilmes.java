package br.com.dalcy.filmes.servicio;

/**
 *
 * @author Dalcimar
 */
public interface ICatalogoFilmes {
    
    String NOME_RECURSOS = "filmes.txt";
    
    void agregarFilme(String nomeFilme);
    
    void listarFilmes();
    
    void buscarFilme(String buscar);
    
    void iniciarCatalogoFilmes();
    
    //Posso adicionar mais método para testes futuros
}
