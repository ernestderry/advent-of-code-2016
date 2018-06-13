package day8;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestScreen {

	@Test
	public void newScreenSize1() {
		
		Screen screen = new day8.Screen(1,1);
		assertEquals(".", screen.print());		
	}

	@Test
	public void newScreenSize3x2() {
		
		Screen screen = new day8.Screen(3,2);
		assertEquals(".../...", screen.print());		
	}
	
	@Test
	public void rect1x1() {
		Screen screen = new day8.Screen(3,2);
		screen.rect(1,1);
		assertEquals("#../...", screen.print());
	}

	@Test
	public void rect3x2() {
		Screen screen = new day8.Screen(4,3);
		screen.rect(3,2);
		assertEquals("###./###./....", screen.print());
	}

	@Test
	public void rect3x2fillsScreen() {
		Screen screen = new day8.Screen(3,2);
		screen.rect(3,2);
		assertEquals("###/###", screen.print());
	}

	@Test
	public void rotateColumn1by1() {
		Screen screen = new day8.Screen(7, 3);
		screen.rect(3,2);
		screen.rotateColumn(1,1);
		assertEquals("#.#..../###..../.#.....", screen.print());
	}

	@Test
	public void rotateColumn1by2() {
		Screen screen = new day8.Screen(7, 3);
		screen.rect(3,2);
		screen.rotateColumn(1,2);
		assertEquals("###..../#.#..../.#.....", screen.print());
	}
	
	@Test
	public void rotateColumn1byMoreThanFullRotationOfColumn() {
		Screen screen = new day8.Screen(7, 3);
		screen.rect(3,2);
		screen.rotateColumn(1,5);
		assertEquals("###..../#.#..../.#.....", screen.print());
	}

	@Test
	public void rotateColumn2() {
		Screen screen = new day8.Screen(7, 3);
		screen.rect(3,2);
		screen.rotateColumn(2,5);
		assertEquals("###..../##...../..#....", screen.print());
	}
	
	@Test
	public void rotateRow1by1() {
		Screen screen = new day8.Screen(7, 3);
		screen.rect(3,2);
		screen.rotateRow(1,1);
		assertEquals("###..../.###.../.......", screen.print());
	}
	
	@Test
	public void rotateRow1ToCauseWrapAround() {
		Screen screen = new day8.Screen(7, 3);
		screen.rect(3,2);
		screen.rotateRow(1,6);
		assertEquals("###..../##....#/.......", screen.print());
	}
	
	@Test
	public void rotateRow1byMoreThanFullRotation() {
		Screen screen = new day8.Screen(7, 3);
		screen.rect(3,2);
		screen.rotateRow(1,9);
		assertEquals("###..../..###../.......", screen.print());
	}	
	
	public void rectangleHasCorrectNumberOfPixels() {
		Screen screen = new day8.Screen(7, 3);
		screen.rect(3,2);
		assertEquals(6, screen.numberOfpixelsOn());
	}
	
	public void rectangleHasCorrectNumberOfPixelsAfterRotation() {
		Screen screen = new day8.Screen(7, 3);
		screen.rect(4,2);
		screen.rotateRow(1, 7);
		screen.rotateColumn(2, 3);
		screen.rotateRow(2, 4);
		screen.rotateColumn(3, 17);
		
		assertEquals(8, screen.numberOfpixelsOn());
	}

}
