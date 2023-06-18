package ru.vetyugov.springMiddle.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResultItem {
    private Question question;

    private Answer answer;

    private boolean isRightAnswer;
}
