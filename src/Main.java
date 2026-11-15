package src;
public class Main {
    public static void main(String[] args) {
        Conta conta1 = new Conta(111);
        Conta conta2 = new Conta(112);
        Agencia agencia = new Agencia("Bandim");

        conta1.setLimite(1000);
        conta1.setSaldo(500);
        conta1.setTipo("CC");
        conta1.setTitular("Virissimo");

        conta2.setLimite(1000);
        conta2.setSaldo(750);
        conta2.setTipo("CP");
        conta2.setTitular("Miguel");

        agencia.addConta(conta1);
        agencia.addConta(conta2);

        System.out.println("Antes da transferência: \n" + "----------------");

        System.out.println("Virissimo: " + conta1.getSaldo());
        System.out.println("Miguel: " + conta2.getSaldo());

        agencia.transferencia(111, 112, 200);
        
        System.out.println("--------------------");

        System.out.println("Depois  da transferência:\n" + "----------------");
        
        System.out.println("Virissimo: " + conta1.getSaldo());
        System.out.println("Miguel: " + conta2.getSaldo());

        System.out.println("--------------------");
        
        Conta[][] matriz = agencia.getMatriz();

        for(int i = 0; i < matriz.length; i++){
            System.out.print("Linha " + i + ": ");

            for(int j = 0; j < matriz[i].length; j++){

                if(matriz[i][j] != null){
                    System.out.print(matriz[i][j].getNumero() + " ");
                }else{
                    System.out.print("null ");
                }
            }
            System.out.println();
        }


    }
}
