package day6;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class NoiseReaderTest {

	@Test
	public void singleLetterSingleWord() {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("e");
		assertEquals("e", NoiseReader.errorCorrectMessage(messages));

	}

	@Test
	public void singleLetterTwoWordsTakeFirstLetter() {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("e");
		messages.add("f");
		assertEquals("e", NoiseReader.errorCorrectMessage(messages));

	}

	@Test
	public void singleLetterThreeWordsTakeMostPopularLetter() {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("e");
		messages.add("f");
		messages.add("f");
		assertEquals("f", NoiseReader.errorCorrectMessage(messages));

	}

	@Test
	public void multipleLettersThreeWordsTakeMostPopularLetter() {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("ea");
		messages.add("fa");
		messages.add("fb");
		assertEquals("fa", NoiseReader.errorCorrectMessage(messages));
	}

	@Test
	public void easterTest() {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("eedadn");
		messages.add("drvtee");
		messages.add("eandsr");
		messages.add("raavrd");
		messages.add("atevrs");
		messages.add("tsrnev");
		messages.add("sdttsa");
		messages.add("rasrtv");
		messages.add("nssdts");
		messages.add("ntnada");
		messages.add("svetve");
		messages.add("tesnvt");
		messages.add("vntsnd");
		messages.add("vrdear");
		messages.add("dvrsen");
		messages.add("enarar");
		assertEquals("easter", NoiseReader.errorCorrectMessage(messages));
	}

}
