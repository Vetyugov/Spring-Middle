package ru.vetyugov.springMiddle.util;

import ru.vetyugov.springMiddle.domain.Answer;

public interface StringToAnswerParser {
    Answer parseAnswer(String string);
}
