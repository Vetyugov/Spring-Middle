package ru.vetyugov.springMiddle.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.vetyugov.springMiddle.domain.Answer;
import ru.vetyugov.springMiddle.util.interfaces.StringToAnswerParser;

@Component
public class StringToAnswerParserImpl implements StringToAnswerParser {
    @Override
    public Answer parseAnswer(String string) {
        return new Answer(string.trim());
    }
}
