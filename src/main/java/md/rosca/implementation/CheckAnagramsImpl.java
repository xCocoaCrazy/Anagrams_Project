package md.rosca.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class CheckAnagramsImpl {
    //LinkedHashMap with all the words as anagrams
    private final LinkedHashMap<String, ArrayList<String>> anagrams;
    //Words that are to be checked
    private final ArrayList<String> wordsToCheck;

    //Constructor
    public CheckAnagramsImpl(String fileName) {
        wordsToCheck = new ArrayList<>(new FileReaderImpl(fileName).getWords());
        anagrams = new LinkedHashMap<>();
    }


    protected CheckAnagramsImpl(List<String> wordsToCheck) {
        this.wordsToCheck = new ArrayList<>(wordsToCheck);
        anagrams = new LinkedHashMap<>();
    }

    //Runs through all the words and organizes them by keys
    //A key is the word and all it's letters in alphabetic order
    private void addKeys() {
        wordsToCheck.forEach(word -> {
            char[] tempWord = word.toLowerCase().toCharArray();
            Arrays.sort(tempWord);
            if(!anagrams.containsKey(String.valueOf(tempWord))) {
                anagrams.put(String.valueOf(tempWord), new ArrayList<>());
            }
        });
    }

    //Runs through all the words and organizes them by their corresponding key
    private void populateMapWithWords() {
        for (String word : wordsToCheck) {
            char[] tempChar = word.toLowerCase().toCharArray();
            sort(tempChar);
            String tempWord = String.valueOf(tempChar);
            if (anagrams.containsKey(tempWord)) {
                if (!anagrams.get(tempWord).contains(word)) {
                    anagrams.get(tempWord).add(word);
                }
            }
        }
    }

    //Prints the anagrams found
    private String printAnagrams() {
        StringBuilder finalWords = new StringBuilder();
        for (String key : anagrams.keySet()) {
            if(anagrams.get(key).size() >= 2) {
                for (String anagram : anagrams.get(key)) {
                    finalWords.append(anagram).append(" ");
                }
                finalWords.append("\n");
            }
        }
        return finalWords.toString();
    }

    //Public method for the user
    public String getAnagrams() {
        addKeys();
        populateMapWithWords();
        return printAnagrams();
    }

    //Heap Sort
    private static void sort(char arr[]) {
        int N = arr.length;

        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            char temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private static void heapify(char arr[], int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[largest])
            largest = l;

        if (r < N && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            char swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }
}
