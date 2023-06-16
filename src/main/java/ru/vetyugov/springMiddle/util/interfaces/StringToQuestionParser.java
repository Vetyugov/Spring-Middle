package ru.vetyugov.springMiddle.util.interfaces;

import ru.vetyugov.springMiddle.domain.Question;

public interface StringToQuestionParser {
    public Question parseString(String string);
}
