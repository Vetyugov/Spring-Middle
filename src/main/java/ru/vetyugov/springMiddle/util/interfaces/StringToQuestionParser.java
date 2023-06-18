package ru.vetyugov.springMiddle.util.interfaces;

import ru.vetyugov.springMiddle.domain.Question;

public interface StringToQuestionParser {
    Question parseString(String string);
}
