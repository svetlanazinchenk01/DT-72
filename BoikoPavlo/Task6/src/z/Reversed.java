package z;

public class Reversed {

    public String reverseString(String line){
        String word= line;
        char [] chars = word.toCharArray();
        for (int i=0; i<chars.length/2; i++){
            char tmp = chars[i];
            int index = chars.length - i -1  ;
            chars[i]=chars[index];
            chars[index]=tmp;
        }
        word=new String(chars);

        return word;

    }
}
