package listinha;

import java.util.Scanner;

public class lista {

    static pessoa inicio = null;
    static pessoa fim = null;
    static int qtd = 0;

    static Scanner tec = new Scanner(System.in);

    public static pessoa criaPessoa() {
        pessoa p = new pessoa();
        System.out.println("informe o nome da pessoa:");
        p.setNome(tec.nextLine());
        return p;
    }

    public static void criaLista() {
        pessoa p = new pessoa();
        inicio = criaPessoa();
        fim = inicio;
        inicio.setProximo(fim);
        fim.setProximo(null);
        qtd = qtd+1;
    }

    public static void insereInicio() {
        if (qtd == 0) {
            System.out.println("Lista nula! Criando nova lista.");
            criaLista();
        }else {
            pessoa p = criaPessoa();
            p.setProximo(inicio);
            inicio = p;
        }
       

    }
    
    public static void insereFim(){
        if (qtd == 0) {
            System.out.println("lista nula! Criando nova lista.");
            criaLista();
        } else {
            pessoa p = criaPessoa();
            fim.setProximo(p);
            fim = p;
        }
    }
   
    public static void listaLista(){
        if (qtd == 0){
            System.out.println("lista nula!");
        } else {
            pessoa p = inicio;
            do {
                System.out.println();
            } while (p != null);
            System.out.println("-" + p.getNome());
            p.getProximo();
        }
    }
        
    
    
    public static void main(String[] args) {
        int resposta = 0;
        do {
        System.out.println("1- criar lista;");
        System.out.println("2- inserir pessoa no inicio da lista;");
        System.out.println("3- inserir pessoa no fim da lista;");
        System.out.println("4- listar pessoas da lista.");
        resposta = tec.nextInt();
        switch (resposta){
            case 1:
                criaLista();
            case 2:
                insereInicio();
            case 3:
                insereFim();
            case 4:
                listaLista();
        } 
        } while (resposta != 0);
    }
}

