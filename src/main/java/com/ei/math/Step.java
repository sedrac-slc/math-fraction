package com.ei.math;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *{@code Step} class represents the steps for solving an operation
 * 
 * @author  Sedrac Lucas Calupeteca
 * @since   1.0
 */
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
