package com.zopa.service;

import com.zopa.model.Lender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileParser {
//    public static String CSVF_ILE = "market-data.csv";
    private static String CVS_SPLIT_BY = ",";

    public List<Lender> readAndParseFile(String filename) {
        List<Lender> lenders = new ArrayList<>();
        String line;
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                i++;
                if (i==1) continue;
                // use comma as separator
                String[] lenderStr = line.split(CVS_SPLIT_BY);
                lenders.add(getLender(lenderStr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lenders;
    }

    private Lender getLender(String[] str) {
        float rate = 0;
        long available = 0;
        try {
            rate = Float.parseFloat(str[1]);
            available = Long.parseLong(str[2]);
        } catch (NumberFormatException e) {
            // TODO another option would be to consume the exception and log it as an error, then continue
            throw new IllegalArgumentException("Unable parse the row: " + String.join(",", str));
        }
        System.out.println("Parsed the row: " + Arrays.stream(str).collect(Collectors.joining(",")));
        return new Lender(str[0], rate, available);
    }
}
