import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUNIT {
	private SimpleSet p1;
	private RedBlackTreeSet p2;
	private STI p3;
	private Hashtable p4;
	private TreeMapp p5;
	private Word w;
	
	@Before
	public void start()
	{
		w = new Word("inteligente","adjetivo");
		p1 = new SimpleSet(); 
		p2 = new RedBlackTreeSet(); 
		p3 = new STI(); 
		p4 = new Hashtable(); 
		p5 = new TreeMapp(); 
		
		p1.add(w);
		p2.add(w);
		p3.add(w);
		p4.add(w);
		p5.add(w);
	}
	@Test
	public void test1() throws Exception {
		assertTrue(p1.get(w).equals(w));
	}
	@Test
	public void test2() throws Exception {
		assertTrue(p2.get(w).equals(w));
	}
	@Test
	public void test3() throws Exception {
		assertTrue(p1.get(w).equals(w));
	}
	@Test
	public void test4() throws Exception {
		assertTrue(p1.get(w).equals(w));
	}
	@Test
	public void test5() throws Exception {
		assertTrue(p1.get(w).equals(w));
	}

}
