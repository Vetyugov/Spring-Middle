package ru.vetyugov.springMiddle.dao.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.dao.QuestionDao;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.util.QuestionReader;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Component
public class QuestionDaoImpl implements QuestionDao {
    private final QuestionReader questionReader;

    @Override
    public List<Question> getAllQuestions(){
//        try {
            return questionReader.getAllQuestionsFromSource();
//        }catch (ParserException e){
//            log.warn("Parser exception", e);
//            return new ArrayList<>();
//        }
    }
}
