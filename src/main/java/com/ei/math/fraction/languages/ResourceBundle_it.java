package com.ei.math.fraction.languages;

import java.util.ListResourceBundle;
/**
 * @author SEDRAC LUCAS CALUPEECA
 */
public class ResourceBundle_it extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lang.en", "inglese"},
            {"lnag.de", "Tedesco"},
            {"lang.es", "spagnolo"},
            {"lang.fr", "francese"},
            {"lang.pt", "portoghese"},
            {"lang.ru", "russo"},
            {"lang.it", "italiano"},
            {"lang.jp", "giapponese"},
            {"lang.cn", "Cinese"},
            {"mmc", "multiple moins commun"},
            {"step.simplify", "semplificazione delle frazioni per il massimo comun divisore (%s)"},
            {"step.start", "espressione iniziale"},
            {"step.frac.irreducible", "frazione irriducibile"},
            {"step.one.mmc", "calcola il minimo comune multiplo | mmc[%s,%s]=%s"},
            {"step.two.mmc", "nuova frazione: mmc=%s, numeratore=[per ogni frazione, il numeratore moltiplica (mmc/denominatore)], denominatore=[%s]"},
            {"step.three.mmc", "nuova frazione: numerator=[risolvere l'operazione (%s) tra i risultati della moltiplicazione],denominator=[%s]"},
            {"step.one.den.equals", "nuova frazione: numeratore=[risolvi l'operazione (%s) = risultato], denominatore=[i denominatori delle frazioni sono uguali (%s), mantieni]"},
            {"step.two.den.equals", "nuova frazione numeratore=[risultato]/%s"},
            {"step.one.cross", "nuova frazione: numeratore=[(il numeratore della prima frazione moltiplica per il denominatore della seconda frazione)%s(il denominatore della prima frazione moltiplica per il numeratore della seconda frazione)], denominatore=[moltiplica il denominatore della prima frazione al denominatore della seconda frazione]"},
            {"step.two.cross", "nuova frazione: numeratore=[(risultato della prima operazione)%s(risultato della seconda operazione)], denominatore=[%s]"},
            {"step.one.mult", "nuova frazione: numerator=[moltiplica il numeratore della prima frazione per il numeratore della seconda frazione (%s)], denominator=[moltiplica il denominatore della prima frazione per il denominatore della seconda frazione (%s)]"},
            {"step.two.mult", "nuova frazione: numeratore=[risultato dell'operazione (%s)], denominatore=[risultato dell'operazione (%s)] => %s/%s"},
            {"step.one.div", "nuova frazione: numeratore=[moltiplicare il numeratore della prima frazione per il denominatore della seconda frazione (%s)], denominatore=[moltiplicare il denominatore della prima frazione per il numeratore della seconda frazione (%s)]"},
            {"step.frac.result", "nuova frazione: numerator=[risultato dell'operazione (%s) = %s]/%s"}
        };
    }

}
