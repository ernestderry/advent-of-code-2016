package day7;

import static org.junit.Assert.*;

import org.junit.Test;

public class TLSTest {

	@Test
	public void emptyStringisNotTLS() {
		assertFalse(TLS.isTLS(""));
	}

	@Test
	public void nullIsNotTLS() {
		assertFalse(TLS.isTLS(null));
	}
	
	@Test
	public void TLSStringisTLS() {
		assertTrue(TLS.isTLS("abba"));
	}

	@Test
	public void threeCharStringisNotTLS() {
		assertFalse(TLS.isTLS("aba"));
	}

	@Test
	public void twoCharStringisNotTLS() {
		assertFalse(TLS.isTLS("aa"));
	}
	
	@Test
	public void nonReversibleFourCharStringIsNotTLS() {
		assertFalse(TLS.isTLS("abcd"));
	}

	@Test
	public void reversibleFourCharStringIsAtStartOfString() {
		assertTrue(TLS.isTLS("abbae"));
	}

	@Test
	public void reversibleFourCharStringIsAtEndOfString() {
		assertTrue(TLS.isTLS("fabba"));
	}

	@Test
	public void reversibleFourCharStringIsInMiddleOfString() {
		assertTrue(TLS.isTLS("fqeroiuyabbadhlashdf"));
	}

	@Test
	public void reversibleStringInsideBracketsIsNotTLS() {
		assertFalse(TLS.isTLS("[abba]"));
	}

	@Test
	public void reversibleStringOutsideBracketsIsTLS() {
		assertTrue(TLS.isTLS("[dkzq]abba"));
	}

	@Test
	public void reversibleStringAfterBracketsIsNotTLSIfOneExistInBrackets() {
		assertFalse(TLS.isTLS("[dkkd]abba"));
	}
	
	@Test
	public void reversibleStringBeforeBracketsIsNotTLSIfOneExistInBrackets() {
		assertFalse(TLS.isTLS("abba[dkkd]"));
	}

	@Test
	public void reversibleStringBothSidesOfBracketsIsNotTLSIfOneExistInBrackets() {
		assertFalse(TLS.isTLS("abba[dkkd]zyyz"));
	}
	
	@Test
	public void fourEqualCharactersAreNotTLS() {
		assertFalse(TLS.isTLS("aaaa"));
	}
	
}
