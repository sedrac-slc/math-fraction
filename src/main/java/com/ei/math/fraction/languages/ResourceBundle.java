package com.ei.math.fraction.languages;

import java.util.ListResourceBundle;
/**
 * @author SEDRAC LUCAS CALUPEECA
 */
public class ResourceBundle extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lang.en", "English"},
            {"lnag.de", "German"},
            {"lang.es", "Spanish"},
            {"lang.fr", "French"},
            {"lang.pt", "Portuguese"},
            {"lang.ru", "Russian"},
            {"lang.it", "italian"},
            {"lang.jp", "japanese"},
            {"lang.cn", "Chinese"},
            {"mmc", "least common multiple"},
            {"step.simplify", "fraction simplification by the greatest common divisor (%s)"},
            {"step.start", "initial expression"},
            {"step.frac.irreducible", "irreducible fraction"},
            {"step.one.mmc", "calculate least common multiple -> mmc[%s,%s]=%s"},
            {"step.two.mmc", "new fraction: mmc=%s, numerator=[for each fraction, the numerator multiplies (mmc/denominator)], denominator=[%s]"},
            {"step.three.mmc", "new fraction: numerator=[resolve the operation (%s) between multiplication results],denominator=[%s]"},
            {"step.one.den.equals", "new fraction: numerator=[solve operation (%s) = result], denominator=[denominators of fractions are equal (%s), keep]"},
            {"step.two.den.equals", "new fraction numerator=[result]/%s"},
            {"step.one.cross", "new fraction: numerator=[(numerator of the first fraction multiplies with the denominator of the second fraction)%s(denominator of the first fraction multiplies with the numerator of the second fraction)], denominator=[multiply the denominator of the first fraction with the denominator of the second fraction]"},
            {"step.two.cross", "new fraction: numerator=[(result of the first operation)%s(result of the second operation)], denominator=[%s]"},
            {"step.one.mult", "new fraction: numerator=[multiply the numerator of the first fraction with the numerator of the second fraction (%s)], denominator=[multiply the denominator of the first fraction with the denominator of the second fraction (%s)]"},
            {"step.two.mult", "new fraction: numerator=[result of operation (%s)], denominator=[result of operation (%s)] => %s/%s"},
            {"step.one.div", "new fraction: numerator=[multiply the numerator of the first fraction with the denominator of the second fraction (%s)], denominator=[multiply the denominator of the first fraction with the numerator of the second fraction (%s)]"},
            {"step.frac.result", "new fraction: numerator=[result operation (%s) = %s]/%s"}
        };
    }

}
