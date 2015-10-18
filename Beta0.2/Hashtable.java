import java.util.*;

public class Hashtable implements WordSet
{
	private final HashMap<String,Word> base;
	
	public Hashtable()
	{
		base = new HashMap<>();
	}

  @Override
	public Word get(Word word)
	{

		return base.get(word.getWord());
	}
	
  @Override
	public void add(Word wordObject)
	{
		base.put(wordObject.getWord(),wordObject);
               
	}
}
