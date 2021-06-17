import java.io.*;
import java.lang.Math;

class Solution {
    public static void main (String[] args) {
        
        String s = "leet code will help in clearing interview for java developers at leet code";
        String w1 = "java";
        String w2 = "leet";
        
        int res = minimumDistance(s, w1, w2);
        System.out.println(res);
    }
    
    static int minimumDistance(String sentence, String word1, String word2){
        
        int minDistance = 0;
        int word1Position = -1;
        int word2Position = -1;
        
        String[] words = sentence.split(" ");
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1))
                word1Position = i;
                
            if(words[i].equals(word2))
                word2Position = i;
                
            if(word1Position != -1 && word2Position != -1 && (word2Position - word1Position) < minDistance)
                minDistance = Math.abs(word2Position - word1Position);
            
        }
        
        return minDistance;
        
    }
}