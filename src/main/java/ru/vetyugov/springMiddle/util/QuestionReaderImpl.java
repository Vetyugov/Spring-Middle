package ru.vetyugov.springMiddle.util;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.exception.ParserException;
import ru.vetyugov.springMiddle.exception.StringReaderException;
import ru.vetyugov.springMiddle.util.interfaces.QuestionReader;
import ru.vetyugov.springMiddle.util.interfaces.StringReader;
import ru.vetyugov.springMiddle.util.interfaces.StringToQuestionParser;

import java.util.List;

@Component
@AllArgsConstructor
public class QuestionReaderImpl implements QuestionReader {
    private final StringReader stringReader;

    private final StringToQuestionParser stringToQuestionParser;

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
