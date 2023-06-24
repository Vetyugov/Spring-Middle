package ru.vetyugov.springMiddle.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vetyugov.springMiddle.dao.QuestionDao;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.service.QuestionService;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    @Override
    public List<Question> getQuestionList() {
        return questionDao.getAllQuestions();
    }
}
