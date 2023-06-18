package ru.vetyugov.springMiddle.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {
    private final Scanner scanner;

    private final PrintStream printStream;

    public IOServiceImpl() {
        this.scanner = new Scanner(System.in);
        this.printStream = new PrintStream(System.out);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(String string) {
        printStream.print(string);
    }
}
