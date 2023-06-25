package ru.vetyugov.springMiddle.util.impl;

import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.config.AppQuestionProps;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.util.StringToQuestionParser;

@Component
public class StringToQuestionParserImpl implements StringToQuestionParser {
    private final String regex;

    public StringToQuestionParserImpl(AppQuestionProps appQuestionProps) {
        this.regex = appQuestionProps.getRegex();
    }

    @Override
    public Question parseString(String string) {
        String[] data = string.split(regex);
        return new Question(data[0].trim(), data.length > 1 ? data[1].trim() : null);
    }
}
