package com.example.demo.grade;

import lombok.Getter;

@Getter
public enum GradeValue {
    ZERO("0", 0f),
    ONE("1", 1f),
    ONE_PLUS("1+", 1.5f),
    TWO_MINUS("2-", 1.75f),
    TWO("2", 2f),
    TWO_PLUS("2+", 2.5f),
    THREE_MINUS("3-", 2.75f),
    THREE("3", 3f),
    THREE_PLUS("3+", 3.5f),
    FOUR_MINUS("4-", 3.75f),
    FOUR("4", 4f),
    FOUR_PLUS("4+", 4.5f),
    FIVE_MINUS("5-", 4.75f),
    FIVE("5", 5f),
    FIVE_PLUS("5+", 5.5f),
    SIX_MINUS("6-", 5.75f),
    SIX("6", 6f);

    private final String value;
    private final float floatValue;

    GradeValue(String value, float floatValue) {
        this.value = value;
        this.floatValue = floatValue;
    }
}
