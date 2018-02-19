package day1b;

import static org.junit.Assert.*;

import org.junit.Test;

import day1b.TaxiCab;

public class TestTaxiCab {

	@Test
	public void moveLeft() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("L2");
		assertEquals(2, taxi.distance());
	}

	@Test
	public void moveRight() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("R3");
		assertEquals(3, taxi.distance());
	}
	
	@Test
	public void moveRightTwice() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("R2");
		taxi.drive("R3");
		assertEquals(5, taxi.distance());
	}
	
	@Test
	public void moveRightThreeTimes() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("R2");
		taxi.drive("R3");
		taxi.drive("R1");
		assertEquals(4, taxi.distance());
	}

	@Test
	public void moveRightInACircle() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("R2");
		taxi.drive("R2");
		taxi.drive("R2");
		taxi.drive("R2");
		assertEquals(0, taxi.distance());
	}
	
	@Test
	public void moveLeftTwice() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("L2");
		taxi.drive("L3");
		assertEquals(5, taxi.distance());
	}
	
	@Test
	public void moveLeftThreeTimes() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("L2");
		taxi.drive("L3");
		taxi.drive("L1");
		assertEquals(4, taxi.distance());
	}

	@Test
	public void moveLeftInACircle() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("L2");
		taxi.drive("L2");
		taxi.drive("L2");
		taxi.drive("L2");
		assertEquals(0, taxi.distance());
	}
	
	@Test
	public void mixRightAndLeft() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("R2");
		taxi.drive("R2");
		taxi.drive("L2");
		taxi.drive("L2");
		assertEquals(4, taxi.distance());
	}
	
	@Test
	public void doNotVisitALocationTwice() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("R3");
		assertEquals(-1, taxi.distanceToFirstLocationVisitedTwice());
	}
	
	@Test
	public void distanceToFirstLocationVisitedTwice() {
		TaxiCab taxi = new TaxiCab();
		taxi.drive("R8");
		taxi.drive("R4");
		taxi.drive("R4");
		taxi.drive("R8");
		assertEquals(4, taxi.distanceToFirstLocationVisitedTwice());
	}

}
