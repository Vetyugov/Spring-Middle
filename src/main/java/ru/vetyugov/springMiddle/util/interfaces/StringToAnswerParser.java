package ru.vetyugov.springMiddle.util.interfaces;

import ru.vetyugov.springMiddle.domain.Answer;

public interface StringToAnswerParser {
    Answer parseAnswer(String string);
}
