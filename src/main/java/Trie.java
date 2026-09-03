import java.util.HashSet;

public class Trie {
    Node root = new Node();
    int length = 1;
    private static class Node{
        Node[] children;
        boolean endOfWord;
        Node(){
            this.children = new Node[26];
            for(int i=0;i<26;i++){
                this.children[i] = null;
            }
            this.endOfWord = false;
        }


    }
    public void insert(String[] words,Node root){
        for(String word: words) {
            Node cur = root;
            for(int i = 0; i<word.length();i++){
                int idx = word.charAt(i) - 'a';
                if(cur.children[idx] == null){
                    cur.children[idx] = new Node();
                    length++;
                }
                if(i == word.length()-1){
                    cur.children[idx].endOfWord = true;
                }
                cur = cur.children[idx];
            }
        }
    }

    public boolean search(String word, Node root){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null){
                return false;
            }
            else{
                cur = cur.children[idx];
            }
        }
        return cur.endOfWord;
    }

    public boolean searchparts(String str,Node root){

        for(int i=0;i<str.length();i++){
            String str2 = str.substring(i+1);
            boolean res = search(str2,root);
            if(res){
                return res;
            }
        }
        return false;
    }

    public boolean startsWith(String str,Node root){
        Node cur = root;

        for(int i=0;i<str.length();i++){
            int idx = str.charAt(i) - 'a';
            if(cur.children[idx] == null){
                return false;
            }
            else{
                cur = cur.children[idx];
            }
        }
        return true;
    }


    public int noOfsub(String st){
        String[] suffix = new String[st.length()];
        for(int i=0;i<st.length();i++){
            suffix[i] = st.substring(i);
        }
        insert(suffix,this.root);
        return this.length;
    }

    public String longestPrefix(Node cur, StringBuilder temp){
        String ans = "";

        for(int i = 0; i < 26; i++){
            if(cur.children[i] != null && cur.children[i].endOfWord){

                temp.append((char)(i + 'a'));

                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }

                String result = longestPrefix(cur.children[i], temp);

                if(result.length() > ans.length()){
                    ans = result;
                }

                temp.deleteCharAt(temp.length() - 1);
            }
        }

        return ans;
    }

    public void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any"};
        Trie trie = new Trie();
        String[] dict = {"i", "like", "sam", "samsung", "mobile", "ice"};
        Trie trie2 = new Trie();
        String sub = "apple";
        Trie trie3 = new Trie();
        String[] word = {"a","ap","app","appl","apple","apply","memory"};
        Trie trie4 = new Trie();



        insert(word,trie4.root);
        String ans = trie4.longestPrefix(trie4.root,new StringBuilder(""));

        System.out.println(ans);
        trie.insert(words, trie.root);
        trie2.insert(dict, trie2.root);

//        int no = trie3.noOfsub(sub);
//        System.out.println(no);


//        System.out.println(searchparts("ilikesomething",trie2.root));
//        System.out.println(startsWith("more",trie2.root));
   }
}
