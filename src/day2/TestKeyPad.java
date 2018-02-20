package day2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestKeyPad {
	
	KeyPad kp;
	
	@Before
	public void setUp() {
		kp = new KeyPad();
	}

	@Test
	public void upOneSpaceFromMiddle() {	
		assertEquals(2, kp.calcButton("U"));
	}

	@Test
	public void downOneSpaceFromMiddle() {		
		assertEquals(8, kp.calcButton("D"));
	}

	@Test
	public void leftOneSpaceFromMiddle() {		
		assertEquals(4, kp.calcButton("L"));
	}
	
	@Test
	public void rightOneSpaceFromMiddle() {		
		assertEquals(6, kp.calcButton("R"));
	}

	@Test
	public void upAndLeftFromMiddle() {		
		assertEquals(1, kp.calcButton("UL"));
	}

	@Test
	public void upAndMoveManyTimes() {		
		assertEquals(8, kp.calcButton("ULDDRRUULLDRRDLLUURDD"));
	}
	
	@Test
	public void upTwiceFromMiddleDoesNotCrash() {		
		assertEquals(2, kp.calcButton("UU"));
	}
	
	@Test
	public void leftTwiceFromMiddleDoesNotCrash() {		
		assertEquals(4, kp.calcButton("LL"));
	}

	@Test
	public void rightTwiceFromMiddleDoesNotCrash() {		
		assertEquals(4, kp.calcButton("LL"));
	}

	@Test
	public void downTwiceFromMiddleDoesNotCrash() {		
		assertEquals(4, kp.calcButton("LL"));
	}
	
	@Test
	public void moveFromTopLeftToBottomRight() {	
		KeyPad kp = new KeyPad(0, 0);
		assertEquals(5, kp.calcButton("RD"));
	}

	@Test
	public void moveTwiceKeepingNoteOfPositionBetweenMoves() {	
		assertEquals(4, kp.calcButton("L"));
		assertEquals(1, kp.calcButton("U"));
	}
	
	
}
