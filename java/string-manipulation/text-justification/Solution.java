class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> justifiedText = new ArrayList();
        StringBuilder sentence = new StringBuilder();
        int sentenceLength = 0;
        
        for(int i = 0; i < words.length ; i++) {
            if((sentenceLength + words[i].length() - 1) < maxWidth){
                sentence.append(words[i] + " ");
                sentenceLength = sentenceLength + words[i].length() +1;
            } else {
                justifiedText.add(justifySentence(sentence, maxWidth, false));
                sentenceLength = 0;
                sentence.setLength(0);
                i--;
            }
            
            if(i == (words.length-1))
                justifiedText.add(justifySentence(sentence, maxWidth, true));
        }
        return justifiedText;
        
    }
    
    String justifySentence(StringBuilder sb, int maxWidth, Boolean lastLine){
        StringBuilder finalSentence = new StringBuilder();
        
        String[] words = sb.toString().trim().split(" ");
        int wordCount = words.length;
        int totalSpaceToAdd = maxWidth - sb.toString().replaceAll(" ", "").length();
        
        if(wordCount > 1){
            int spaceBracket = totalSpaceToAdd / (wordCount-1);
            int remainderSpaces = totalSpaceToAdd % (wordCount-1);
            
            if(!lastLine){
                for(int i = 0; i< words.length; i++){  
                    if(remainderSpaces > 0){
                        finalSentence.append(words[i]+getNSpaces(spaceBracket)+" ");
                        remainderSpaces--;
                    } else{
                        finalSentence.append(words[i]+getNSpaces(spaceBracket));
                    }
                }
                return finalSentence.toString().trim();  
            } else {
                for(int i = 0; i< words.length; i++)
                    finalSentence.append(words[i]+" ");
                
                remainderSpaces = (maxWidth - 1 - finalSentence.toString().trim().length()) <= 0 ? 0 : (maxWidth - 1 - finalSentence.toString().trim().length());
                if(finalSentence.append(getNSpaces(remainderSpaces)).toString().trim().length() == maxWidth){
                    return finalSentence.toString().trim();
                }
                return finalSentence.toString();
            }
            
        } else{
            finalSentence.append(words[0]+getNSpaces(totalSpaceToAdd));
            return finalSentence.toString();
        }
        
    }
    
    String getNSpaces(int n){
        char[] repeat = new char[n];
        Arrays.fill(repeat, ' ');
        return new String(repeat);
    }
}