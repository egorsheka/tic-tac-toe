package parser;

public class LineParser {

    public int[] getDateFromLine(String string){
        int[] numbers = new int[2];
        char letter = string.charAt(0);
        switch (letter){
            case'a': numbers[0] = 0;
                break;
            case'b': numbers[0] = 1;
                break;
            case'c': numbers[0] = 2;
                break;
        }
       numbers[1] = Integer.parseInt(string.substring(1)) - 1;
        return numbers;
    }
}
