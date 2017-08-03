package cleverDevices;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyStackTest {
	@Test
	public void testSize(){
		MyStack<Integer> mystack = new MyStack<Integer>();
		assertTrue(mystack.size() == 0);
		
		mystack.push(21);
		assertEquals(1, mystack.size());
	}
	
	@Test
	public void testisEmpty(){
		MyStack<Integer> mystack = new MyStack<Integer>();
		assertTrue(mystack.size() == 0);
		
		mystack.push(21);
		assertFalse(mystack.isEmpty());
		
		mystack.pop();
		assertTrue(mystack.isEmpty());
	}
	
	@Test
	public void testPopAndPush(){
		MyStack<String> mystack = new MyStack<String>();
		assertEquals(0, mystack.size());
		
		mystack.push("Mehul");
		assertEquals(1, mystack.size());
		mystack.push("cd");
		assertEquals(2, mystack.size());
		
		assertEquals("cd", mystack.pop());
		assertEquals("Mehul", mystack.pop());
		assertEquals(0, mystack.size());
		
	}
}
