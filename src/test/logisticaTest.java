package test;

import main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogisticaTest {
    @Test
    void given5kg_WhenMultiplicadoPor2_ThenRetorna10kg() {
        Peso cinco = new Peso(5, "kg");
        assertEquals(new Peso(10, "kg"), cinco.multiplicar(2));
    }

    @Test
    void given5kg_WhenEqualsComOutros5kg_ThenRetornaVerdadeiro() {
        assertTrue(new Peso(5, "kg").equals(new Peso(5, "kg")));
    }

    @Test
    void given5kg_WhenEqualsCom6kg_ThenRetornaFalso() {
        assertFalse(new Peso(5, "kg").equals(new Peso(6, "kg")));
    }

    @Test
    void given5g_WhenMultiplicadoPor2_ThenRetorna10g(){
        Peso cinco = new Peso(5, "g");
        assertEquals(new Peso(10, "g"), cinco.multiplicar(2));
    }

    @Test
    void given5g_WhenEqualsComOutros5g_ThenRetornaVerdadeiro() {
        assertTrue(new Peso(5, "g").equals(new Peso(5, "g")));
    }

    @Test
    void given5g_WhenEqualsCom6g_ThenRetornaFalso() {
        assertFalse(new Peso(5, "g").equals(new Peso(6, "g")));
    }

    @Test
    void unit_Consistency(){
        Peso quilo = new Peso(5, "kg");
        Peso grama = new Peso(5, "g");

        assertEquals("kg", quilo.getUnidade());
        assertEquals("g", grama.getUnidade());
    }

    @Test
    void sameQuantidade_WhenDifferentUnits_ThenReturnFalso(){
        Peso quilo = new Peso(5, "kg");
        Peso grama = new Peso(5, "g");

        assertNotEquals(quilo, grama);
    }

    @Test
    void given1kg_WhenSoma1kg_ThenRetorna2kg() {
        Peso umQuilo = new Peso(1,"kg");
        Peso outroQuilo = new Peso(1,"kg");

        Peso total = umQuilo.somar(outroQuilo, "kg");

        assertEquals(new Peso(2,"kg"), total);
    }

    @Test
    void given1g_WhenSoma1g_ThenRetorna2g() {
        Peso umGrama = new Peso(1,"g");
        Peso outroGrama = new Peso(1,"g");

        Peso total = umGrama.somar(outroGrama, "g");

        assertEquals(new Peso(2,"g"), total);
    }

    @Test
    void given1kg_WhenSoma500g_ThenRetorna1500g() {
        Peso umQuilo = new Peso(1,"kg");
        Peso quinhentosGramas = new Peso(500,"g");

        Balanca balanca = new Balanca();
        balanca.adicionarTaxaDeConversao("kg", "g", 1000);
        balanca.adicionarTaxaDeConversao("kg", "kg", 1);
        balanca.adicionarTaxaDeConversao("g", "g", 1);

        Peso umQuiloConvertido = balanca.converter(umQuilo, "g");
        Peso quinhentosGramasConvertido = balanca.converter(quinhentosGramas, "g");
        Peso total = umQuiloConvertido.somar(quinhentosGramasConvertido,"g");

        assertEquals(new Peso(1500,"g"), total);
    }

    @Test
    void given1kg_WhenConverteParaGramas_ThenRetorna1000g () {
        Peso umQuilo = new Peso(1, "kg");
        Balanca balanca = new Balanca();
        balanca.adicionarTaxaDeConversao("kg", "g", 1000);
        Peso convertido = balanca.converter(umQuilo, "g");
        assertEquals(new Peso(1000, "g"), convertido);
    }


}