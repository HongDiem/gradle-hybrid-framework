package com.jquery;

import com.github.javafaker.Faker;

public class Topic_19_Faker {

	public static void main(String[] args) {
		Faker faker = new Faker();
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.business().creditCardType());
		System.out.println(faker.business().creditCardNumber());
		faker.business().creditCardType();
		

	}

}
