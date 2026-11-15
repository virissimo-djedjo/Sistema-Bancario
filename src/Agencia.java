package src;
import java.util.ArrayList;

public class Agencia {

    private String nome;
    ArrayList<Conta> contas;

    public Agencia(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<Conta>();
    }

    public String getBanco() {
        return this.nome;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public boolean removerConta(int nrConta) {
        for (Conta conta : this.contas) {
            if (nrConta == conta.getNumero()) {
                contas.remove(conta);
                System.out.println("Contas com número " + conta.getNumero() + "foi removido!");
                return true;
            }
        }
        return false;
    }

    public ArrayList<Conta> getContas() {
        return this.contas;
    }

    public ArrayList<Conta> getContas(String tipo) {
        ArrayList<Conta> contasTipo = new ArrayList<Conta>();
        for (Conta conta : this.contas) {
            if (tipo.equals(conta.getTipo())) {
                contasTipo.add(conta);
            }
        }
        return contasTipo;
    }

    public ArrayList<Conta> getContas(double saldoMinimo, double saldoMaximo) {
        ArrayList<Conta> contasMinMax = new ArrayList<Conta>();

        for (Conta conta : this.contas) {
            if (conta.getSaldo() >= saldoMinimo && conta.getSaldo() <= saldoMaximo) {
                contasMinMax.add(conta);
            }
        }

        return contasMinMax;
    }

    public double transferencia(int nrContaOrigem, int nrContaDestino, double valor) {

        if(valor <= 0){
            return 0;
        }

        if (nrContaDestino == nrContaOrigem) {
            return 0;
        }

        Conta origem = null;
        Conta destino = null;

        for (Conta conta : this.contas) {
            if (conta.getNumero() == nrContaOrigem) {
                origem = conta;
            }

            if (conta.getNumero() == nrContaDestino) {
                destino = conta;
            }
        }

        if (origem == null || destino == null) {
            return 0;
        }

        double valorSacado = origem.sacar(valor);
        if (valorSacado == 0) {
            return 0;
        }

        boolean depositado = destino.depositar(valorSacado);

        if(!depositado){

            origem.depositar(valorSacado);
            return 0;
        }

        return valorSacado;
    }

    public Conta[][] getMatriz() {

        int cont = 0;
        int linhaCC = -1;
        int linhaCP = -1;
        int linhaCI = -1;

        for (Conta conta : this.contas) {
            if (conta.getTipo().equalsIgnoreCase("CC") && linhaCC == -1) {
                linhaCC = cont;
                cont++;
            } else if (conta.getTipo().equalsIgnoreCase("CP") && linhaCP == -1) {
                linhaCP = cont;
                cont++;
            } else if (conta.getTipo().equalsIgnoreCase("CI") && linhaCI == -1) {
                linhaCI = cont;
                cont++;
            }
        }
        Conta[][] matriz = new Conta[cont][10];

        int[] colunas = new int[cont];

        for (Conta conta : this.contas) {
            if (conta.getTipo().equalsIgnoreCase("CC") && colunas[linhaCC] < 10) {
                matriz[linhaCC][colunas[linhaCC]] = conta;
                colunas[linhaCC]++;
            } else if (conta.getTipo().equalsIgnoreCase("CP") && colunas[linhaCP] < 10) {
                matriz[linhaCP][colunas[linhaCP]] = conta;
                colunas[linhaCP]++;
            } else if (conta.getTipo().equalsIgnoreCase("CI") && colunas[linhaCI] < 10) {
                matriz[linhaCI][colunas[linhaCI]] = conta;
                colunas[linhaCI]++;
            }
        }
        return matriz;
    }
}