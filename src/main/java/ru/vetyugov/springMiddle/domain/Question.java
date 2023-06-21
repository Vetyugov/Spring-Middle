package ru.vetyugov.springMiddle.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Question {
    private final String question;

    private final String rightAnswer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(rightAnswer, question1.rightAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, rightAnswer);
    }
}
