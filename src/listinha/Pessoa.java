package listinha;

public class Pessoa {

    private String nome;
    private Pessoa proximo;

    public Pessoa(){
        
    }
    
    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getProximo() {
        return proximo;
    }

    public void setProximo(Pessoa proximo) {
        this.proximo = proximo;
    }  

}
