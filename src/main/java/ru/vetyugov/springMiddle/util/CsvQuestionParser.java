package ru.vetyugov.springMiddle.util;

import lombok.Setter;
import ru.vetyugov.springMiddle.domain.Question;
import ru.vetyugov.springMiddle.exception.FileParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvQuestionParser {
    @Setter
    private String fileName;

    public List<Question> getAllQuestionsFromFile() throws FileParserException {
        List<Question> questions = new ArrayList<>();
        if (fileName == null) {
            throw new FileParserException("File name is null");
        }
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new FileParserException("File not found");
        }
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));) {
            String row = "";
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                questions.add(new Question(data[0], data.length>1?data[1]:null));
            }
        } catch (IOException e) {
            throw new FileParserException("File read mistake : (" + fileName + "): " + e.getMessage());
        }
        return questions;
    }
}
