package ru.vetyugov.springMiddle.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vetyugov.springMiddle.dao.QuestionDao;
import ru.vetyugov.springMiddle.domain.Question;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{
    private final QuestionDao questionDao;

    @Override
    public List<Question> getQuestionList() {
        return questionDao.getAllQuestions();
    }
}
