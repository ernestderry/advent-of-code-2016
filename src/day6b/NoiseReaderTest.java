package day6b;

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
	public void singleLetterThreeWordsTakeLeastPopularLetter() {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("e");
		messages.add("f");
		messages.add("f");
		assertEquals("e", NoiseReader.errorCorrectMessage(messages));

	}

	@Test
	public void multipleLettersThreeWordsTakeLeastPopularLetter() {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("ea");
		messages.add("fa");
		messages.add("fb");
		assertEquals("eb", NoiseReader.errorCorrectMessage(messages));
	}

	@Test
	public void adventTest() {
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
		assertEquals("advent", NoiseReader.errorCorrectMessage(messages));
	}

}
