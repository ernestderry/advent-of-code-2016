package day7;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbbaTest {

	@Test
	public void emptyStringisNotAbba() {
		assertFalse(Abba.isAbba(""));
	}

	@Test
	public void nullIsNotAbba() {
		assertFalse(Abba.isAbba(null));
	}
	
	@Test
	public void abbaStringisAbba() {
		assertTrue(Abba.isAbba("abba"));
	}

	@Test
	public void threeCharStringisNotAbba() {
		assertFalse(Abba.isAbba("aba"));
	}

	@Test
	public void twoCharStringisNotAbba() {
		assertFalse(Abba.isAbba("aa"));
	}
	
	@Test
	public void nonReversibleFourCharStringIsNotAbba() {
		assertFalse(Abba.isAbba("abcd"));
	}

	@Test
	public void reversibleFourCharStringIsAtStartOfString() {
		assertTrue(Abba.isAbba("abbae"));
	}

	@Test
	public void reversibleFourCharStringIsAtEndOfString() {
		assertTrue(Abba.isAbba("fabba"));
	}

	@Test
	public void reversibleFourCharStringIsInMiddleOfString() {
		assertTrue(Abba.isAbba("fqeroiuyabbadhlashdf"));
	}

	@Test
	public void reversibleStringInsideBracketsIsNotAbba() {
		assertFalse(Abba.isAbba("[abba]"));
	}

	@Test
	public void reversibleStringOutsideBracketsIsAbba() {
		assertTrue(Abba.isAbba("[dkzq]abba"));
	}

	@Test
	public void reversibleStringAfterBracketsIsNotAbbaIfOneExistInBrackets() {
		assertFalse(Abba.isAbba("[dkkd]abba"));
	}
	
	@Test
	public void reversibleStringBeforeBracketsIsNotAbbaIfOneExistInBrackets() {
		assertFalse(Abba.isAbba("abba[dkkd]"));
	}

	@Test
	public void reversibleStringBothSidesOfBracketsIsNotAbbaIfOneExistInBrackets() {
		assertFalse(Abba.isAbba("abba[dkkd]zyyz"));
	}
	
	@Test
	public void fourEqualCharactersAreNotAbba() {
		assertFalse(Abba.isAbba("aaaa"));
	}
	
}
