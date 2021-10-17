package br.com.til.grpc.protobuf;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Int32Value;

import br.com.til.grpc.models.Address;
import br.com.til.grpc.models.Car;
import br.com.til.grpc.models.Person;

public class CompositionTest {
	public static void main(String[] args) {
		
		Address address = Address.newBuilder()
		.setPostBox(55)
		.setStreet("SQSW")
		.setCity("Brasilia")
		.build();
		
		Car car1 = Car.newBuilder()
		.setMake("Suzuki")
		.setModel("Jimny")
		.setYear(2021)
		.build();
		
		Car car2 = Car.newBuilder()
				.setMake("Land Rover")
				.setModel("Discovery 110")
				.setYear(2010)
				.build();
		
		List<Car> cars = new ArrayList<Car>();
		
		cars.add(car1);
		cars.add(car2);
		
		Person person = Person.newBuilder()
		.setName("Bolinha")
		.setAge(Int32Value.newBuilder().setValue(38).build())
		.setAddress(address)
		.addAllCar(cars)
		.build();
		
		
		System.out.println(person);
	}
}
