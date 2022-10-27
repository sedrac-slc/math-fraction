package com.ei.math;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true,access = AccessLevel.PUBLIC)
public class Step {
    private Integer codigo;
    private String text;
    private String html;
    @Builder.Default
    private String message="";
}
