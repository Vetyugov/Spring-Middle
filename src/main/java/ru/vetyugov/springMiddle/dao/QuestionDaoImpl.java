package ru.vetyugov.springMiddle.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.exception.ParserException;
import ru.vetyugov.springMiddle.util.QuestionReaderImpl;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Component
public class QuestionDaoImpl implements QuestionDao{
    private final QuestionReaderImpl questionParserImpl;

    @Override
    public List<Question> getAllQuestions(){
        try {
            return questionParserImpl.getAllQuestionsFromSource();
        }catch (ParserException e){
            log.warn("Parser exception", e);
            return new ArrayList<>();
        }
    }
}
