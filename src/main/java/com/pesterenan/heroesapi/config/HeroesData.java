package com.pesterenan.heroesapi.config;

import static com.pesterenan.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.pesterenan.heroesapi.constants.HeroesConstant.REGION_DYNAMO;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class HeroesData {
	public static void main(String[] args) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
				.build();
		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable("Heroes_Table");
		
		Item hero = new Item()
				.withPrimaryKey("id", "1")
				.withString("name", "IronMan")
				.withString("universe", "Marvel Comics")
				.withNumber("movies", 3);

		PutItemOutcome outcome = table.putItem(hero);
	}
}
