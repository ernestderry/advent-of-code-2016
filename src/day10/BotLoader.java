package day10;

public class BotLoader {

	Bot[] bots = new Bot[999];
	Output[] outputs = new Output[999];

	public void loadInstruction(String instruction) {

		String[] instructionParts = instruction.split(" ");

		if (instructionParts[0].equals("value")) {
			int value = Integer.parseInt(instructionParts[1]);
			int botNumber = Integer.parseInt(instructionParts[5]);

			Bot bot = getOrCreateBot(botNumber);
			bot.setValue(value);
		}

		if (instructionParts[0].equals("bot")) {
			int botNumber = Integer.parseInt(instructionParts[1]);
			int lowReceiverNumber = Integer.parseInt(instructionParts[6]);
			int highReceiverNumber = Integer.parseInt(instructionParts[11]);
			String receiver1Type = instructionParts[5];
			String receiver2Type = instructionParts[10];

			Receiver lowReceiver;
			if (receiver1Type.equals("bot")) {
				lowReceiver = getOrCreateBot(lowReceiverNumber);
			} else {
				lowReceiver = getOrCreateOutput(lowReceiverNumber);
			}

			Receiver highReceiver;
			if (receiver2Type.equals("bot")) {
				highReceiver = getOrCreateBot(highReceiverNumber);
			} else {
				highReceiver = getOrCreateOutput(highReceiverNumber);
			}

			Bot bot = getOrCreateBot(botNumber);
			bot.setLowReceiver(lowReceiver);
			bot.setHighReceiver(highReceiver);
		}
	}

	public Bot getBot(int i) {
		return getOrCreateBot(i);
	}

	public Output getOutput(int i) {
		return getOrCreateOutput(i);
	}

	public void iterate() {
		int previousBotProcessedCount = -1;
		int processedBots = 0;

		do {
			previousBotProcessedCount = processedBots;
			processedBots = 0;
			for (Bot bot : bots) {
				if (bot != null) {
					bot.process();

					if (bot.getProcessed()) {
						processedBots += 1;
					}
				}
			}
		} while (processedBots != previousBotProcessedCount);
	}
	
	private Bot getOrCreateBot(int botNumber) {
		Bot bot = bots[botNumber];
		if (bot == null) {
			bot = new Bot(botNumber);
			bots[botNumber] = bot;
		}
		return bot;
	}

	private Output getOrCreateOutput(int outputNumber) {
		Output output = outputs[outputNumber];
		if (output == null) {
			output = new Output(outputNumber);
			outputs[outputNumber] = output;
		}
		return output;
	}
}
