package com.zopa.service;

import com.zopa.model.Lender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FileParserTest {

    @InjectMocks
    private FileParser parser;

    @Test
    public void shouldReadCorrectFile() {
        Lender lender = new Lender("Bob", 0.075f, 640L);
        URL resource = getClass().getClassLoader().getResource("market-data-correct-2.csv");
        List<Lender> lenders = parser.readAndParseFile(resource.getPath());
        assertEquals(1, lenders.size());
        assertEquals(lender, lenders.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailOnIncorrectNumericValue() {
        Lender lender = new Lender("Bob", 0.075f, 640L);
        URL resource = getClass().getClassLoader().getResource("market-data-incorrect-2.csv");
        List<Lender> lenders = parser.readAndParseFile(resource.getPath());
        assertEquals(lender, lenders.get(0));
    }

    @Test
    public void shouldFailOnIncorrectNumberOfColumns() {
        //TODO
    }

    //TODO - add more tests here
}