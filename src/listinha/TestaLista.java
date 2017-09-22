package listinha;

import java.util.Scanner;

public class TestaLista {

    static Pessoa inicio = null;
    static Pessoa fim = null;
    static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        
           Pessoa novo = new Pessoa ("Michel");
           inicio = novo;
           fim = inicio;
           inicio.setProximo(fim);
           fim.setProximo(null);
           
           novo = new Pessoa ("Jair");
           novo.setProximo(inicio);
           inicio = novo;
           
           novo = new Pessoa ("Joesley");
           fim.setProximo(novo);
           fim = novo;
           
           novo = new Pessoa ("Gedel");
           novo.setProximo(fim);
           
           Pessoa atual = inicio;
           while (atual != null){
               System.out.println("-" + atual.getNome());
               atual = atual.getProximo();
           }
            
    }

}
