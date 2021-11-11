//Ruide Xie

/**
 * TrieNode<T> class
 * @param <T>
 */
public class TrieNode<T> {
    private T data;
    private TrieNode<T>[] childarray;

    /**
     * constructor
     */
    public TrieNode(){
        data = null;
        childarray =new TrieNode[26];
    }

    /**
     * return data of the node
     * @return
     */
    public T getData(){
        return data;
    }

    /**
     * setting data of the node
     * @param data
     */
    public void setData(T data){
        this.data = data;
    }

    /**
     * returns the TrieNode<T> associated with the given letter
     * @param letter
     * @return
     */
    public TrieNode<T> getChild(char letter){
        int i = letter-97;
        if (!Character.isLowerCase(letter)){
            return null;
        }else if (childarray[i] == null){
            TrieNode<T> newNode = new TrieNode<>();
            childarray[i] = newNode;
            return newNode;
        } else{
            return childarray[i];
        }
    }

    /**
     * return the number of nodes in the tree
     * @return
     */
    public int getTreeSize(){
        int size = 0;
        for (int i = 0; i < childarray.length; i++) {
            if(childarray[i] != null){
                size += childarray[i].getTreeSize();
            }
        }
        return size + 1;
    }
}
