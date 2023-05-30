public class Renda {
    public double valor;
    public boolean resoluvel;

    public Renda(double valor, boolean resoluvel){
        this.valor = valor;
        this.resoluvel = resoluvel;
    }
    public double getValor() {
        return valor;
    }
    public boolean isResoluvel() {
        return resoluvel;
    }
}
