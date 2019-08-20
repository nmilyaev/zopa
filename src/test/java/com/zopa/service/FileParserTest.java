package com.zopa.service;

import com.zopa.model.Lender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FileParserTest {

    @InjectMocks
    private FileParser parser;

    @Test
    public void shouldReadCorrectFile() {
        Lender lender = new Lender("Bob", 0.075f, 640L);
        parser.readAndParseFile("market-data-correct-2.csv");
    }

    @Test
    public void shouldFailOnIncorrectFile() {
        Lender lender = new Lender("Bob", 0.075f, 640L);
        parser.readAndParseFile("market-data-incorrect-2.csv");
    }
}