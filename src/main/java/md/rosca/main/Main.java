package md.rosca.main;

import md.rosca.implementation.CheckAnagramsImpl;

public class Main {
    public static void main(String[] args){
        CheckAnagramsImpl anagrams = new CheckAnagramsImpl("words.txt");
        System.out.println(anagrams.getAnagrams());
    }

}
