package ru.vetyugov.springMiddle.util;

import lombok.Setter;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.exception.ParserException;
import ru.vetyugov.springMiddle.exception.StringReaderException;
import ru.vetyugov.springMiddle.util.interfaces.QuestionReader;
import ru.vetyugov.springMiddle.util.interfaces.StringReader;
import ru.vetyugov.springMiddle.util.interfaces.StringToQuestionParser;

import java.util.List;

public class QuestionReaderImpl implements QuestionReader {
    @Setter
    private StringReader stringReader;

    @Setter
    private StringToQuestionParser stringToQuestionParser;

    @Override
    public List<Question> getAllQuestionsFromSource() throws ParserException {
        if(stringReader != null && stringToQuestionParser != null){
            try {
                return stringReader.readStrings().stream().map(stringToQuestionParser::parseString).toList();
            } catch (StringReaderException e) {
                throw new ParserException(e);
            }
        } else {
            throw new ParserException("StringReader and StringToQuestionParser must not be null");
        }
    }
}
