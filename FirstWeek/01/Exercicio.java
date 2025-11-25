public class Exercicio {
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
        Exercicio exec = new Exercicio();
        
        exec.sacar(1000);
    }
}