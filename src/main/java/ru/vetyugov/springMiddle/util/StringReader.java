package ru.vetyugov.springMiddle.util;

import ru.vetyugov.springMiddle.exception.StringReaderException;

import java.util.List;

public interface StringReader {
    List<String> readStrings() throws StringReaderException;
}
