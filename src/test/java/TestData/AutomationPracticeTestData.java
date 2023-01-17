package TestData;

import org.json.JSONObject;

public class AutomationPracticeTestData {
    public JSONObject setUpRequestBody(){
        setUpRequestBody().put("name", "Regular fit jeans");
        setUpRequestBody().put("price", 13500);
        setUpRequestBody().put("size", 46);
        return setUpRequestBody();
    }


    public JSONObject setUpExpectedBody(){

        setUpExpectedBody().put("responseCode", 400);
        setUpExpectedBody().put("message", "Bad request, search_product parameter is missing in POST request.");
        setUpExpectedBody().put("name", "Regular fit jeans");
        setUpExpectedBody().put("price", 13500);
        setUpExpectedBody().put("size", 46);
        return setUpExpectedBody();
    }
}
