package TestData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

public Map<String, Object> setUpTestData(){

    //https://jsonplaceholder.typicode.com

    HashMap<String, Object> expectedData=new HashMap<String, Object>();
        expectedData.put("statusCode", 200);
        expectedData.put("userId", 1 );
        expectedData.put("title", "fugiat veniam minus");
        expectedData.put("completed", false);
        expectedData.put("Server", "cloudflare");
       return expectedData;
}

public JSONObject setUpRequestAndExpected(){

    JSONObject expectedData=new JSONObject();
    expectedData.put("statusCode", 201);
    expectedData.put("userId", 55);
    expectedData.put("title", "Tidy your room");
    expectedData.put("completed", false);
    return expectedData;
}

public JSONObject setUpPut(){
    JSONObject expectedRequestData=new JSONObject();
    expectedRequestData.put("userId", 10);
    expectedRequestData.put("title", "vero rerum temporibus dolor");
    expectedRequestData.put("completed", true);
    return expectedRequestData;

}



public JSONObject setUpPatchRequestBody(){
    JSONObject requestData=new JSONObject();
    requestData.put("title", "API çalışmalıyım");
    return requestData;
}


public JSONObject setUpPatchExpectedData(){
    JSONObject expectedData=new JSONObject();
    expectedData.put("userId" ,10);
    expectedData.put("title", "API çalışmalıyım");
    expectedData.put( "completed", true);
    expectedData.put("id", 198);
    return expectedData;


}



}

