package main;

import java.util.HashMap;
import java.util.Map;

public class Balanca {
    private final Map<String, Map<String, Double>> fatores = new HashMap<>();

    public void adicionarTaxaDeConversao(
            String unidadeEntrada, String unidadeSaida, double fator) {
        fatores.computeIfAbsent(unidadeEntrada, unidade -> new HashMap<>())
                .put(unidadeSaida, fator);
    }

    public Peso converter(Peso peso, String unidadeResultado){
        Double fator = fatores
                .getOrDefault(peso.unidade, Map.of())
                .get(unidadeResultado);

        if (fator == null) {
            throw new IllegalArgumentException(
                    "Conversão não cadastrada: " + peso.unidade + " para " + unidadeResultado);
        }

        return new Peso(peso.quantidade*fator, unidadeResultado);
    };
}