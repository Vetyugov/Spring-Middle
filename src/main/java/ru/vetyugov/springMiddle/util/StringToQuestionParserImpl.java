package ru.vetyugov.springMiddle.util;

import lombok.Setter;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.util.interfaces.StringToQuestionParser;

public class StringToQuestionParserImpl implements StringToQuestionParser {
    @Setter
    private String regex = "";

    @Override
    public Question parseString(String string) {
        String[] data = string.split(regex);
        return new Question(data[0], data.length > 1 ? data[1] : null);
    }
}
