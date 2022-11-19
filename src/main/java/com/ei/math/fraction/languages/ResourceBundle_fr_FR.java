package com.ei.math.fraction.languages;

import java.util.ListResourceBundle;
/**
 * @author SEDRAC LUCAS CALUPEECA
 */
public class ResourceBundle_fr_FR extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lang.en", "Anglais"},
            {"lnag.de", "Allemand"},
            {"lang.es", "Espagnol"},
            {"lang.fr", "Français"},
            {"lang.pt", "Portugais"},
            {"lang.ru", "russe"},
            {"lang.it", "italien"},
            {"lang.jp", "Japonais"},
            {"lang.cn", "Chinois"},
            {"mmc", "multiple moins commun"},
            {"step.simplify", "simplification de fractions par le plus grand diviseur commun (%s)"},
            {"step.start", "expression initiale"},
            {"step.frac.irreducible", "fraction irréductible"},
            {"step.one.mmc", "calculer le plus petit commun multiple -> mmc[%s,%s]=%s"},
            {"step.two.mmc", "nouvelle fraction : mmc=%s, numérateur=[pour chaque fraction, le numérateur multiplie (mmc/dénominateur)], dénominateur=[%s]"},
            {"step.three.mmc", "nouvelle fraction : numérateur=[résoudre l'opération (%s) entre les résultats de la multiplication], dénominateur=[%s]"},
            {"step.one.den.equals", "nouvelle fraction : numérateur=[opération de résolution (%s) = résultat], dénominateur=[les dénominateurs des fractions sont égaux (%s), conserver]"},
            {"step.two.den.equals", "nouveau numérateur de fraction=[résultat]/%s"},
            {"step.one.cross", "nouvelle fraction : numérateur=[(numérateur de la première fraction multiplié par le dénominateur de la deuxième fraction)%s(dénominateur de la première fraction multiplié par le numérateur de la deuxième fraction)], dénominateur=[multiplier le dénominateur de la première fraction avec le dénominateur de la deuxième fraction]"},
            {"step.two.cross", "nouvelle fraction : numérateur=[(résultat de la première opération)%s(résultat de la deuxième opération)], dénominateur=[%s]"},
            {"step.one.mult", "nouvelle fraction : numérateur=[multiplier le numérateur de la première fraction par le numérateur de la deuxième fraction (%s)], dénominateur=[multiplier le dénominateur de la première fraction par le dénominateur de la deuxième fraction (%s)]"},
            {"step.two.mult", "nouvelle fraction : numérateur=[résultat de l'opération (%s)], dénominateur=[résultat de l'opération (%s)] => %s/%s"},
            {"step.one.div", "nouvelle fraction : numérateur=[multiplier le numérateur de la première fraction par le dénominateur de la deuxième fraction (%s)], dénominateur=[multiplier le dénominateur de la première fraction par le numérateur de la deuxième fraction (%s)]"},
            {"step.frac.result", "nouvelle fraction : numérateur=[résultat de l'opération (%s) = %s]/%s"}
        };
    }

}
