package br.com.dalcy.filmes.apresentacao;

import br.com.dalcy.filmes.servicio.CatalogoFilmesImpl;
import br.com.dalcy.filmes.servicio.ICatalogoFilmes;
import java.util.Scanner;

/**
 *
 * @author Dalcimar
 */
public class ApresentacaoCatalogoFilmes {

    public static void main(String[] args) {
        var opcao = -1;
        var scan = new Scanner(System.in);
        ICatalogoFilmes catalogo = new CatalogoFilmesImpl();
        
        while(opcao != 0) {
            System.out.println("Escolha uma opção: \n"
                + "1. Iniciar catalogo de filmes\n"
                + "2. Agregar filmes\n"
                + "3. Listar Filmes\n"
                + "4. Buscar Filmes\n"
                + "0. Sair");
            opcao = Integer.parseInt(scan.nextLine());
            
            switch(opcao) {
                case 1:
                    catalogo.iniciarCatalogoFilmes();
                    break;
                case 2:
                    System.out.println("Digite o nome do filme");
                    var nomeFilme = scan.nextLine();
                    catalogo.agregarFilme(nomeFilme);
                    break;
                case 3:
                    catalogo.listarFilmes();
                    break;
                case 4:
                    System.out.println("Digite um filme para pesquisar");
                    var buscar = scan.nextLine();
                    catalogo.buscarFilme(buscar);
                    break;
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção não reconhecida");
                    break;
            }
        }
    }
}
