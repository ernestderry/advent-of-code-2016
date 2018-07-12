package day10;

public class Output extends Receiver {

	Integer value;
	int outputNumber;
	
	public Output(int outputNumber) {
		this.outputNumber = outputNumber;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public int getNumber() {
		return this.outputNumber;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

}
