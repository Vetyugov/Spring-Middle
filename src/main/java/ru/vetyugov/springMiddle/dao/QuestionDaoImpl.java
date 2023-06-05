package ru.vetyugov.springMiddle.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.exception.FileParserException;
import ru.vetyugov.springMiddle.util.CsvQuestionParser;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class QuestionDaoImpl implements QuestionDao{
    private final CsvQuestionParser csvQuestionParser;

    @Override
    public List<Question> getAllQuestions(){
        try {
            return csvQuestionParser.getAllQuestionsFromFile();
        }catch (FileParserException e){
            log.warn("Parser exception", e);
            return new ArrayList<>();
        }
    }
}
