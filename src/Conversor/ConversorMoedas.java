package Conversor;

public record ConversorMoedas (String moedaOrigem, String moedaDestino,
                               double valor, double resultado) {
    @Override
    public String toString() {
        return String.format("%.2f %s = %.2f %s", valor, moedaOrigem, resultado, moedaDestino);
    }
}

