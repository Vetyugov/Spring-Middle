package ru.vetyugov.springMiddle.util.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.domain.Result;
import ru.vetyugov.springMiddle.domain.ResultItem;
import ru.vetyugov.springMiddle.domain.User;
import ru.vetyugov.springMiddle.service.IOService;
import ru.vetyugov.springMiddle.util.ResultPrinter;

@Component
public class ResultPrinterConsol implements ResultPrinter {

    private final IOService ioService;

    public ResultPrinterConsol(@Qualifier("IOServiceImpl") IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public void printResult(Result result) {
        long allCount = result.getResultItems().size();
        long rightCount = result.getResultItems().stream().filter(ResultItem::isRightAnswer).count();
        User user = result.getUser();
        StringBuilder sb = new StringBuilder();
        String s = sb
                .append("Пользователь ")
                .append(user.getName())
                .append(" ")
                .append(user.getSurname())
                .append(" набрал ")
                .append(rightCount)
                .append("/")
                .append(allCount)
                .append(" баллов")
                .toString();
        ioService.write(s);
    }
}
