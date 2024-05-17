package Conversor;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

Scanner leitura = new Scanner(System.in);
        boolean escolha = true;


        while (escolha == true) {
            System.out.println("""
                      Escolha a moeda de origem que deseja converter
                      1 - BRL (Brazilian Real)
                      2 - EUR (Euro)
                      3 - INR (Indian Rupee)
                      4 - AOA (Angolan Kwanza)
                      5 - ZAR (South African Rand)
                      6 - SYP (Syrian Pound)
                                    
                    """);
            System.out.println("Sua escolha: ");
            String moedaOrigem = leitura.nextLine();

            System.out.println("""
                      Escolha a moeda destino da conversão
                      1 - BRL (Brazilian Real)
                      2 - EUR (Euro)
                      3 - INR (Indian Rupee)
                      4 - AOA (Angolan Kwanza)
                      5 - ZAR (South African Rand)
                      6 - SYP (Syrian Pound)
                    """);
            System.out.println("Sua escolha: ");
            String moedaDestino = leitura.nextLine();

            System.out.println("Digite o valor que deseja converter: ");
            double valorOrigem = leitura.nextDouble();

            ConversorER converter = new ConversorER();
            ConversorMoedas conversion = converter.convert(moedaOrigem, moedaDestino, valorOrigem);
            System.out.println(conversion);


        }


    }
}

