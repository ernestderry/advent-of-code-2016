package day9;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringFormatter {

	@Test
	public void stringWithNoMarkers() {
		assertEquals("ADVENT", StringFormatter.decompress("ADVENT"));
	}

	@Test
	public void stringWithWhiteSpaceIgnoresWhiteSpaceMarkers() {
		assertEquals("ADVENT", StringFormatter.decompress("A\n\rDV ENT"));
	}
	
	@Test
	public void compressionOfSingleCharacterLessThan10Times() {
		assertEquals("ABBBBBC", StringFormatter.decompress("A(1x5)BC"));
	}

	@Test
	public void compressionOfTwoCharactersLessThan10Times() {
		assertEquals("ABCBCBCBCBCD", StringFormatter.decompress("A(2x5)BCD"));
	}

	@Test
	public void compressionOfTenCharactersLessThan10Times() {
		assertEquals("ABCDEFGHIJKBCDEFGHIJKL", StringFormatter.decompress("A(10x2)BCDEFGHIJKL"));
	}

	@Test
	public void compressionOfTwoCharactersMoreThan10Times() {
		assertEquals("ABCBCBCBCBCBCBCBCBCBCBCBCDE", StringFormatter.decompress("A(2x12)BCDE"));
	}
	
	@Test
	public void moreThanOneCompression() {
		assertEquals("ABCBCDEFEFG", StringFormatter.decompress("A(2x2)BCD(2x2)EFG"));
	}
	
	@Test
	public void compressionSequenceInsideAnotherCompression() {
		assertEquals("(1x3)A", StringFormatter.decompress("(6x1)(1x3)A"));
	}
	
	@Test
	public void multipleCompression2() {
		assertEquals("X(3x3)ABC(3x3)ABCY", StringFormatter.decompress("X(8x2)(3x3)ABCY"));
	}
	
}
