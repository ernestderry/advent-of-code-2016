package day5b;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHashGenerator {

	@Test
	public void generatesValidMD5HashWithLeadingZeros() {
		
		HashGenerator hg = new HashGenerator();
		assertEquals("00000155f8105dff7f56ee10fa9b9abd", hg.genHash("abc3231929"));
	}

}
