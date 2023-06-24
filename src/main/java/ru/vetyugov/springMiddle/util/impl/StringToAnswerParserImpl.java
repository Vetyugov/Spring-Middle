package ru.vetyugov.springMiddle.util.impl;

import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.domain.Answer;
import ru.vetyugov.springMiddle.util.StringToAnswerParser;

@Component
public class StringToAnswerParserImpl implements StringToAnswerParser {
    @Override
    public Answer parseAnswer(String string) {
        return new Answer(string.trim());
    }
}
