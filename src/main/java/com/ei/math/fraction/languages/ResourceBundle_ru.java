package com.ei.math.fraction.languages;

import java.util.ListResourceBundle;
/**
 * @author SEDRAC LUCAS CALUPEECA
 */
public class ResourceBundle_ru extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lang.en", "Английский"},
            {"lnag.de", "Немецкий"},
            {"lang.es", "испанский"},
            {"lang.fr", "Французский"},
            {"lang.pt", "португальский"},
            {"lang.ru", "Русский"},
            {"lang.it", "итальянский"},
            {"lang.jp", "Японский"},
            {"lang.cn", "Китайский"},
            {"mmc", "Наименьший общий множитель"},
            {"step.simplify", "упрощение дробей на наибольший общий делитель (%s)"},
            {"step.start", "Исходное выражение"},
            {"step.frac.irreducible", "несократимая дробь"},
            {"step.one.mmc", "вычислить наименьшее общее кратное -> mmc[%s,%s]=%s"},
            {"step.two.mmc", "новая дробь: mmc=%s, numerator=[для каждой дроби числитель умножается (mmc/знаменатель)], знаменатель=[%s]"},
            {"step.three.mmc", "новая дробь: числитель=[разрешить операцию (%s) между результатами умножения],знаменатель=[%s]"},
            {"step.one.den.equals", "новая дробь: числитель=[операция решения (%s) = результат], знаменатель=[знаменатели дробей равны (%s)]"},
            {"step.two.den.equals", "новый числитель дроби=[результат]/%s"},
            {"step.one.cross", "новая дробь: numerator=[(числитель первой дроби умножается на знаменатель второй дроби)%s(знаменатель первой дроби умножается на числитель второй дроби)], denominator=[умножается знаменатель первой дроби со знаменателем второй дроби]"},
            {"step.two.cross", "новая дробь: числитель=[(результат первой операции)%s(результат второй операции)], знаменатель=[%s]"},
            {"step.one.mult", "новая дробь: числитель=[умножьте числитель первой дроби на числитель второй дроби (%s)], знаменатель=[умножьте знаменатель первой дроби на знаменатель второй дроби (%s)]"},
            {"step.two.mult", "новая дробь: числитель=[результат операции (%s)], знаменатель=[результат операции (%s)] => %s/%s"},
            {"step.one.div", "новая дробь: числитель=[умножьте числитель первой дроби на знаменатель второй дроби (%s)], знаменатель=[умножьте знаменатель первой дроби на числитель второй дроби (%s)]"},
            {"step.frac.result", "результат[4]/результат[3]новая дробь: числитель=[результат операции (%s) = %s]/%s"}
        };
    }

}