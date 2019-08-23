package validator;

public class ChoiceValidator {
    private static final String NUMBERS_REGEX = "\\s*[a-c](\\s+|-)*[1-3]\\s*";

    public boolean checkLine(String line){
        return line.matches(NUMBERS_REGEX);
    }
}
