package ru.vetyugov.springMiddle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("classpath:application.properties")
public class SpringMiddleApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringMiddleApplication.class);
        TaskStarter taskService = context.getBean(TaskStarter.class);
        taskService.start();
    }

}
