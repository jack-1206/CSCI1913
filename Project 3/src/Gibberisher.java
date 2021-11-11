//Ruide Xie

/**
 * Gibberisher class
 */
public class Gibberisher {
    private Trie<CharBag> model;
    private int segmenLength, processed;

    /**
     * constructor
     * @param segmenLlength
     */
    public Gibberisher(int segmenLlength){
        this.segmenLength = segmenLlength;
        model = new Trie<>();
        processed = 0;
    }

    /**
     * training single lettersample
     * @param letterSample
     */
    public void train(LetterSample letterSample){
        String segment = letterSample.getSegment();
        if (model.get(segment) == null){
            model.put(segment, new CharBag());
        }
        model.get(segment).add(letterSample.getNextLetter());
        processed++;
    }

    /**
     * training string segment
     * @param segment
     */
    public void train(String segment){
        LetterSample[] letterSample = LetterSample.toSamples(segment, segmenLength);
        for (int i = 0; i < letterSample.length; i++) {
            train(letterSample[i]);
        }
    }

    /**
     * training each element in string array
     * @param word
     */
    public void train(String[] word){
        for (int i = 0; i < word.length; i++) {
            train(word[i]);
        }
    }

    /**
     * get the number of samples used so far to train the model.
     * @return
     */
    public int getSampleCount(){
        return processed;
    }

    /**
     * generating pronounceable word if long segment length and vice versa
     * @return
     */
    public String generate() {
        String word = "";
        while (notPeriod(word)) {
            String sample;
            if (word.length() < segmenLength) {
                sample = word;
            } else {
                sample = word.substring(word.length() - segmenLength);
            }
            CharBag bag = model.get(sample);
            char c = bag.getRandomChar();
            word += c;
        }
        return word.substring(0, word.length()-1);
    }

    /**
     * helper function to check if last letter is period
     * @param str
     * @return
     */
    public boolean notPeriod(String str){
        if (str.length()==0){
            return true;
        }else {
            return str.charAt(str.length() - 1) != LetterSample.STOP();
        }
    }
}
