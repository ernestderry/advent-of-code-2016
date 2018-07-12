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

	public Bot getBot(int i) {
		return getOrCreateBot(i);
	}

	public Output getOutput(int i) {
		return getOrCreateOutput(i);
	}

	public void iterate() {

		int previousBotProcessedCount = -1;
		int processedBots = 0;

		while (processedBots != previousBotProcessedCount) {
			previousBotProcessedCount = processedBots;
			processedBots = 0;
			for (Bot bot : bots) {
				if (bot != null) {
//					System.out.println("processing bot " + bot.getNumber());
					if (bot.getValue(2) != null && !bot.getProcessed()) {
						if (bot.getValue(1) > bot.getValue(2)) {
							System.out.println("bot " + bot.getNumber() + " gives " + bot.getValue(1) + " to "
									+ bot.getHighReceiver().getNumber());
							System.out.println("bot " + bot.getNumber() + " gives " + bot.getValue(2) + " to "
									+ bot.getLowReceiver().getNumber());
							bot.getHighReceiver().setValue(bot.getValue(1));
							bot.getLowReceiver().setValue(bot.getValue(2));
						} else {
							System.out.println("bot " + bot.getNumber() + " gives " + bot.getValue(2) + " to "
									+ bot.getHighReceiver().getNumber());
							System.out.println("bot " + bot.getNumber() + " gives " + bot.getValue(1) + " to "
									+ bot.getLowReceiver().getNumber());
							bot.getHighReceiver().setValue(bot.getValue(2));
							bot.getLowReceiver().setValue(bot.getValue(1));
						}
						bot.setProcessed();
					}
					if (bot.getProcessed()) {
						processedBots += 1;
					}
				}
			}
		}
	}

}
