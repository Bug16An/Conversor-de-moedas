package Conversor;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends ConversorER {
    public static void main(String[] args) throws Exception, IOException {

        Scanner leitura = new Scanner(System.in);

        String[] moedas = {"BRL", "EUR", "INR", "AOA", "ZAR", "SYP"};


        int escolha = -1;

        while (true) {
            try {
                System.out.println("""
                          Escolha a moeda de origem que deseja converter
                          1 - BRL
                          2 - EUR
                          3 - INR
                          4 - AOA
                          5 - ZAR
                          6 - SYP
                        """);
                System.out.println("Sua escolha(Escolha 0 para sair): ");
                escolha = leitura.nextInt();
                if (escolha == 0) break;
                if (escolha < 1 || escolha > moedas.length) {
                    System.out.println("Escolha inválida. Tente novamente.");
                    continue;
                }
                String moedaOrigem = moedas[escolha - 1];
                System.out.println(moedas[escolha - 1]);


                System.out.println("""
                          Escolha a moeda destino da conversão
                          1 - BRL
                          2 - EUR
                          3 - INR
                          4 - AOA
                          5 - ZAR
                          6 - SYP
                        """);
                System.out.println("Sua escolha: ");
                escolha = leitura.nextInt();
                if (escolha < 1 || escolha > moedas.length) {
                    System.out.println("Escolha inválida. Tente novamente.");
                    continue;
                }
                String moedaDestino = moedas[escolha - 1];
                System.out.println(moedas[escolha - 1]);

                System.out.println("Digite o valor que deseja converter: ");
                double valorOrigem = leitura.nextDouble();
                leitura.nextLine();

                ConversorER conversor = new ConversorER();
                ConversorMoedas resultado = conversor.convert(moedaOrigem, moedaDestino, valorOrigem);
                if (resultado != null) {
                    System.out.println("Valor convertido: " + resultado);
                } else {
                    System.out.println("Conversão falhou.");
                }

                System.out.println("Digite 0 para sair ou qualquer outro número para continuar: ");
                escolha = leitura.nextInt();
                if (escolha == 0) break;
                leitura.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida por favor insira ao numero novamente (Ex: 50,5)");
                leitura.nextLine();
            }
        }
        leitura.close();
    }
}