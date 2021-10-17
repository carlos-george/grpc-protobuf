package br.com.til.grpc.protobuf;

import com.google.protobuf.Int32Value;

import br.com.til.grpc.models.Person;

public class PersonDemo {
	
	public static void main(String[] args) {
		Person person1 = Person.newBuilder()
		.setName("Naruto")
		.setAge(Int32Value.newBuilder().setValue(35).build())
		.build();
		
		System.out.println(person1);
	}

}
