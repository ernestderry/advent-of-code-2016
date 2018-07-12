package day10;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBotLoader {

	@Test
	public void assignBotWithValue() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("value 5 goes to bot 2");
		Bot bot = bl.getBot(2);
		assertEquals(5, (int) bot.getValue(1));
	}

	@Test
	public void assignBotWithDifferentValue() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("value 6 goes to bot 2");
		Bot bot = bl.getBot(2);
		assertEquals(6, (int) bot.getValue(1));
	}

	@Test
	public void assign2BotsAValue() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("value 7 goes to bot 2");
		bl.loadInstruction("value 8 goes to bot 3");
		Bot bot = bl.getBot(2);
		assertEquals(7, (int) bot.getValue(1));
		bot = bl.getBot(3);
		assertEquals(8, (int) bot.getValue(1));
	}
	
	@Test
	public void assignLowAndHighBotReceiversToBot() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("bot 2 gives low to bot 1 and high to bot 0");
		Bot bot2 = bl.getBot(2);
		Bot bot1 = bl.getBot(1);
		Bot bot0 = bl.getBot(0);
		assertEquals(bot1, bot2.getLowReceiver());
		assertEquals(bot0, bot2.getHighReceiver());
	}
	
	@Test
	public void assignLowAndHighBotReceiversToBotWithAValue() {
		BotLoader bl = new BotLoader();		
		bl.loadInstruction("value 7 goes to bot 2");
		bl.loadInstruction("bot 2 gives low to bot 1 and high to bot 0");
		Bot bot2 = bl.getBot(2);
		Bot bot1 = bl.getBot(1);
		Bot bot0 = bl.getBot(0);
		assertEquals(bot1, bot2.getLowReceiver());
		assertEquals(bot0, bot2.getHighReceiver());
		assertEquals(7, (int) bot2.getValue(1));
	}

	@Test
	public void assignValueToBotWithLowAndHighBotReceivers() {
		BotLoader bl = new BotLoader();		
		bl.loadInstruction("bot 2 gives low to bot 1 and high to bot 0");
		bl.loadInstruction("value 7 goes to bot 2");
		Bot bot2 = bl.getBot(2);
		Bot bot1 = bl.getBot(1);
		Bot bot0 = bl.getBot(0);
		assertEquals(bot1, bot2.getLowReceiver());
		assertEquals(bot0, bot2.getHighReceiver());
		assertEquals(7, (int) bot2.getValue(1));
	}
	
	@Test
	public void assign2ValuesToBot() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("value 7 goes to bot 2");
		bl.loadInstruction("value 3 goes to bot 2");
		Bot bot2 = bl.getBot(2);
		assertEquals(7, (int) bot2.getValue(1));
		assertEquals(3, (int) bot2.getValue(2));
	}
	
	@Test
	public void assignLowAndHighOutputReceiversToBot() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("bot 2 gives low to output 1 and high to output 0");
		Output output1 = bl.getOutput(1);
		Output output0 = bl.getOutput(0);
		Bot bot2 = bl.getBot(2);
		assertEquals(output1, bot2.getLowReceiver());
		assertEquals(output0, bot2.getHighReceiver());
	}

	@Test
	public void assignLowAndHighOutputReceiversToBotAndOutput() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("bot 2 gives low to bot 1 and high to output 0");
		Bot bot1 = bl.getBot(1);
		Output output0 = bl.getOutput(0);
		Bot bot2 = bl.getBot(2);
		assertEquals(bot1, bot2.getLowReceiver());
		assertEquals(output0, bot2.getHighReceiver());
	}
	
	@Test
	public void iterateGivesLowAndHighValuesToBots() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("bot 2 gives low to bot 1 and high to bot 0");
		bl.loadInstruction("value 7 goes to bot 2");
		bl.loadInstruction("value 3 goes to bot 2");
		bl.iterate();
		Bot bot1 = bl.getBot(1);
		Bot bot0 = bl.getBot(0);
		assertEquals(3, (int) bot1.getValue(1));
		assertEquals(7, (int) bot0.getValue(1));
	}
	
	@Test
	public void iterateGivesLowAndHighValuesToBotsReversed() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("bot 2 gives low to bot 0 and high to bot 1");
		bl.loadInstruction("value 7 goes to bot 2");
		bl.loadInstruction("value 3 goes to bot 2");
		bl.iterate();
		Bot bot1 = bl.getBot(1);
		Bot bot0 = bl.getBot(0);
		assertEquals(7, (int) bot1.getValue(1));
		assertEquals(3, (int) bot0.getValue(1));
	}
	
	@Test
	public void iterateGivesLowAndHighValuesToOutputs() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("bot 2 gives low to output 1 and high to output 0");
		bl.loadInstruction("value 7 goes to bot 2");
		bl.loadInstruction("value 3 goes to bot 2");
		bl.iterate();
		Output out1 = bl.getOutput(1);
		Output out0 = bl.getOutput(0);
		assertEquals(3, (int) out1.getValue());
		assertEquals(7, (int) out0.getValue());
	}

	@Test
	public void iterateGivesLowAndHighValuesToOutputsReversed() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("bot 2 gives low to output 0 and high to output 1");
		bl.loadInstruction("value 7 goes to bot 2");
		bl.loadInstruction("value 3 goes to bot 2");
		bl.iterate();
		Output out1 = bl.getOutput(1);
		Output out0 = bl.getOutput(0);
		assertEquals(7, (int) out1.getValue());
		assertEquals(3, (int) out0.getValue());
	}
	
	@Test
	public void iterateABotWithOnlyOneValueDoesNothing() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("bot 2 gives low to output 0 and high to output 1");
		bl.loadInstruction("value 7 goes to bot 2");
		bl.iterate();
		Output out1 = bl.getOutput(1);
		Output out0 = bl.getOutput(0);
		assertEquals(null, out1.getValue());
		assertEquals(null, out0.getValue());
	}

	@Test
	public void iterateABotWithNoValuesDoesNothing() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("bot 2 gives low to output 0 and high to output 1");
		bl.iterate();
		Output out1 = bl.getOutput(1);
		Output out0 = bl.getOutput(0);
		assertEquals(null, out1.getValue());
		assertEquals(null, out0.getValue());
	}

	@Test
	public void iterateWithMultipleBotsAndOutputs() {
		BotLoader bl = new BotLoader();
		bl.loadInstruction("value 5 goes to bot 2");
		bl.loadInstruction("bot 2 gives low to bot 1 and high to bot 0");
		bl.loadInstruction("value 3 goes to bot 1");
		bl.loadInstruction("bot 1 gives low to output 1 and high to bot 0");
		bl.loadInstruction("bot 0 gives low to output 2 and high to output 0");
		bl.loadInstruction("value 2 goes to bot 2");
		bl.iterate();
		Output out0 = bl.getOutput(0);
		Output out1 = bl.getOutput(1);
		Output out2 = bl.getOutput(2);
		assertEquals(5, (int) out0.getValue());
		assertEquals(2, (int) out1.getValue());
		assertEquals(3, (int) out2.getValue());
	}
	
}
