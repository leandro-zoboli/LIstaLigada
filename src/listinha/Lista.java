package listinha;

import java.util.Scanner;

public class Lista {

    static Pessoa inicio = null;
    static Pessoa fim = null;
    static int qtd = 0;

    static Scanner tec = new Scanner(System.in);

    public static Pessoa criaPessoa() {
        //pede o nome da pessoa.
        Pessoa p = new Pessoa();
        p.setNome(pedeString("Informe o nome da pessoa (de 1 a 100 carcteres)", 1, 100));
        return p;
    }

    public static void criaLista() {
        //vai pedir o nome de uma pessoa e o coloca na lista como inicio e fim.
        Pessoa p = new Pessoa();
        inicio = criaPessoa();
        fim = inicio;
        inicio.setProximo(fim);
        fim.setProximo(null);
        qtd = qtd + 1;

    }

    public static void insereInicio() {
        //verifica se existe uma lista (se não irá ser criada uma nova lista).
        if (qtd == 0) {
            System.out.println("Lista nula! Criando nova lista.");
            criaLista();
        } else {
            //pede o nome de uma pessoa e a coloca no inicio.
            Pessoa p = criaPessoa();
            p.setProximo(inicio);
            inicio = p;

        }

    }

    public static void insereFim() {
        //verifica se existe uma lista (se não irá ser criada uma nova lista).
        if (qtd == 0) {
            System.out.println("lista nula! Criando nova lista.");
            criaLista();
        } else {
            //pede o nome da pessoa e a coloca no final da lista.
            Pessoa p = criaPessoa();
            fim.setProximo(p);
            fim = p;
        }

    }

    public static void listaLista() {
        //verifica se existe uma lista (se não, irá informar uma mensagem de aviso).
        if (qtd == 0) {
            System.out.println("lista nula!");
        } else {
            //irá percorrer a lista até o atual ser nulo (o fim da lista);
            //mostrando o nome de cada objeto percorrido e após isso; 
            //atribuirá ao atual o proximo.
            Pessoa atual = inicio;
            while (atual != null) {
                System.out.println("-" + atual.getNome());
                atual = atual.getProximo();
            }
        }
    }

    public static void verificaExiste() {
        //verifica se existe uma lista (se não irá ser criada uma nova lista).
        if (qtd == 0) {
            System.out.println("Lista nula! Criando nova lista");
            criaLista();
        }
        //irá pedir o nome da pessoa a ser pesquisada na lista.
        boolean existe = false;
        Pessoa atual;
        String nome = pedeString("Informe o nome da pessoa", 1, 100);
        atual = inicio;
        //percorre toda lista para tentar achar algum objeto com o mesmo nome; 
        //que o informado pelo usuário.
        while (atual != null) {
            if (atual.getNome().equals(nome)) {
                existe = true;
                break;

            }
            atual = atual.getProximo();
        }
        //if's para verificação se foi ou nçao encontrado o nome na lista.
        if (existe) {
            System.out.println("Nome ENCONTRADO na lista!");
        } else {
            System.out.println("Nome NÃO ENCONTRADO na lista");
        }
    }

    public static void removeEspecifico() {
        //verifica se existe uma lista (se não irá ser criada uma nova lista).
        if (qtd == 0) {
            System.out.println("Lista nula! Criando nova lista");
            criaLista();
        }
        //pede o nome a ser excluido da lista
        Pessoa atual;
        String nome = (pedeString("Informe o nome a ser excluído", 1, 100));
        //se o nome for o inicio da lista, executa o metodo removeInicio().
        if (nome.equals(inicio.getNome())) {
            removeInicio();
            //se o nome for o final da lista, executa o método removeFim().    
        } else if (nome.equals(fim.getNome())) {
            removeFim();
        } else {
            //se nenhum dos casos acima é aplicado, irá percorrer a lista até;
            //achar o nome a ser excluído
            atual = inicio;
            while (atual != null) {
                if (atual.getNome().equals(nome)) {
                    Pessoa anterior = buscaPessoaAnterior(atual);
                    anterior.setProximo(atual.getProximo());
                    System.out.println("'" + nome + "'" + " foi removido com succeso");
                    break;
                }
                atual = atual.getProximo();
            }
        }
    }

    public static void removeInicio() {
        //verifica se existe uma lista (se não irá ser criada uma nova lista).
        if (qtd == 0) {
            System.out.println("Lista nula!");
        } else {
            //retira o inicio da lista.
            System.out.println("'" + inicio.getNome() + "'" + " foi removido com succeso");

            inicio = inicio.getProximo();

        }
    }

