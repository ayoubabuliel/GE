import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestAPI extends InitTest{
    final String url = "https://api.publicapis.org/entries";
    private JsonNode entries;
    private ObjectMapper mapper;
    private int expectedEntryNumber = 7;

    @Before
    public void init(){
        mapper = new ObjectMapper();
        given().when().get(url).then().statusCode(200);
        entries = mapper.valueToTree(given().when().get(url).getBody().jsonPath().get()).get("entries");
    }

    @Test
    public void verifyCountOfCategoryOfAuthenticationAndAuthorization() {
        int count = 0;
        for (JsonNode arrayItem : entries)
            if (arrayItem.get("Category").asText().equals("Authentication & Authorization"))
                count++;
        Assert.assertEquals(String.format("The actual count of 'Authentication & Authorization' node is %s, But the expected was %s", count, expectedEntryNumber), count, expectedEntryNumber);
    }

    @After
    public void afterTest() throws JsonProcessingException {
        printLog("Here we printing all entries\n");
        for (JsonNode entry: entries)
            printLog(mapper.treeToValue(entry, EntryDTO.class).toString());
    }

}
