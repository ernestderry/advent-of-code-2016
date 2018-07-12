package day10b;

public class Output extends Receiver {

	private Integer value;
	private int outputNumber;
	
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
