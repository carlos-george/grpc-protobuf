package br.com.til.grpc.protobuf;

import java.util.Map;

import br.com.til.grpc.models.BodyStyle;
import br.com.til.grpc.models.Car;
import br.com.til.grpc.models.Dealer;

public class MapTest {
	public static void main(String[] args) {

		Car car1 = Car.newBuilder()
				.setMake("Suzuki")
				.setModel("Jimny")
				.setYear(2021)
				.setBodyStyle(BodyStyle.JEEP)
				.build();

		Car car2 = Car.newBuilder()
				.setMake("Land Rover")
				.setModel("Discovery 110")
				.setYear(2010)
				.setBodyStyle(BodyStyle.SUV)
				.build();
		
		Dealer dealer = Dealer.newBuilder()
		.putModel(2021, car1)
		.putModel(2010, car2)
		.build();
		
		System.out.println(dealer);
		
		System.out.println(dealer.getModelOrDefault(2020, car2));
		
		Map<Integer, Car> modelMap = dealer.getModelMap();
		
		System.out.println(modelMap);
		
		System.out.println(dealer.getModelOrThrow(2021).getBodyStyle());

		System.out.println(dealer.getModelOrThrow(2020));
		
		
		
	}
}
