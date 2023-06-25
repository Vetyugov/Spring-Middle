package ru.vetyugov.springMiddle.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vetyugov.springMiddle.domain.*;
import ru.vetyugov.springMiddle.service.MessageService;
import ru.vetyugov.springMiddle.service.QuestionIOService;
import ru.vetyugov.springMiddle.service.QuestionService;
import ru.vetyugov.springMiddle.service.TaskService;
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

    private final MessageService messageService;

    @Override
    public Result startTask() {
        String firstQuestionStr = messageService.getMessageByKey(
                "question.Enter Name and Surname");
        Question firstQuestion = new Question(firstQuestionStr, null);
        User user = answerToUserParser.getUser(doQuestion(firstQuestion));

        List<Question> questionList = questionService.getQuestionList();
        List<ResultItem> resultItemList = new LinkedList<>();
        for (Question question : questionList) {
            ResultItem resultItem = answerToResultItemParser.getResultItem(question, doQuestion(question));
            resultItemList.add(resultItem);
        }

        return new Result(user, resultItemList);
    }

    private Answer doQuestion(Question question) {
        questionIOService.printQuestion(question);
        return questionIOService.getAnswer();
    }
}
