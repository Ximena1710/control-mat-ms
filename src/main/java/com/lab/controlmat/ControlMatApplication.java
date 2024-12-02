package com.lab.controlmat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import javax.sound.midi.Soundbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class ControlMatApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ControlMatApplication.class, args);
		
		Supplier<String> supplier = () ->  "Hello mundo";
		
		System.out.println(supplier.get());
		
		Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
		
		consumer.accept("Hola");
		
		Function<String, String> function = String::toUpperCase;
		
		System.out.println(function.apply("Hola mundo"));
		
		Predicate<String> predicate = a -> a.equals("Andres");
		System.out.println(predicate.test("Andres"));
		
		UnaryOperator<String> unary = String::toUpperCase;
		System.out.println(unary.apply("Esto es una prueba de unary"));
		
		IntUnaryOperator intUnar = (a) -> a*a;
		System.out.println(intUnar.applyAsInt(15));
		
		
		BiFunction<Double, Double, Double> operacionesSuma = (a, b) -> a+b;
		System.out.println(operacionesSuma.apply(8D, 15D));
		
		Map<String, String> datos = Map.of("Andres", "aandres005@hotmail.com", "ximena", "xg1710@gmail.com");
		Optional<String> email = Optional.ofNullable(datos.get("doe"));
		System.out.println(datos.get("Andres"));
		email.ifPresentOrElse(System.out::println, ()-> System.out.println("Email no encontrado"));
		
		List<Double> numbers = Arrays.asList(1.5, 2.0, 3.5, 4.0, 5.5);
		
		 numbers.stream().reduce((a, b) ->{return a+b;}).ifPresent(suma -> System.out.println(suma / numbers.size()));
		
		
	}
}
