package com.ei.math.fraction.languages;

import java.util.ListResourceBundle;
/**
 * @author SEDRAC LUCAS CALUPEECA
 */
public class ResourceBundle_pt_PT extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lang.en", "Inglês"},
            {"lang.de", "Alemão"},
            {"lang.es", "Espanhol"},
            {"lang.fr", "Frânces"},
            {"lang.pt", "Português"},
            {"lang.ru", "Russo"},
            {"lang.it", "Italino"},
            {"lang.jp", "Janponês"},
            {"lang.cn", "Chinês"},
            {"mmc", "mínimo múltiplo comum"},
            {"step.simplify", "simplificação da fração pelo máximo divisor comum (%s)"},
            {"step.start", "expressão inicial"},
            {"step.frac.irreducible", "fração irredutivel"},
            {"step.one.mmc", "calcular o mínimo múltiplo comum -> mmc[%s,%s]=%s"},
            {"step.two.mmc", "nova fração: mmc=%s, numerador=[para cada fração, o numerador multiplica (mmc/denominador)], denominador=[%s]"},
            {"step.three.mmc", "nova fração: numerator=[resolver a operação (%s) entre os resultados da multiplicação],denominador=[%s]"},
            {"step.one.den.equals", "nova fração: numerador=[resolver a operação (%s) = resultado], denominador=[denominadores das frações são iguais (%s), mantém]"},
            {"step.two.den.equals", "nova fração numerator=[resultado]/%s"},
            {"step.one.cross", "nova fração: numerador=[(numerador da primeira fração multiplica com o denominador da segunda fração)%s(denominador da primeira fração multiplica com o numerador da segunda fração)], denominador=[multiplicar o denominador da primeira fração com o denominador da segunda fração]"},
            {"step.two.cross", "nova fração: numerador=[(resultado da primera operação)%s(resultado da segunda operação)], denominador=[%s]"},
            {"step.one.mult", "nova fração: numerador=[multiplicar o numerador da primeira fração com o numerador da segunda fração (%s)], denominador=[multiplicar o denominador da primeira fração com o denominador da segunda fração (%s)]"},
            {"step.two.mult", "nova fração: numerador=[resultado da operação (%s)], denominador=[resultado da operação (%s)] => %s/%s"},
            {"step.one.div", "nova fração: numerador=[multiplicar o numerador da primeira fração com o denominador da segunda fração (%s)], denominador=[multiplicar o denominador da primeira fração com o numerador da segunda fração (%s)]"},
            {"step.frac.result", "nova fração: numerator=[resultado da operação (%s) = %s]/%s"}
        };
    }

}
