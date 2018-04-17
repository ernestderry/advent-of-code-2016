package day5b;

public class main {

	public static void main(String[] args) {
		PasswordGenerator pg = new PasswordGenerator();
		String doorId = "ojvtpuvg";
		int passwordLength = 8;
		String password = pg.generatePassword(doorId, passwordLength);
		System.out.println("Answer "+password);
		
	}
	
}
