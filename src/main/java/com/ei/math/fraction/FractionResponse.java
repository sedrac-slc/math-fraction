
package com.ei.math.fraction;

import com.ei.math.Step;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FractionResponse {
    private String expression;
    private List<Step> steps;
    private Fraction fraction;
}
