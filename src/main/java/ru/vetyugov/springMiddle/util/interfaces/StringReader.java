package ru.vetyugov.springMiddle.util.interfaces;

import ru.vetyugov.springMiddle.exception.StringReaderException;

import java.util.List;

public interface StringReader {
    List<String> readStrings() throws StringReaderException;
}
