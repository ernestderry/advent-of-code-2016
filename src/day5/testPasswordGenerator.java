package day5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class testPasswordGenerator {

	@Test
	public void firstCharOfPasswordIs6thCharOf0CountHash() {
		String doorId = "abc";
		int passwordLength = 1;
		
		HashGenerator hgMock = Mockito.mock(HashGenerator.class);
		Mockito.when(hgMock.genHash("abc0")).thenReturn("00000123456789");
		
		PasswordGenerator pg = new PasswordGenerator(hgMock);
		
		assertEquals("1", pg.generatePassword(doorId, passwordLength));
	}

	@Test
	public void firstCharOfPasswordIs6thCharOfFirstHashWith5Zeros() {
		String doorId = "abc";
		int passwordLength = 1;
		
		HashGenerator hgMock = Mockito.mock(HashGenerator.class);
		Mockito.when(hgMock.genHash("abc0")).thenReturn("66666123456789");
		Mockito.when(hgMock.genHash("abc1")).thenReturn("66666123456789");
		Mockito.when(hgMock.genHash("abc2")).thenReturn("00000987654321");
		
		PasswordGenerator pg = new PasswordGenerator(hgMock);
		
		assertEquals("9", pg.generatePassword(doorId, passwordLength));
	}

	@Test
	public void passwordBuiltFromZeroHashesUntilLengthReached() {
		String doorId = "abc";
		int passwordLength = 4;
		
		HashGenerator hgMock = Mockito.mock(HashGenerator.class);
		Mockito.when(hgMock.genHash("abc0")).thenReturn("66666123456789");
		Mockito.when(hgMock.genHash("abc1")).thenReturn("66666123456789");
		Mockito.when(hgMock.genHash("abc2")).thenReturn("00000987654321");
		Mockito.when(hgMock.genHash("abc3")).thenReturn("66666123456789");
		Mockito.when(hgMock.genHash("abc4")).thenReturn("66666123456789");
		Mockito.when(hgMock.genHash("abc5")).thenReturn("00000456456456");
		Mockito.when(hgMock.genHash("abc6")).thenReturn("88888123456789");
		Mockito.when(hgMock.genHash("abc7")).thenReturn("88888123456789");
		Mockito.when(hgMock.genHash("abc8")).thenReturn("00000345345345");
		Mockito.when(hgMock.genHash("abc9")).thenReturn("88888123456789");
		Mockito.when(hgMock.genHash("abc10")).thenReturn("88888123456789");
		Mockito.when(hgMock.genHash("abc11")).thenReturn("00000045345345");
		PasswordGenerator pg = new PasswordGenerator(hgMock);
		
		assertEquals("9430", pg.generatePassword(doorId, passwordLength));
	}
	
}
