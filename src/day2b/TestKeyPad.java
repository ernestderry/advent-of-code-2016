package day2b;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestKeyPad {
	
	KeyPad kp;
	
	@Before
	public void setUp() {
		kp = new KeyPad(3, 3);
	}

	@Test
	public void upOneSpaceFromMiddle() {	
		assertEquals('3', kp.calcButton("U"));
	}

	@Test
	public void downOneSpaceFromMiddle() {		
		assertEquals('B', kp.calcButton("D"));
	}

	@Test
	public void leftOneSpaceFromMiddle() {		
		assertEquals('6', kp.calcButton("L"));
	}
	
	@Test
	public void rightOneSpaceFromMiddle() {		
		assertEquals('8', kp.calcButton("R"));
	}

	@Test
	public void upAndLeftFromMiddle() {		
		assertEquals('2', kp.calcButton("UL"));
	}

	@Test
	public void upAndMoveAroundEntireKeyPad() {		
		assertEquals('B', kp.calcButton("UUDLDLRDRDURURLULDD"));
	}
	
	@Test
	public void upThreeTimesFromMiddleDoesNotCrash() {		
		assertEquals('1', kp.calcButton("UUU"));
	}
	
	@Test
	public void leftThreeTimesFromMiddleDoesNotCrash() {		
		assertEquals('5', kp.calcButton("LLL"));
	}

	@Test
	public void rightThreeTimesFromMiddleDoesNotCrash() {		
		assertEquals('9', kp.calcButton("RRR"));
	}

	@Test
	public void downThreeTimesFromMiddleDoesNotCrash() {		
		assertEquals('D', kp.calcButton("DDD"));
	}
	
	@Test
	public void moveFromDefaultStartToBottom() {	
		KeyPad kp = new KeyPad(1, 3);
		assertEquals('D', kp.calcButton("RDRD"));
	}

	@Test
	public void moveTwiceKeepingNoteOfPositionBetweenMoves() {	
		assertEquals('6', kp.calcButton("L"));
		assertEquals('2', kp.calcButton("U"));
	}
	
	
}
