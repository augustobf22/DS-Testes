package main;

import java.util.Objects;

public class Peso {
    protected double quantidade;
    protected String unidade;

    public Peso(double quantidade, String unidade){
        this.quantidade = quantidade;
        this.unidade = unidade;
    }
    public Peso multiplicar(int n){
        return new Peso(quantidade*n, unidade);
    }
    public String getUnidade(){
        return unidade;
    }
    public Peso somar(Peso outroPeso, String unidadeResultado){
        if(this.unidade.equals(outroPeso.unidade)){
            return new Peso(this.quantidade + outroPeso.quantidade, unidadeResultado);
        } else {
            throw new IllegalArgumentException(
                    "Unidades diferentes, converta os valores!");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Peso peso = (Peso) o;
        return quantidade == peso.quantidade && Objects.equals(unidade, peso.unidade);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quantidade);
    }
}
