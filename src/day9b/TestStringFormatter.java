package day9b;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringFormatter {

	@Test
	public void stringWithNoMarkers() {
		assertEquals(6, StringFormatter.decompressedLength("ADVENT"));
	}

	@Test
	public void stringWithWhiteSpaceIgnoresWhiteSpaceMarkers() {
		assertEquals(6, StringFormatter.decompressedLength("A\n\rDV ENT"));
	}
	
	@Test
	public void compressionOfSingleCharacterLessThan10Times() {
		assertEquals(7, StringFormatter.decompressedLength("A(1x5)BC"));
	}

	@Test
	public void compressionOfTwoCharactersLessThan10Times() {
		assertEquals(12, StringFormatter.decompressedLength("A(2x5)BCD"));
	}

	@Test
	public void compressionOfTenCharactersLessThan10Times() {
		assertEquals(22, StringFormatter.decompressedLength("A(10x2)BCDEFGHIJKL"));
	}

	@Test
	public void compressionOfTwoCharactersMoreThan10Times() {
		assertEquals(27, StringFormatter.decompressedLength("A(2x12)BCDE"));
	}
		
	@Test
	public void moreThanOneCompression() {
		assertEquals(11, StringFormatter.decompressedLength("A(2x2)BCD(2x2)EFG"));
	}
	
	@Test
	public void compressionSequenceInsideAnotherCompression() {
		assertEquals(20, StringFormatter.decompressedLength("X(8x2)(3x3)ABCY"));
	}

	@Test
	public void multipleCompression2() {
		assertEquals(241920, StringFormatter.decompressedLength("(27x12)(20x12)(13x14)(7x10)(1x12)A"));
	}

	@Test
	public void multipleCompression3() {
		assertEquals(445, StringFormatter.decompressedLength("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"));
	}
	
}
