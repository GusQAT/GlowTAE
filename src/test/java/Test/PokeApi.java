package Test;

import Files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PokeApi
{
    public static void main (String[] args)
    {
        RestAssured.baseURI = "https://pokeapi.co";
        String pika = given().log().all()
                .when().get("/api/v2/pokemon/pikachu")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js1 = ReUsableMethods.rawToJson(pika);
        String baseExp = js1.getString("base_experience");
        System.out.println("Checking base experience: " + baseExp);
        Assert.assertEquals(baseExp,"112");

    }
}
