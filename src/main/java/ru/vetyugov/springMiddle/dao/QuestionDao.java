package ru.vetyugov.springMiddle.dao;

import ru.vetyugov.springMiddle.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getAllQuestions();
}
