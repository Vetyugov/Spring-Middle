package ru.vetyugov.springMiddle.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.service.QuestionService;

@AllArgsConstructor
@Slf4j
public class QuestionsPrinter {
    private final QuestionService questionService;

    public void printAllQuestions(){
        log.info("Questions:");
        for (Question question:questionService.getQuestionList()) {
            log.info(question.getQuestion());
        }
    }
}
