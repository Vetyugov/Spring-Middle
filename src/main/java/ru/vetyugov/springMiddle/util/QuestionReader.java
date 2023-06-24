package ru.vetyugov.springMiddle.util;

import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.exception.ParserException;

import java.util.List;

public interface QuestionReader {
    List<Question> getAllQuestionsFromSource() throws ParserException;
}
