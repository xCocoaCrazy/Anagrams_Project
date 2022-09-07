package md.rosca.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//Class that reads the words from a file
public class FileReaderImpl {
    private final String fileName;

    public FileReaderImpl(String fileName) {
        this.fileName = fileName;
    }

    //Method that gets the words from the file and
    //returns an ArrayList with all the words
    public List<String> getWords() {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/" + fileName))))
        {
            String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            String[] strSplit = contents.split("\n");
            words = new ArrayList<>(Arrays.asList(strSplit));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
