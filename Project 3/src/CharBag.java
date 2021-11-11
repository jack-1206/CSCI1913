//Ruide Xie

import java.util.Random;
/**
 * CharBag class
 */
public class CharBag {
    private int size = 0;
    private char[] bag;

    /**
     * constructor
     */
    public CharBag(){
        bag = new char[0];
    }

    /**
     * to make sure that the alphabet is lowercase or "." if not an alphabet
     * @param letter
     * @return letter
     */
    public char cleanup(char letter){
        letter = Character.toLowerCase(letter);
        if(!Character.isAlphabetic(letter)){
            letter = LetterSample.STOP;
        }
        return letter;
    }

    /**
     * to add element into the charbag
     * @param letter
     */
    public void add(char letter){
        letter = cleanup(letter);
        char[] arr = new char[size+1];
        for (int i = 0; i < bag.length; i++) {
            arr[i] = bag[i];
        }
        arr[size] = letter;
        bag = arr;
        size++;
    }

    /**
     * to remove element from charbag
     * @param letter
     */
    public void remove(char letter){
        letter = cleanup(letter);
        int num = 0, a = 0;
        for (int i = 0; i < bag.length; i++) {
            if (bag[i] == letter) {
                num++;
                a = i;
                size--;
                break;
            }
        }
        char[] arr = new char[size];
        if (num > 0){
            for (int i = 0; i < a; i++) {
                arr[i] = bag[i];
            }
            for (int i = a; i < arr.length; i++) {
                arr[i] = bag[i+1];
            }
        }else{
            return;
        }
        bag = arr;
    }

    /**
     * to return the size of charbag
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * to count how many times a given char is in charBag
     * @param letter
     * @return count
     */
    public int getCount(char letter){
        letter = cleanup(letter);
        int count = 0;
        for (int i = 0; i < bag.length; i++) {
            if (bag[i] == letter){
                count++;
            }
        }
        return count;
    }

    /**
     * to print from main
     * @return amended string
     */
    @Override
    public String toString(){
        String str = "";
        for (char i = 'a'; i <= 'z'; i++) {
            str += i + ":" + getCount(i) + ", ";
        }
        str += ".:" + getCount(LetterSample.STOP);
        return "CharBag{" + str + "}";
    }

    /**
     * get random char from charbag
     * @return letter
     */
    public char getRandomChar(){
        if (size == 0){
            return LetterSample.STOP();
        }else{
            Random rand = new Random();
            int count = rand.nextInt(getSize());
            for(char i = 'a'; i<= 'z'; i++){
                count -= getCount(i);
                if (count < 0){
                    return i;
                }
            }
            return LetterSample.STOP();
        }
    }
}



