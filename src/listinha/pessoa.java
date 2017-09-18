package listinha;

public class pessoa {

    private String nome;
    private pessoa proximo;

    pessoa(String artur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    pessoa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public pessoa getProximo() {
        return proximo;
    }

    public void setProximo(pessoa proximo) {
        this.proximo = proximo;
    }
}
