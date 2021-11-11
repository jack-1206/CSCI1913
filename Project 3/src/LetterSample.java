//Ruide Xie

/**
 * LetterSample class
 */
public class LetterSample {
    private String segment;
    private char letter;
    public static final char STOP = '.';

    /**
     * Constructor
     * @param segment segment
     * @param letter letter
     */
    public LetterSample(String segment, char letter){
        this.segment = segment;
        this.letter = letter;
    }

    /**
     * getter for segment
     * @return segment
     */
    public String getSegment(){
        return segment;
    }

    /**
     * to print from main
     * @return String
     */
    @Override
    public String toString() {
        return '"' + segment + '"' + " -> " + letter;
    }

    /**
     * getter for next letter
     * @return letter
     */
    public char getNextLetter(){
        return letter;
    }

    /**
     * period char
     * @return STOP
     */
    public static char STOP(){
        return STOP;
    }

    /**
     * representing a part of a word, and the letter that follows it.
     * @param input text string
     * @param segmentSize max length of segment
     * @return LetterSample array object
     */
    public static LetterSample[] toSamples(String input, int segmentSize){
        input = input.toLowerCase();
        String str = "";
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))){
                str += input.charAt(i);
            }
        }
        str += STOP;
        LetterSample[] arr = new LetterSample[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i]= new LetterSample("",' '); //default
            if (i==0){
                arr[i].segment = "";
            }else {
                if (i <= segmentSize){
                    arr[i].segment = str.substring(0, i);
                }else {
                    arr[i].segment = str.substring(i-segmentSize, i);
                }
            }
            arr[i].letter = str.charAt(i);
        }
        return arr;
    }
}
