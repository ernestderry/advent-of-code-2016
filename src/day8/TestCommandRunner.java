package day8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestCommandRunner {
	
	Screen screenMock;
	CommandRunner commandRunner;
	
	@Before
	public void setUp() {
		screenMock = Mockito.mock(Screen.class);		
		commandRunner = new CommandRunner(screenMock);
	}

	@Test
	public void commandRunnerReturnsCurrentScreen() {
		assertEquals(commandRunner.getScreen(), screenMock);		
	}
	
	@Test
	public void rectangleCommand() {
		List<String> commands = new ArrayList<String>();
		commands.add("rect 3x12");
		
		commandRunner.run(commands);
		Mockito.verify(screenMock, Mockito.times(1)).rect(3, 12);
	}

	@Test
	public void rotateColumnCommand() {
		List<String> commands = new ArrayList<String>();
		commands.add("rotate column x=35 by 17");
		
		commandRunner.run(commands);
		Mockito.verify(screenMock, Mockito.times(1)).rotateColumn(35, 17);
	}

	@Test
	public void rotateRowCommand() {
		List<String> commands = new ArrayList<String>();
		commands.add("rotate row y=2 by 5");
		
		commandRunner.run(commands);
		Mockito.verify(screenMock, Mockito.times(1)).rotateRow(2, 5);
	}
	
	@Test
	public void runMoreThanOneCommand() {
		List<String> commands = new ArrayList<String>();
		commands.add("rect 3x12");
		commands.add("rotate column x=35 by 17");
		commands.add("rotate row y=2 by 5");
		commandRunner.run(commands);

		Mockito.verify(screenMock, Mockito.times(1)).rect(3, 12);
		Mockito.verify(screenMock, Mockito.times(1)).rotateColumn(35, 17);
		Mockito.verify(screenMock, Mockito.times(1)).rotateRow(2, 5);
		
	}
}
