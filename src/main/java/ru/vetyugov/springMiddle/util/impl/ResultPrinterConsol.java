package ru.vetyugov.springMiddle.util.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.domain.Result;
import ru.vetyugov.springMiddle.domain.ResultItem;
import ru.vetyugov.springMiddle.domain.User;
import ru.vetyugov.springMiddle.service.IOService;
import ru.vetyugov.springMiddle.service.MessageService;
import ru.vetyugov.springMiddle.util.ResultPrinter;

@Component
public class ResultPrinterConsol implements ResultPrinter {

    private final IOService ioService;

    private final MessageService messageService;

    public ResultPrinterConsol(
            @Qualifier("IOServiceImpl") IOService ioService,
            MessageService messageService) {
        this.ioService = ioService;
        this.messageService = messageService;
    }

    @Override
    public void printResult(Result result) {
        long allCount = result.getResultItems().size();
        long rightCount = result.getResultItems().stream().filter(ResultItem::isRightAnswer).count();
        User user = result.getUser();
        String str = messageService.getMessageByKey("question.ResultString", new String[]{
                user.getName() + " " + user.getSurname(),
                String.valueOf(rightCount),
                String.valueOf(allCount)
        });
        ioService.write(str);
    }
}
