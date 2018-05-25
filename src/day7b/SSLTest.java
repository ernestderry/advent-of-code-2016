package day7b;

import static org.junit.Assert.*;

import org.junit.Test;

public class SSLTest {

	@Test
	public void nullIsNotSSL() {
		assertFalse(SSL.isSSL(null));
	}

	@Test
	public void emptyStringIsNotSSL() {
		assertFalse(SSL.isSSL(""));
	}
	
	@Test
	public void validSSLsimpleABAandBAB() {
		assertTrue(SSL.isSSL("aba[bab]"));
	}
	
	@Test
	public void noHypernetIsNotSSL() {
		assertFalse(SSL.isSSL("aba"));
	}
	
	@Test
	public void invalidHypernetIsNotSSL() {
		assertFalse(SSL.isSSL("aba[bab"));
	}

	@Test
	public void invalidHypernetIsNotSSL2() {
		assertFalse(SSL.isSSL("ababab]"));
	}
	
	@Test
	public void notValidIfBABmissingFromHypernet() {
		assertFalse(SSL.isSSL("aba[cac]"));
	}
	
	@Test
	public void validIfBABsomewhereInsideTheHypernet() {
		assertTrue(SSL.isSSL("aba[cacbabcac]"));
	}

	@Test
	public void validIfBABsomewhereInsideSecondHypernet() {
		assertTrue(SSL.isSSL("aba[ggbdedd]zzz[cacbabcac]"));
	}

	@Test
	public void validIfBABsomewhereInsideFirstHypernet() {
		assertTrue(SSL.isSSL("aba[cacbabcac]zzz[ggbdedd]"));
	}
	
	@Test
	public void validIfABAafterHypernets() {
		assertTrue(SSL.isSSL("xyz[cacbabcac]zzz[ggbdedd]aba"));
	}

	@Test
	public void notValidIfABAacrossHypernets() {
		assertFalse(SSL.isSSL("a[cacbabcac]ba"));
	}
	
	@Test
	public void notValidFor3IdenticalCharacters() {
		assertFalse(SSL.isSSL("aaa[cacaaacac]bab"));
	}
	
	
	
}
