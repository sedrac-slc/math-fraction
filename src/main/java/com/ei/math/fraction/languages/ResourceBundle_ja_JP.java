package com.ei.math.fraction.languages;

import java.util.ListResourceBundle;
/**
 * @author SEDRAC LUCAS CALUPEECA
 */
public class ResourceBundle_ja_JP extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lang.en", "英語"},
            {"lnag.de", "ドイツ人"},
            {"lang.es", "スペイン語"},
            {"lang.fr", "フランス語"},
            {"lang.pt", "ポルトガル語"},
            {"lang.ru", "ロシア"},
            {"lang.it", "イタリア語"},
            {"lang.jp", "日本語"},
            {"lang.cn", "中国語"},
            {"mmc", "最小公倍数"},
            {"step.simplify", "最大公約数による分数の整理 (%s)"},
            {"step.start", "初期式"},
            {"step.frac.irreducible", "既約分数"},
            {"step.one.mmc", "最小公倍数を計算する -> mmc[%s,%s]=%s"},
            {"step.two.mmc", "新しい分数: mmc=%s、分子=[各分数について、分子は (mmc/分母) を掛ける]、分母=[%s]"},
            {"step.three.mmc", "新しい分数: 分子=[乗算結果間の演算 (%s) を解決する],分母=[%s]"},
            {"step.one.den.equals", "新しい分数: 分子=[解演算 (%s) = 結果]、分母=[分数の分母が等しい (%s)]"},
            {"step.two.den.equals", "新しい分数分子=[結果]/%s"},
            {"step.one.cross", "新分数：分子=[（第一个分数的分子乘以第二个分数的分母）%s（第一个分数的分母乘以第二个分数的分子）]，分母=[乘以第一个分数的分母与第二个分数的分母]"},
            {"step.two.cross", "新しい分数: 分子=[(最初の演算の結果)%s(2 番目の演算の結果)]、分母=[%s]"},
            {"step.one.mult", "新しい分数:分子=[最初の分数の分子に2番目の分数の分子(%s)を掛ける]、分母=[最初の分数の分母に2番目の分数の分母(%s)を掛ける]"},
            {"step.two.mult", "新しい分数: 分子=[演算結果 (%s)]、分母=[演算結果 (%s)] => %s/%s"},
            {"step.one.div", "新しい分数:分子=[最初の分数の分子に2番目の分数の分母(%s)を掛ける]、分母=[最初の分数の分母に2番目の分数の分子(%s)を掛ける]"},
            {"step.frac.result", "新しい分数: 分子=[演算結果 (%s) = %s]/%s"}
        };
    }

}
