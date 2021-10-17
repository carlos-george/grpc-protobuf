package br.com.til.grpc.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;

import br.com.til.grpc.json.JPerson;
import br.com.til.grpc.models.Person;

public class PerformanceTest {

	public static void main(String[] args) {
		
		//json
		
		JPerson person = new JPerson("Naruto", 35);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Runnable json = () -> {
			try {
				byte[] bytes = mapper.writeValueAsBytes(person);
				
				System.out.println(bytes.length);
				
				JPerson person1 = mapper.readValue(bytes,JPerson.class);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		//protobuf
		
		Person person2 = Person.newBuilder()
				.setName("Goku")
				.setAge(Int32Value.newBuilder().setValue(35).build())
				.build();
		
		Runnable protobuf = () -> {
			
			try {
				
				byte[] byteArray = person2.toByteArray();
				
				System.out.println(byteArray.length);
				
				Person personParsed = Person.parseFrom(byteArray);
				
			} catch (InvalidProtocolBufferException e) {
				e.printStackTrace();
			}
		};
		for (int i = 0; i < 1; i++) {
			System.out.println("-----------\n");
			
			runPerfomanceTest(json, "JSON");
			runPerfomanceTest(protobuf, "PROTO");
			
			System.out.println("\n-----------");
		}
		
	}
	
	private static void runPerfomanceTest(Runnable runnable, String method) {
		long time1 = System.currentTimeMillis();
		
		for (int i = 0; i < 1; i++) {
			runnable.run();
		}
		
		long time2 = System.currentTimeMillis();
		
		System.out.println(method +": " + (time2 - time1) + " ms");
		
		
	}
}
