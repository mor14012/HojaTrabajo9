import java.util.Map;
import java.util.TreeMap;

/* Implementacion Tree Map  usando JCF*/

public class TreeMapp implements WordSet {
    Map<String,Word> treeMap;
    
        public TreeMapp(){
           treeMap = new TreeMap<String,Word>();
        }
    
    
	public void add(Word wordObject){
          String word = wordObject.getWord();
          treeMap.put(word, wordObject); //agrega objeto al arbol
        }
        
    public Word get(Word word){
          Word returnn = treeMap.get(word.getWord());
          return returnn; //retorna el objeto si se tiene o null
        }
    }
	