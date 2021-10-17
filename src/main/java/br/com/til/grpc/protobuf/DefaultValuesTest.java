package br.com.til.grpc.protobuf;

import br.com.til.grpc.models.Person;

public class DefaultValuesTest {
	public static void main(String[] args) {
		Person person = Person.newBuilder().build();
		
		System.out.println("City :" +person.getAddress().getCity());
		
		System.out.println("has Address :" +person.hasAddress());
	}
}