    public static void removeFim() {
        //verifica se existe uma lista (se não irá ser criada uma nova lista).
        if (qtd == 0) {
            System.out.println("Lista nula!");
        } else {
            //se tiver somente um objeto na lista, o exclui do inicio e do final.
            if (inicio == fim) {
                System.out.println("'" + inicio.getNome() + "'" + " foi removido com succeso");

                inicio = null;
                fim = null;
            } else {
                //se a lista tiver mais objetos, irá ser achado o final;
                //para posteriormente ser feita a exclusão.
                Pessoa atual = inicio;
                while (atual != null) {
                    if (atual.getProximo().getProximo() == null) {
                        atual.setProximo(null);
                        System.out.println("'" + fim.getNome() + "'" + " foi removido com succeso");
1
        
                        fim = atual;
                        break;
                    }
                    atual = atual.getProximo();
                }
            }
        }
    }

    public static Pessoa buscaPessoaAnterior(Pessoa p) {
        //retorna a pessoa anterior da atual;
        Pessoa ret = null;
        Pessoa atual = inicio;
        while (atual != null) {
            if (atual.getProximo() == p) {
                ret = atual;
                break;
            }
            atual = atual.getProximo();
        }
        return ret;
    }

    public static void listaInicioAteFim() {
        //verifica se existe uma lista (se não irá será informada uma mensagem de aviso).
        if (qtd == 0) {
            System.out.println("Lista nula!");
        } else {
            //mostra a lista do inicio até o final (método convencional).
            Pessoa atual = inicio;
            while (atual != null) {
                System.out.println("-" + atual.getNome());
                atual = atual.getProximo();
            }
        }
    }

    public static void listaFimAteInicio() {
        //verifica se existe uma lista (se não irá será informada uma mensagem de aviso).
        if (qtd == 0) {
            System.out.println("Lista nula!");
        } else {
            //atribui a pessoa atual o final da lista e vai buscando a sua anterior.
            Pessoa atual = fim;
            while (atual != null) {
                System.out.println("-" + atual.getNome());
                if (atual != inicio) {
                    atual = buscaPessoaAnterior(atual);
                } else {
                    atual = null;
                }
            }
        }

    }

    public static void menu() {
        //menu usado no sistema.
        System.out.println("---------------------------------------------");
        System.out.println("1- Criar lista");
        System.out.println("2- Inserir pessoa no início lista");
        System.out.println("3- Inserir pessoa no final da lista");
        System.out.println("4- Mostrar lista");
        System.out.println("5- Verificar existência de pessoa específica");
        System.out.println("6- Remover pessoa específica");
        System.out.println("7- Remover a primeira pessoa da lista");
        System.out.println("8- Remover a ultima pessoa da lista");
        System.out.println("9- Mostrar lista do início até o fim");
        System.out.println("10- Mostrar lista do fim até o início");
        System.out.println("0- Sair");
        System.out.println("---------------------------------------------");
    }

    public static int pedeInt(String msg, int min, int max) {
        //método para retornar um inteiro informado pelo usuário (opções do menu).
        int ret = min - 1;
        boolean erro;
        do {
            erro = false;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(msg);
                ret = scan.nextInt();
                if (ret < min || ret > max) {
                    System.out.println("Informe um valor de " + min + " a " + max);
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (ret < min || ret > max || erro);
        return ret;
    }

    public static String pedeString(String msg, int min, int max) {
        //método para retornar uma String informada pelo usuário (nome das pessoas).
        String ret = "";
        boolean erro;
        do {
            erro = false;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(msg);
                ret = scan.next();
                if (ret.length() < min || ret.length() > max) {
                    System.out.println("Informe um nome de " + min + " a " + max + " caracteres");
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (ret.length() < min || ret.length() > max || erro);
        return ret;
    }

    public static void main(String[] args) {
        int resposta = 0;
        do {
            menu();
            resposta = pedeInt("Informe a opção desejada:", 0, 11);
            switch (resposta) {
                case 1:
                    criaLista();
                    break;
                case 2:
                    insereInicio();
                    break;
                case 3:
                    insereFim();
                    break;
                case 4:
                    listaLista();
                    break;
                case 5:
                    verificaExiste();
                    break;
                case 6:
                    removeEspecifico();
                    break;
                case 7:
                    removeInicio();
                    break;
                case 8:
                    removeFim();
                    break;
                case 9:
                    listaInicioAteFim();
                    break;
                case 10:
                    listaFimAteInicio();
                    break;
            }
        } while (resposta != 0);
    }
}
