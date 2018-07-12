package day10;

public class Bot extends Receiver {

	private int botNumber;
	private Receiver lowReceiver;
	private Receiver highReceiver;
	private Integer value1;
	private Integer value2;
	private boolean processed = false;

	public Bot(int botNumber) {
		this.botNumber = botNumber;
	}

	public int getNumber() {
		return this.botNumber;
	}

	public Integer getValue(int valueNumber) {
		if (valueNumber == 1) {
			return value1;
		} else
			return value2;
	}

	public void setValue(int value) {
		if (value1 == null) {
			this.value1 = value;
		} else {
			this.value2 = value;
		}
	}

	public Receiver getLowReceiver() {
		return this.lowReceiver;
	}

	public Receiver getHighReceiver() {
		return this.highReceiver;
	}

	public void setLowReceiver(Receiver lowReceiver) {
		this.lowReceiver = lowReceiver;
	}

	public void setHighReceiver(Receiver highReceiver) {
		this.highReceiver = highReceiver;
	}

	public boolean getProcessed() {
		return this.processed;
	}

	public void process() {

		if (botReadyForProcessing()) {

			if (getValue(1) > getValue(2)) {
				System.out.println(
						"bot " + getNumber() + " gives " + getValue(1) + " to " + getHighReceiver().getNumber());
				System.out.println(
						"bot " + getNumber() + " gives " + getValue(2) + " to " + getLowReceiver().getNumber());

				getHighReceiver().setValue(getValue(1));
				getLowReceiver().setValue(getValue(2));

			} else {

				System.out.println(
						"bot " + getNumber() + " gives " + getValue(2) + " to " + getHighReceiver().getNumber());
				System.out.println(
						"bot " + getNumber() + " gives " + getValue(1) + " to " + getLowReceiver().getNumber());

				getHighReceiver().setValue(getValue(2));
				getLowReceiver().setValue(getValue(1));
			}

			setProcessed();
		}
	}

	private void setProcessed() {
		this.processed = true;
	}
	
	private boolean botReadyForProcessing() {

		if (getValue(2) != null && !getProcessed()) {
			return true;
		}
		return false;
	}

}
