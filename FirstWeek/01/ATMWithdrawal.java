public class ATMWithdrawal {
    int saldo = 1000;

    public void sacar(int valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque efetuado com sucesso: " + valor);
            System.out.println("Saldo atualizado: " + saldo);
        } else {
            System.out.println("Valor maior do que o saldo disponível.");
        }
    }
    
    public static void main(String[] args) {
        ATMWithdrawal exec = new ATMWithdrawal();
        
        exec.sacar(1000);
    }
}