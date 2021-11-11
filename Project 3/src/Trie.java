//Ruide Xie

/**
 * Trie class
 * @param <T>
 */
public class Trie<T> {
    private TrieNode<T> root;

    /**
     * constructor
     */
    public Trie() {
        root = new TrieNode<>();
    }

    /**
     * to return the node that matches the string
     * @param str
     * @return
     */
    private TrieNode<T> getNode(String str){
        TrieNode<T> returned = root;
        for (int i = 0; i < str.length(); i++) {
            returned = returned.getChild(str.charAt(i));
        }
        return returned;
    }

    /**
     * to get the data of a given node
     * @param str
     * @return
     */
    public T get(String str){
        TrieNode<T> node = getNode(str);
        return node.getData();
    }

    /**
     * to set data to an existing node
     * @param str
     * @param data
     */
    public void put(String str, T data){
        TrieNode<T> node = getNode(str);
        node.setData(data);
    }

    /**
     * to return the root
     * @return
     */
    public TrieNode<T> getRoot(){
        return root;
    }
}
