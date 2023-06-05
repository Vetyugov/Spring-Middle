package ru.vetyugov.springMiddle;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vetyugov.springMiddle.util.QuestionsPrinter;

@SpringBootApplication
public class SpringMiddleApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionsPrinter questionsPrinter = context.getBean(QuestionsPrinter.class);
        questionsPrinter.printAllQuestions();
    }

}
