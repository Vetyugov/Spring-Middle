package ru.vetyugov.springMiddle.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vetyugov.springMiddle.domain.User;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.domain.Answer;
import ru.vetyugov.springMiddle.domain.Result;
import ru.vetyugov.springMiddle.domain.ResultItem;
import ru.vetyugov.springMiddle.util.AnswerToResultItemParser;
import ru.vetyugov.springMiddle.util.AnswerToUserParser;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final QuestionService questionService;

    private final QuestionIOService questionIOService;

    private final AnswerToUserParser answerToUserParser;

    private final AnswerToResultItemParser answerToResultItemParser;

    @Override
    public Result startTask() {
        Question firstQuestion = new Question("Введите Имя и Фамилию", null);
        User user = answerToUserParser.getUser(doQuestion(firstQuestion));

        List<Question> questionList = questionService.getQuestionList();
        List<ResultItem> resultItemList = new LinkedList<>();
        for (Question question : questionList) {
            ResultItem resultItem = answerToResultItemParser.getResultItem(question, doQuestion(question));
            resultItemList.add(resultItem);
        }

        return new Result(user, resultItemList);
    }

    public Answer doQuestion(Question question) {
        questionIOService.printQuestion(question);
        return questionIOService.getAnswer();
    }
}
