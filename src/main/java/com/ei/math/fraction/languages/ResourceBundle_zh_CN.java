package com.ei.math.fraction.languages;

import java.util.ListResourceBundle;

/**
 * @author SEDRAC LUCAS CALUPEECA
 */
public class ResourceBundle_zh_CN extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lang.en", "英语"},
            {"lnag.de", "德语"},
            {"lang.es", "西班牙语"},
            {"lang.fr", "法语"},
            {"lang.pt", "葡萄牙语"},
            {"lang.ru", "俄语"},
            {"lang.it", "意大利语"},
            {"lang.jp", "日本人"},
            {"lang.cn", "中国人"},
            {"mmc", "最小公倍数"},
            {"step.start", "初始表达式"},
            {"step.simplify", "用最大公约数化简分数 (%s)"},
            {"step.frac.irreducible", "不可约分数"},
            {"step.one.mmc", "计算最小公倍数 -> mmc[%s,%s]=%s"},
            {"step.two.mmc", "新分数：mmc=%s，分子=[对于每个分数，分子乘以（mmc/分母）]，分母=[%s]"},
            {"step.three.mmc", "新分数：分子=[解析乘法结果之间的运算（%s）],分母=[%s]"},
            {"step.one.den.equals", "新分数：分子=[求解运算（%s）=结果]，分母=[分数的分母相等（%s]"},
            {"step.two.den.equals", "新分数分子=[结果]/%s"},
            {"step.one.cross", "新分数：分子=[（第一个分数的分子乘以第二个分数的分母）%s（第一个分数的分母乘以第二个分数的分子）]，分母=[乘以第一个分数的分母与第二个分数的分母]"},
            {"step.two.cross", "新分数：分子=[（第一次运算的结果）%s（第二次运算的结果）]，分母=[%s]"},
            {"step.one.mult", "新分数：分子=[将第一个分数的分子乘以第二个分数的分子（%s）]，分母=[将第一个分数的分母乘以第二个分数的分母（%s）]"},
            {"step.two.mult", "新分数：分子=[运算结果 (%s)]，分母=[运算结果 (%s)] => %s/%s"},
            {"step.one.div", "新分数：分子=[将第一个分数的分子乘以第二个分数的分母（%s）]，分母=[将第一个分数的分母乘以第二个分数的分子（%s）]"},
            {"step.frac.result", "新分数：分子=[运算结果 (%s) = %s]/%s"}
        };
    }

}
