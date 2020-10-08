package pl.sant.tests.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;



public class UserIdSteps {
    private static final Logger log = LogManager.getLogger("UserIdSteps");

    private final String USER_ID_GET = "https://jsonplaceholder.typicode.com/posts/";
    private Response response;
    private Integer userIdMaxValue;

    @Step("Searching fo userIds")
    public void searchUserIds() {
        response = SerenityRest.when().get(USER_ID_GET);
    }

    @Step
    public void searchExecutedSuccesfully() {
        response.then().statusCode(200);
    }

    @Step
    public void setUserIdMaxValue() {
        List<Integer> listaJson = response.jsonPath().getList("userId");
        Integer maxValue = Collections.max(listaJson);
        log.info(maxValue);
        this.userIdMaxValue = maxValue;
    }

    public Integer getUserIdMaxValue() {
        return userIdMaxValue;
    }


}
