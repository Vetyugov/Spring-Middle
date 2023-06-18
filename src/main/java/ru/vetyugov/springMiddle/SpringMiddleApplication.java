package ru.vetyugov.springMiddle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.vetyugov.springMiddle.domain.Result;
import ru.vetyugov.springMiddle.service.TaskService;
import ru.vetyugov.springMiddle.util.interfaces.ResultPrinter;

@ComponentScan
@PropertySource("classpath:application.properties")
public class SpringMiddleApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringMiddleApplication.class);
        TaskService taskService = context.getBean(TaskService.class);
        Result result = taskService.startTask();
        ResultPrinter resultPrinter = context.getBean(ResultPrinter.class);
        resultPrinter.printResult(result);
    }

}
