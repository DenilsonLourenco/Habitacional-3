public class Cliente {
    private int ID;
    private String nome;
    private Endereco endereco;
    private Contato contato;

    //Construtor
    public Cliente(int ID, String nome, Endereco endereco, Contato contato) {
        this.ID = ID;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }
}
