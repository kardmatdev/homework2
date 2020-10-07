package pl.sant.tests.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;


public class IdSteps {
    private static final Logger log = LogManager.getLogger("IdSteps");

    private final String USER_ID_GET = "https://jsonplaceholder.typicode.com/posts?userId=";
    private Response response;
    private Integer idMaxValue;


    @Step("Searching fo Ids")
    public void searchIds(Integer userIdMaxValue) {
        response = SerenityRest.when().get(USER_ID_GET + String.valueOf(userIdMaxValue));
    }

    @Step
    public void searchExecutedSuccesfully() {
        response.then().statusCode(200);
    }

    @Step
    public void setIdMaxValue() {
        log.info(response.body().toString());
        List<Integer> listaJson = response.jsonPath().getList("id");
        log.info(listaJson.size());
        Integer maxValue = Collections.max(listaJson);
        log.info(maxValue);
        this.idMaxValue = maxValue;
    }

    public Integer getIdMaxValue() {
        return idMaxValue;
    }




}
