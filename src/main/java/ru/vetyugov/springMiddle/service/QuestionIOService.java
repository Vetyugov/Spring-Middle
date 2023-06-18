package ru.vetyugov.springMiddle.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vetyugov.springMiddle.domain.Answer;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.util.interfaces.StringToAnswerParser;

@Slf4j
@Service
public class QuestionIOService {
    private final IOService ioService;

    private final StringToAnswerParser stringToAnswerParser;

    public QuestionIOService(@Qualifier("IOServiceImpl")IOService ioService, StringToAnswerParser stringToAnswerParser) {
        this.ioService = ioService;
        this.stringToAnswerParser = stringToAnswerParser;
    }

    public void printQuestion(Question question) {
        ioService.write(question.getQuestion());
    }

    public Answer getAnswer() {
        return stringToAnswerParser.parseAnswer(ioService.read());
    }
}
