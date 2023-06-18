package ru.vetyugov.springMiddle;

import org.junit.jupiter.api.*;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.exception.ParserException;
import ru.vetyugov.springMiddle.util.CSVResourceStringReader;
import ru.vetyugov.springMiddle.util.QuestionReaderImpl;
import ru.vetyugov.springMiddle.util.StringToQuestionParserImpl;
import ru.vetyugov.springMiddle.util.interfaces.StringReader;
import ru.vetyugov.springMiddle.util.interfaces.StringToQuestionParser;

import java.util.List;

public class UnitQuestionReaderTest {
    private StringReader stringReader;
    private StringToQuestionParser stringToQuestionParser;
    private QuestionReaderImpl questionReader;

    @BeforeEach
    void prepare(){
        stringReader = new CSVResourceStringReader("questions.csv");
        stringToQuestionParser = new StringToQuestionParserImpl(",");
        questionReader = new QuestionReaderImpl(stringReader, stringToQuestionParser);
    }


    @DisplayName("должен возвращать не пустой набор вопросов")
    @Test
    public void getAllQuestionsTest() throws ParserException {
        List<Question> allQuestionsFromSource = questionReader.getAllQuestionsFromSource();
        System.err.println(allQuestionsFromSource);
        Assertions.assertNotNull(allQuestionsFromSource);
        Assertions.assertFalse(allQuestionsFromSource.isEmpty());
    }

}
