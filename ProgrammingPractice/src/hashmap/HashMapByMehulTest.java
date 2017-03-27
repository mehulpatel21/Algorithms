package hashmap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashMapByMehulTest {
	private HashMapByMehul hashMapByMehul;
	private final int NUM_ELEMENTS = 200000;
	
	@Before
	public void setUp(){
		hashMapByMehul = new HashMapByMehul();
	}
	
	@Test
	public void testHashMapPut(){
		hashMapByMehul.put("Test1", "TestValue");
	}
	
	@Test
	public void testPutGet(){
		String k = "TestPutGet";
		String v = "TestPutGetValue";
		hashMapByMehul.put(k, v);
		String valueResult = hashMapByMehul.get(k);
		assertEquals(v, valueResult);
	}
	
	@Test
	public void testHashMapCollision(){
		// Initialize hashmap
		for(int i=0; i<NUM_ELEMENTS; i++){
			hashMapByMehul.put(Integer.toString(i), Integer.toString(i));
		}
		
		// Test all values of get method
		for(int i=0; i<NUM_ELEMENTS; i++){
			String value = hashMapByMehul.get(Integer.toString(i));
			assertEquals(Integer.toString(i), value);
		}
	}
	
	@After
	public void tearDown(){
		hashMapByMehul = null;
	}
}
