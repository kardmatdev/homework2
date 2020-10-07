package pl.sant.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.sant.tests.steps.IdSteps;
import pl.sant.tests.steps.PostIdSteps;
import pl.sant.tests.steps.UserIdSteps;

@RunWith(SerenityRunner.class)
public class RestAssuredTest {

    @Steps(shared = true)
    UserIdSteps userIdSteps;

    @Steps(shared = true)
    IdSteps idSteps;

    @Steps
    PostIdSteps postIdSteps;

    @Test
    public void getUserIdThenIdThenPostNewComment() {
        userIdSteps.searchUserIds();
        userIdSteps.searchExecutedSuccesfully();
        userIdSteps.setUserIdMaxValue();
        idSteps.searchIds(userIdSteps.getUserIdMaxValue());
        idSteps.searchExecutedSuccesfully();
        idSteps.setIdMaxValue();
        postIdSteps.postNewComment(idSteps.getIdMaxValue());
        postIdSteps.commentPostedSuccesfully();

    }

}
