package ru.vetyugov.springMiddle.service;

import ru.vetyugov.springMiddle.dao.QuestionDao;
import ru.vetyugov.springMiddle.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionList();
}
