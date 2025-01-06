package com.iafenvoy.sow.util.lambda;

@FunctionalInterface
public interface Int2BooleanBiFunction {
    boolean applyAsBoolean(int a, int b);
}
