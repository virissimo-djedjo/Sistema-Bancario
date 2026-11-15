package src;
public class Conta {

    private int numero;
    private String tipo;
    private String titular;
    private double saldo;
    private double limite;

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public boolean setNumero(int numero) {
        if(numero <= 0){
            return false;
        }
        this.numero = numero;
        return true;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean setTipo(String tipo) {
        if(tipo == null || tipo.isBlank()){
            return false;
        }
        if(!tipo.equalsIgnoreCase("CC") && !tipo.equalsIgnoreCase("CP") && !tipo.equalsIgnoreCase("CI")){
            return false;
        }

        
        this.tipo = tipo.toUpperCase();
        return true;
    }

    public String getTitular() {
        return titular;
    }

    public boolean setTitular(String titular) {
        if(titular == null || titular.isBlank()){
            return false;
        }
        this.titular = titular;
        return true;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean setSaldo(double saldo) {
        if(saldo <= 0){
            return false;
        }
        this.saldo = saldo;
        return true;
    }

    public double getLimite() {
        return limite;
    }

    public boolean setLimite(double limite) {
        if(limite <= 0 || limite > 1000){
            return false;
        }
        this.limite = limite;
        return true;
    }

    public boolean depositar(double valor){
        if(valor <= 0){
            return false;
        }

        this.saldo += valor;
        return true;
    }

    public double sacar(double valor){
        if(valor <= 0){
            return 0;
        }
        if(this.saldo - valor >= -1000){
            this.saldo -= valor;
            return valor;
        }

        return 0;
    }

    public String toString(){
        return String.format("Número: %d, Tipo: %s, Titular: %s, Saldo: %.2f, Limite: %.2f ",this.numero, this.tipo, this.titular, this.saldo, this.limite);
    }

}