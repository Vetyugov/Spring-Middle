package ru.vetyugov.springMiddle.util;

import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.domain.Answer;
import ru.vetyugov.springMiddle.domain.User;

@Component
public class AnswerToUserParser {
    public User getUser(Answer answer){
        String[] s = answer.getAnswer().split(" ");
        String name = s.length > 0 ? s[0]:"";
        String surname = s.length > 1 ? s[1]:"";
        return new User(name, surname);
    }
}
