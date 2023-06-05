package ru.vetyugov.springMiddle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.vetyugov.springMiddle.dao.QuestionDao;
import ru.vetyugov.springMiddle.dao.QuestionDaoImpl;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.service.QuestionService;
import ru.vetyugov.springMiddle.service.QuestionServiceImpl;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {
    @Mock
    private QuestionDaoImpl questionDaoMocked;

    @Test
    public void getAllQuestionsTest() {
        QuestionService questionService = new QuestionServiceImpl(questionDaoMocked);
        List<Question> questionList = questionService.getQuestionList();
        Assertions.assertNotNull(questionList);
    }

}
