package com.ei.math.fraction.languages;

import java.util.ListResourceBundle;
/**
 * @author SEDRAC LUCAS CALUPEECA
 */
public class ResourceBundle_es_Es extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lang.en", "inglés"},
            {"lnag.de", "Alemán"},
            {"lang.es", "español"},
            {"lang.fr", "Francés"},
            {"lang.pt", "portugués"},
            {"lang.ru", "ruso"},
            {"lang.it", "italiano"},
            {"lang.jp", "japonés"},
            {"lang.cn", "Chino"},
            {"mmc", "minimo común multiplo"},
            {"step.simplify", "simplificación de fracciones por el máximo común divisor (%s)"},
            {"step.start", "expresión inicial"},
            {"step.frac.irreducible", "fracción irreducible"},
            {"step.one.mmc", "calcular mínimo común múltiplo -> mmc[%s,%s]", "%s"},
            {"step.two.mmc=nueva fracción: mmc=%s, numerador=[para cada fracción, el numerador multiplica (mmc/denominador)], denominador=[%s]"},
            {"step.three.mmc", "nueva fracción: numerador=[resuelve la operación (%s) entre los resultados de la multiplicación],denominador=[%s]"},
            {"step.one.den.equals", "nueva fracción: numerador=[operación de resolución (%s) = resultado], denominador=[los denominadores de las fracciones son iguales (%s), mantener]"},
            {"step.two.den.equals", "nueva fracción numerador=[resultado]/%s"},
            {"step.one.cross", "nueva fracción: numerador=[(el numerador de la primera fracción se multiplica por el denominador de la segunda fracción)%s(el denominador de la primera fracción se multiplica por el numerador de la segunda fracción)], denominador=[multiplica el denominador de la primera fracción con el denominador de la segunda fracción]"},
            {"step.two.cross", "nueva fracción: numerador=[(resultado de la primera operación)%s(resultado de la segunda operación)], denominador=[%s]"},
            {"step.one.mult", "nueva fracción: numerador=[multiplicar el numerador de la primera fracción por el numerador de la segunda fracción (%s)], denominador=[multiplicar el denominador de la primera fracción por el denominador de la segunda fracción (%s)]"},
            {"step.two.mult", "nueva fracción: numerador=[resultado de la operación (%s)], denominador=[resultado de la operación (%s)] => %s/%s"},
            {"step.one.div", "nueva fracción: numerador=[multiplicar el numerador de la primera fracción por el denominador de la segunda fracción (%s)], denominador=[multiplicar el denominador de la primera fracción por el numerador de la segunda fracción (%s)]"},
            {"step.frac.result", "nueva fracción: numerador=[resultado de la operación (%s) = %s]/%s"}
        };
    }

}
