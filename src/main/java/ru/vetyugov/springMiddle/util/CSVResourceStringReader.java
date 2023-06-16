package ru.vetyugov.springMiddle.util;

import lombok.Setter;
import ru.vetyugov.springMiddle.exception.StringReaderException;
import ru.vetyugov.springMiddle.util.interfaces.StringReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVResourceStringReader implements StringReader {
    @Setter
    private String fileName;

    @Override
    public List<String> readStrings() throws StringReaderException {
        if (fileName == null) {
            throw new StringReaderException("File name is null");
        }
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new StringReaderException("File not found");
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
