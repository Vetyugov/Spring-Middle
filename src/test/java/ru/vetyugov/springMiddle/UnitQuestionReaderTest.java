package ru.vetyugov.springMiddle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.exception.ParserException;
import ru.vetyugov.springMiddle.util.impl.QuestionReaderImpl;
import ru.vetyugov.springMiddle.util.StringReader;
import ru.vetyugov.springMiddle.util.StringToQuestionParser;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UnitQuestionReaderTest {
    @Mock
    private StringReader stringReader;
    @Mock
    private StringToQuestionParser stringToQuestionParser;
    @InjectMocks
    private QuestionReaderImpl questionReader;

    @BeforeEach
    void prepare() {
        List<String> strings = List.of("Question1, 1", "Question2, 2");
        given(stringReader.readStrings()).willReturn(strings);

        when(stringToQuestionParser.parseString(strings.get(0)))
                .thenReturn(new Question("Question1", "1"));
        when(stringToQuestionParser.parseString(strings.get(1)))
                .thenReturn(new Question("Question2", "2"));
    }


    @DisplayName("должен возвращать не пустой набор вопросов")
    @Test
    public void getAllQuestionsTest() throws ParserException {
        List<Question> allQuestionsFromSource = questionReader.getAllQuestionsFromSource();
        List<Question> expected = List.of(new Question("Question1", "1"), new Question("Question2", "2"));

        Assertions.assertThat(allQuestionsFromSource.size()).isEqualTo(expected.size());
        Assertions.assertThat(allQuestionsFromSource)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(expected);
    }

}
