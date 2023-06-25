package ru.vetyugov.springMiddle.runner;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.domain.Result;
import ru.vetyugov.springMiddle.service.TaskService;
import ru.vetyugov.springMiddle.util.ResultPrinter;

@Component
@AllArgsConstructor
public class TaskStarter implements CommandLineRunner {
    private final TaskService taskService;

    private final ResultPrinter resultPrinter;

    @Override
    public void run(String... args) throws Exception {
        Result result = taskService.startTask();
        resultPrinter.printResult(result);
    }
}
