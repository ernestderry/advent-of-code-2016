package day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoom {

	@Test
	public void emptyString() {
		assertEquals(false, Room.isReal(""));
	}

	@Test
	public void validRoomWithShortName() {
		assertEquals(true, Room.isReal("a-1[a]"));
	}

	@Test
	public void invalidRoomWithShortName() {
		assertEquals(false, Room.isReal("a-1[b]"));
	}

	@Test
	public void validRoomWithTwoWordName() {
		assertEquals(true, Room.isReal("a-b-1[ab]"));
	}
	
	@Test
	public void invalidRoomWithTwoWordNameChecksumWrongWayRound() {
		assertEquals(false, Room.isReal("a-b-1[ba]"));
	}

	@Test
	public void validRoomWithTwoWordNameChecksumInOrder() {
		assertEquals(true, Room.isReal("b-a-1[ab]"));
	}

	@Test
	public void validRoomWithTwoWordNamesOfMoreThanOneCharChecksumInOrder() {
		assertEquals(true, Room.isReal("bce-ad-1[abcde]"));
	}

	@Test
	public void validRoomWithMaximum5CharChecksum() {
		assertEquals(true, Room.isReal("bce-adfgh-1[abcde]"));
	}

	@Test
	public void validRoomWithMostPopularLettersAppearingFirstInChecksum() {
		assertEquals(true, Room.isReal("ba-bb-1[ba]"));
	}

	@Test
	public void validRoomWithMostPopularLettersAppearingFirstInChecksum2() {
		assertEquals(true, Room.isReal("aaaaa-bbb-z-y-x-123[abxyz]"));
	}

	@Test
	public void validRoomWithMostPopularLettersAppearingFirstInChecksum3() {
		assertEquals(true, Room.isReal("a-b-c-d-e-f-g-h-987[abcde]"));
	}

	@Test
	public void validRoomWithMostPopularLettersAppearingFirstInChecksum4() {
		assertEquals(true, Room.isReal("not-a-real-room-404[oarel]"));
	}

	@Test
	public void validRoomWithMostPopularLettersAppearingFirstInChecksum5() {
		assertEquals(false, Room.isReal("totally-real-room-200[decoy]"));
	}
	
	@Test
	public void retrieveSectorCodeNoName() {
		assertEquals(123, Room.getSector("123[ab]"));
	}

	@Test
	public void retrieveSectorCodeWithSingleWordName() {
		assertEquals(100, Room.getSector("ab-100[ab]"));
	}
	
	@Test
	public void retrieveSectorCodeWithMultipleWordName() {
		assertEquals(200, Room.getSector("ab-cd-ef-200[abcde]"));
	}
	
}
