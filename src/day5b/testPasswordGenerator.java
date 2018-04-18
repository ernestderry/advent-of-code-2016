package day5b;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class testPasswordGenerator {

	@Test
	public void first00000HashGeneratesCharacter0OfPasswordUsingChars5and6() {
		String doorId = "abc";
		int passwordLength = 1;
		
		HashGenerator hgMock = Mockito.mock(HashGenerator.class);
		Mockito.when(hgMock.genHash(Mockito.anyString())).thenReturn("00000"+"0123456789");
		
		PasswordGenerator pg = new PasswordGenerator(hgMock);
		
		assertEquals("1", pg.generatePassword(doorId, passwordLength));
	}
	
	@Test
	public void generate2charactersOfPassword() {
		String doorId = "abc";
		int passwordLength = 2;
		
		HashGenerator hgMock = Mockito.mock(HashGenerator.class);
		Mockito.when(hgMock.genHash(Mockito.anyString())).thenReturn("00000"+"023456789");
		Mockito.when(hgMock.genHash("abc1")).thenReturn("00000"+"145678900");
		
		PasswordGenerator pg = new PasswordGenerator(hgMock);
		
		assertEquals("24", pg.generatePassword(doorId, passwordLength));
	}
	
	@Test
	public void generate3charactersOfPasswordFrom4Hashes() {
		String doorId = "abc";
		int passwordLength = 3;
		
		HashGenerator hgMock = Mockito.mock(HashGenerator.class);
		Mockito.when(hgMock.genHash("abc0")).thenReturn("00000"+"143456789");
		Mockito.when(hgMock.genHash("abc1")).thenReturn("56456489789798545");
		Mockito.when(hgMock.genHash("abc2")).thenReturn("00000"+"025678900");
		Mockito.when(hgMock.genHash("abc3")).thenReturn("00000"+"2525678900");
		
		PasswordGenerator pg = new PasswordGenerator(hgMock);
		
		assertEquals("245", pg.generatePassword(doorId, passwordLength));
	}
	
	@Test
	public void useFirstCharacterForEachPosition() {
		String doorId = "abc";
		int passwordLength = 3;
		
		HashGenerator hgMock = Mockito.mock(HashGenerator.class);
		Mockito.when(hgMock.genHash("abc0")).thenReturn("00000"+"123456789");
		Mockito.when(hgMock.genHash("abc1")).thenReturn("56456489789798545");
		Mockito.when(hgMock.genHash("abc2")).thenReturn("00000"+"245678900");
		Mockito.when(hgMock.genHash("abc3")).thenReturn("00000"+"173456789");
		Mockito.when(hgMock.genHash("abc4")).thenReturn("56456489789798545");
		Mockito.when(hgMock.genHash("abc5")).thenReturn("00000"+"085678900");
		
		PasswordGenerator pg = new PasswordGenerator(hgMock);
		
		assertEquals("824", pg.generatePassword(doorId, passwordLength));
	}
	
	@Test
	public void ignoreInvalidPositions() {
		String doorId = "abc";
		int passwordLength = 2;
		
		HashGenerator hgMock = Mockito.mock(HashGenerator.class);
		Mockito.when(hgMock.genHash("abc0")).thenReturn("00000"+"023456789");
		Mockito.when(hgMock.genHash("abc1")).thenReturn("00000"+"x98798545");
		Mockito.when(hgMock.genHash("abc2")).thenReturn("00000"+"298798545");
		Mockito.when(hgMock.genHash("abc3")).thenReturn("00000"+"145678900");
		
		PasswordGenerator pg = new PasswordGenerator(hgMock);
		
		assertEquals("24", pg.generatePassword(doorId, passwordLength));
	}
}
