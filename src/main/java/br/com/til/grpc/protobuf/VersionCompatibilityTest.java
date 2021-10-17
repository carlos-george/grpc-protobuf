package br.com.til.grpc.protobuf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.til.grpc.models.Television;
import br.com.til.grpc.models.Type;

public class VersionCompatibilityTest {
	public static void main(String[] args) throws IOException {
		
		Path pathV1 = Paths.get("tv-v1");
		Path pathV2 = Paths.get("tv-v2");
		
		Television televisionV1 = Television.newBuilder()
		.setBrand("Samsung")
		.setModel(2020)
		.setType(Type.OLED)
		.build();
		
		Files.write(pathV2, televisionV1.toByteArray());
		
		
		
//		byte[] bytes = Files.readAllBytes(path);
//		
//		System.out.println(Television.parseFrom(bytes));
	}
}
