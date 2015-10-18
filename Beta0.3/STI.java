import java.util.*;

public class  STI implements WordSet{
      
	private SplayTree<Word> base;

        
	public STI (){
	base = new SplayTree<Word>();
	}
        
        
		
	//Metodos necesario para el funcionamiento 
	public Word get(Word word){
		return base.get(word);
	}
	
	public void add(Word wordObject){
		base.add(wordObject);
	}
}




