package day10;

public class Bot extends Receiver {

	int value;
	int botNumber;
	Receiver lowReceiver;
	Receiver highReceiver;
	Integer value1;
	Integer value2;
	boolean processed = false;
	
	public Bot(int botNumber) {
		this.botNumber = botNumber;
	}
	
	public int getNumber() {
		return this.botNumber;
	}

	public Integer getValue(int valueNumber) {
		if (valueNumber == 1) {
			return value1;
		} else return value2;
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
	
	public void setProcessed() {
		this.processed = true;
	}

	public boolean getProcessed() {
		return this.processed;
	}
}
