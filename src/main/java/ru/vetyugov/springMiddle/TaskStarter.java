package ru.vetyugov.springMiddle;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.domain.Result;
import ru.vetyugov.springMiddle.service.TaskService;
import ru.vetyugov.springMiddle.util.interfaces.ResultPrinter;

@Component
@AllArgsConstructor
public class TaskStarter {
    private final TaskService taskService;

    private final ResultPrinter resultPrinter;

    public void start(){
        Result result = taskService.startTask();
        resultPrinter.printResult(result);
    }
}
