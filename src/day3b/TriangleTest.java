package day3b;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void validTriangle() {
		Triangle t = new Triangle();
		assertEquals(true, t.isTriangle("5 7 10"));
	}

	@Test
	public void invalidTriangle() {
		Triangle t = new Triangle();
		assertEquals(false, t.isTriangle("5 10 25"));
	}
	
	@Test
	public void validTriangleSidesDescending() {
		Triangle t = new Triangle();
		assertEquals(true, t.isTriangle("10 7 5"));
	}
	
	@Test
	public void invalidTriangleSidesDescending() {
		Triangle t = new Triangle();
		assertEquals(false, t.isTriangle("25 10 5"));
	}

}
