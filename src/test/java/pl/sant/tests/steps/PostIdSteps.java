package pl.sant.tests.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class PostIdSteps {
    private static final Logger log = LogManager.getLogger("PostIdSteps");

    private final String USER_ID_GET = "https://jsonplaceholder.typicode.com/comments";
    private Response response;

    @Step("posNewComment")
    public void postNewComment(Integer idMaxValue) {
        Map<String, String> request = new HashMap<>();
        request.put("postId",String.valueOf(idMaxValue));
        request.put("name","KM");
        request.put("email","km@gmail.com");
        request.put("body","jakiś komentarz");
        response = SerenityRest.given().body(request).when().post(USER_ID_GET);
    }

    @Step
    public void commentPostedSuccesfully() {
        response.then().statusCode(201);
    }

}
