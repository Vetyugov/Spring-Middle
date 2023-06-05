package ru.vetyugov.springMiddle.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Question {
    private final String question;
    private final String rightAnswer;
}
