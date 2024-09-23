class Saldo {
// Atributos Privados
    private double saldo;
    private int contadorConsultas;

    // Construtor
    public Saldo(double saldoInicial) {
        this.saldo = saldoInicial;
        this.contadorConsultas = 0;
    }

    // Método para realizar depósito (com a taxa de 1%)
    public void depositar(double valor) {
        if (valor > 0) {
            double taxa = valor * 0.01;
            saldo += (valor - taxa);
            System.out.printf("Depósito de R$%.2f realizado. Taxa de R$%.2f cobrada.%n", valor, taxa);
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    // Método para realizar saque (incluindo a taxa de 0,5%)
    public void sacar(double valor) {
        if (valor > 0) {
            double taxa = valor * 0.005;
            double totalSaque = valor + taxa;
            if (totalSaque <= saldo) {
                saldo -= totalSaque;
                System.out.printf("Saque de R$%.2f realizado. Taxa de R$%.2f cobrada.%n", valor, taxa);
            } else {
                System.out.println("Saldo insuficiente para realizar o saque.");
            }
        } else {
            System.out.println("Valor de saque inválido!");
        }
    }

    // Método para consultar saldo (taxa de R$0,10 a cada 5 consultas)
    public void consultarSaldo() {
        contadorConsultas++;
        if (contadorConsultas % 5 == 0) {
            saldo -= 0.10;
            System.out.println("Taxa de consulta de R$0.10 cobrada.");
        }
        System.out.printf("Saldo atual: R$%.2f%n", saldo);
    }

    // Método para obter o saldo
    public double getSaldo() {
        return saldo;
    }

    // Método para obter o número de consultas realizadas
    public int getContadorConsultas() {
        return contadorConsultas;
    }
}
public class Banco {
    public static void main(String[] args) {
        Saldo conta = new Saldo(100.0);  // Conta com saldo inicial de R$100

        //Analisando e consultando a conta
        conta.consultarSaldo(); 
        conta.depositar(50.0);  
        conta.consultarSaldo();  
        conta.sacar(20.0);       
        conta.consultarSaldo();  
        conta.consultarSaldo();  
        conta.consultarSaldo();  
    }
}

