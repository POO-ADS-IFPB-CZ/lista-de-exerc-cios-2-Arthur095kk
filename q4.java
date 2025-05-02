4.
import java.util.Scanner;

public class ContaCorrente {
    private int numero;
    private String titular;
    private float saldo;

    public ContaCorrente(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public void sacar(float valor) {
        if (valor > 10000) {
            System.out.println("Não é permitido sacar mais de 10000 por operação.");
        } else if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(float valor) {
        if (valor > 0 && valor <= 10000) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public float consultarSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número da conta: ");
        int numero = sc.nextInt();
        sc.nextLine(); // Limpar o buffer do teclado

        System.out.print("Digite o nome do titular: ");
        String titular = sc.nextLine();

        ContaCorrente conta = new ContaCorrente(numero, titular);

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Sacar um valor");
            System.out.println("2. Depositar um valor");
            System.out.println("3. Consultar o saldo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para sacar: ");
                    float saque = sc.nextFloat();
                    conta.sacar(saque);
                    break;

                case 2:
                    System.out.print("Digite o valor para depositar: ");
                    float deposito = sc.nextFloat();
                    conta.depositar(deposito);
                    break;

                case 3:
                    System.out.printf("Saldo atual: R$ %.2f\n", conta.consultarSaldo());
                    break;

                case 4:
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);

        sc.close();
    }
}
