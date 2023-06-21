package ru.vetyugov.springMiddle.service;

import ru.vetyugov.springMiddle.domain.Answer;
import ru.vetyugov.springMiddle.domain.Question;

public interface QuestionIOService {
    void printQuestion(Question question);

    Answer getAnswer();
}
