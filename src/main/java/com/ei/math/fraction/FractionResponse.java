
package com.ei.math.fraction;

import com.ei.math.Step;
import java.util.Arrays;
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
    @Builder.Default
    private List<Step> steps = Arrays.asList();
    private Fraction fraction;
    @Builder.Default
    private boolean status = false;
}
