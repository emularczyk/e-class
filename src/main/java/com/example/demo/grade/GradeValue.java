package com.example.demo.grade;

import lombok.Getter;

@Getter
public enum GradeValue {
    ONE("1"),
    ONE_PLUS("1+"),
    TWO_MINUS("2-"),
    TWO("2"),
    TWO_PLUS("2+"),
    THREE_MINUS("3-"),
    THREE("3"),
    THREE_PLUS("3+"),
    FOUR_MINUS("4-"),
    FOUR("4"),
    FOUR_PLUS("4+"),
    FIVE_MINUS("5-"),
    FIVE("5"),
    FIVE_PLUS("5+"),
    SIX_MINUS("5-"),
    SIX("6");

    private final String value;

    GradeValue(String value) {
        this.value = value;
    }
}
