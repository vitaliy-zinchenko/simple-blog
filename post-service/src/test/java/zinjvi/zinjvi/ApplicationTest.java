package zinjvi.zinjvi;

import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ApplicationTest {

        @Value("${local.server.port}")
        int port;

        @Before
        public void setUp() {
            RestAssured.port = port;
        }

        @Test
        public void canFetchMickey() {
            RestAssured.when().
                    get("/post/")

                    .then().statusCode(HttpStatus.SC_OK)
                    .body("id", Matchers.equalTo(1))
                    .body("message", Matchers.equalTo("mmmm"));
        }


}
