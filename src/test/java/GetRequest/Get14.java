package GetRequest;

import TestData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import techproed.testBase.DummyRest;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get14 extends DummyRest {

 /*
       "https://dummy.restapiexample.com/api/v1/employees

        status codun 200 olduğu
            en yüksek maaşın 725000 olduğu
            en küçük yaşın 19 olduğu
            ıkıncı en yuksek maasın 675000 olguğunu test edin



    HashMap<String, Integer> expectedData= new HashMap<>();
expectedData.put("statusCode", 200);
expectedData.put("enyüksek maas", 725000 );
expectedData.put("enkucukyas", 19);
expectedData.put("ıkınıenyuksekmaas", 675000);
return expectedData;
 */

    @Test
    public void get14() {
        spec.pathParam("first", "employees");

        DummyTestData obj = new DummyTestData();
        HashMap<String, Integer> expectedData = obj.SetUp2();
        System.out.println(expectedData);//{enyüksek maas=725000, enkucukyas=19, ıkınıenyuksekmaas=675000, statusCode=200}

        Response response = given().spec(spec).accept(ContentType.JSON).
                when().get("/{first}");

        HashMap<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        // status codun 200 olduğu
        assertEquals(expectedData.get("statusCode"), (Integer) response.getStatusCode());

        //en yüksek maaşın 725000 olduğu
        List<Integer> salary = new ArrayList<>();

        int datasize = ((List) actualData.get("data")).size();
        for (int i = 0; i < datasize; i++) {
            salary.add((Integer) ((Map) ((List) actualData.get("data")).get(i)).get("employee_salary"));
            Collections.sort(salary);
            salary.get(datasize - 1);
            assertEquals(expectedData.get("enyüksek maas"), salary.get(datasize - 1));

        }
        //ıkıncı en yuksek maasın 675000 olguğunu test edin
        assertEquals(expectedData.get("ıkınıenyuksekmaas"), salary.get(datasize-2));

        //en küçük yaşın 19 olduğu

        List<Integer> ages=new ArrayList<>();
        for (int i=0; i<datasize; i++){
            ages.add((Integer) ((Map)((List)actualData.get("data")).get(i)).get("employee_ages"));
            Collections.sort(ages);
            assertEquals(expectedData.get("enkucukyas"), ages.get(0));

        }

        //jsonPath ile assertion

        JsonPath jsonPath=response.jsonPath();
        //en yüksek maaşın 725000 olduğu
        List<Integer> salaryjson= jsonPath.getList("data.employee_salary");
        Collections.sort(salaryjson);
        assertEquals(expectedData.get("enyüksek maas"), salaryjson.get(salaryjson.size()-1));

        //ıkıncı en yuksek maasın 675000 olguğunu test edin
        assertEquals(expectedData.get("ıkınıenyuksekmaas"), salaryjson.get(salaryjson.size()-2));

        //en küçük yaşın 19 olduğu
        List<Integer> agesjson= jsonPath.getList("data.employee_ages");
        Collections.sort(agesjson);
        assertEquals(expectedData.get("enkucukyas"), agesjson.get(0));
    }
}