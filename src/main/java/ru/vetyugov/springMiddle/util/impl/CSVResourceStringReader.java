package ru.vetyugov.springMiddle.util.impl;

import org.springframework.stereotype.Component;
import ru.vetyugov.springMiddle.config.AppQuestionProps;
import ru.vetyugov.springMiddle.exception.StringReaderException;
import ru.vetyugov.springMiddle.service.MessageService;
import ru.vetyugov.springMiddle.util.StringReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVResourceStringReader implements StringReader {
    private final String fileName;

    public CSVResourceStringReader(AppQuestionProps appQuestionProps, MessageService messageService) {
        this.fileName = messageService.getMessageByKey(appQuestionProps.getBundleFileName());
    }

    @Override
    public List<String> readStrings() throws StringReaderException {
        if (fileName == null) {
            throw new StringReaderException("File name is null");
        }
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new StringReaderException("File not found : " + fileName);
        }
        List<String> listLines = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));) {
            String row = "";
            while ((row = csvReader.readLine()) != null) {
                listLines.add(row);
            }
        } catch (IOException e) {
            throw new StringReaderException("File read mistake : (" + fileName + "): " + e.getMessage());
        }
        return listLines;
    }
}
