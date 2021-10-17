package br.com.til.grpc.protobuf;

import br.com.til.grpc.models.Credentials;
import br.com.til.grpc.models.EmailCredentials;
import br.com.til.grpc.models.PhoneOTP;

public class OneOfTest {

	public static void main(String[] args) {
		
		EmailCredentials emailCredentials = EmailCredentials.newBuilder()
			.setEmail("bolinha@bolinha.com")
			.setPassword("123")
			.build();
		
		PhoneOTP phone = PhoneOTP.newBuilder()
			.setNumber(989891234)
			.setCode(123)
			.build();
		
		Credentials credentials = Credentials.newBuilder()
			.setPhoneMode(phone)
			.setEmailMode(emailCredentials)
			.build();

		login(credentials);
		
	}
	
	private static void login(Credentials credentials) {
		
		
		switch (credentials.getModeCase()) {
		case EMAILMODE:
			
			System.out.println(credentials.getEmailMode());
			break;
		case PHONEMODE:
			
			System.out.println(credentials.getPhoneMode());
			break;

		default:
			break;
		} 
	}
	
}
