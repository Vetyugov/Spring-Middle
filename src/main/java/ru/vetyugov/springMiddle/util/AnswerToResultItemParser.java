package ru.vetyugov.springMiddle.util;

import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.domain.Answer;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.domain.ResultItem;

@Component
public class AnswerToResultItemParser {
    public ResultItem getResultItem(Question question, Answer answer){
        return new ResultItem(
                question,
                answer,
                question.getRightAnswer().equalsIgnoreCase(answer.getAnswer())
        );
    }
}
