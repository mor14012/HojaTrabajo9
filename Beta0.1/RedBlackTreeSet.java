class RedBlackTreeSet implements WordSet{
	
	private RedBlackTree<Word> RBT;
	
	public RedBlackTreeSet(){
		RBT = new RedBlackTree<Word>();
	}
	
	public Word get(Word word){
		RedBlackNode<Word> value =  RBT.search(word);
		if(value != null)
			return value.getKey();
		return null;
	}
	
	public void add(Word wordObject){
		RBT.insert(wordObject);
	}
}
