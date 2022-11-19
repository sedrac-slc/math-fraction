package com.ei.math.fraction.languages;

import java.util.ListResourceBundle;
/**
 * @author SEDRAC LUCAS CALUPEECA
 */
public class ResourceBundle_de extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lang.en", "Englisch"},
            {"lnag.de", "Deutsch"},
            {"lang.es", "Spanisch"},
            {"lang.fr", "Französisch"},
            {"lang.pt", "Portugiesisch"},
            {"lang.ru", "Russisch"},
            {"lang.it", "Italienisch"},
            {"lang.jp", "japanisch"},
            {"lang.cn", "Chinesisch"},
            {"mmc", "kleinstes gemeinsames Vielfaches"},
            {"step.simplify", "Vereinfachung von Brüchen durch den größten gemeinsamen Teiler (%s)"},
            {"step.start", "Anfangsausdruck"},
            {"step.frac.irreducible", "irreduzibler Bruch"},
            {"step.one.mmc", "Berechnen Sie das kleinste gemeinsame Vielfache -> mmc[%s,%s]=%s"},
            {"step.two.mmc", "neuer Bruch: mmc=%s, Zähler=[für jeden Bruch multipliziert sich der Zähler mit (mmc/Nenner)], Nenner=[%s]"},
            {"step.three.mmc", "Neuer Bruch: Zähler=[Auflösung der Operation (%s) zwischen Multiplikationsergebnissen],Nenner=[%s]"},
            {"step.one.den.equals", "neuer Bruch: Zähler=[Operation lösen (%s) = Ergebnis], Nenner=[Nenner der Brüche sind gleich (%s), behalten]"},
            {"step.two.den.equals", "Neuer Bruchzähler=[Ergebnis]/%s"},
            {"step.one.cross", "neuer Bruch: Zähler=[(Zähler des ersten Bruchs multipliziert mit dem Nenner des zweiten Bruchs)%s(Nenner des ersten Bruchs multipliziert mit dem Zähler des zweiten Bruchs)], Nenner=[multipliziere den Nenner des ersten Bruchs mit dem Nenner des zweiten Bruchs]"},
            {"step.two.cross", "neuer Bruch: Zähler=[(Ergebnis der ersten Operation)%s(Ergebnis der zweiten Operation)], Nenner=[%s]"},
            {"step.one.mult", "neuer Bruch: Zähler=[multipliziere den Zähler des ersten Bruchs mit dem Zähler des zweiten Bruchs (%s)], Nenner=[multipliziere den Nenner des ersten Bruchs mit dem Nenner des zweiten Bruchs (%s)]"},
            {"step.two.mult", "neuer Bruch: Zähler=[Ergebnis der Operation (%s)], Nenner=[Ergebnis der Operation (%s)] => %s/%s"},
            {"step.one.div", "neuer Bruch: numerator=[multipliziere den Zähler des ersten Bruchs mit dem Nenner des zweiten Bruchs (%s)], nenner=[multipliziere den Nenner des ersten Bruchs mit dem Zähler des zweiten Bruchs (%s)]"},
            {"step.frac.result", "neuer Bruch: Zähler=[Ergebnis der Operation (%s) = %s]/%s"}
        };
    }

}
