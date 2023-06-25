package ru.vetyugov.springMiddle.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vetyugov.springMiddle.domain.Answer;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.service.IOService;
import ru.vetyugov.springMiddle.service.QuestionIOService;
import ru.vetyugov.springMiddle.util.StringToAnswerParser;

@Slf4j
@Service
public class QuestionIOServiceImpl implements QuestionIOService {
    private final IOService ioService;

    private final StringToAnswerParser stringToAnswerParser;

    public QuestionIOServiceImpl(@Qualifier("IOServiceImpl")IOService ioService, StringToAnswerParser stringToAnswerParser) {
        this.ioService = ioService;
        this.stringToAnswerParser = stringToAnswerParser;
    }

    @Override
    public void printQuestion(Question question) {
        ioService.write(question.getQuestion()+"\n");
    }

    @Override
    public Answer getAnswer() {
        return stringToAnswerParser.parseAnswer(ioService.read());
    }
}
