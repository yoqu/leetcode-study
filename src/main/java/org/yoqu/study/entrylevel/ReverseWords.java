package org.yoqu.study.entrylevel;

public class ReverseWords {
    public static void main(String[] args) {

    }
    public String reverseWords(String s) {
        String[] words= s.split(" ");
        StringBuilder newwords =new StringBuilder();
        for(int i=0;i<words.length;i++){
            newwords.append(reverse(words[i]));
            if(i<words.length-1){
                newwords.append(" ");
            }
        }
        return newwords.toString();
    }

    private String reverse(String word){
        StringBuilder newWord = new StringBuilder();
        for(int i=word.length()-1;i>=0;i--){
            newWord.append(word.charAt(i));
        }
        return newWord.toString();
    }
}
