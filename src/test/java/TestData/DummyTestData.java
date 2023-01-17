package TestData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyTestData {
    public HashMap<String, Object> setUp(){

        List<Integer> ages= new ArrayList<>();
        ages.add(40);
        ages.add(21);
        ages.add(19);

        HashMap<String, Object> onbirincikişi= new HashMap<>();
      onbirincikişi.put("id",2 );
      onbirincikişi.put("employee_name", "Garrett Winters");
      onbirincikişi.put("employee_salary",170750);
      onbirincikişi.put("employee_age",63);
      onbirincikişi.put("profile_image","");

      HashMap<String, Object> expectedData= new HashMap<String, Object>();
      expectedData.put("statusCode", 200);
      expectedData.put("beşinciçalışan", "Airi Satou");
      expectedData.put("çalışansayısı", 24);
      expectedData.put("sondanikiciçalısanmaası", 106450);
      expectedData.put("arananyaşlar", ages);
      expectedData.put("onbirinciçalışan", onbirincikişi);

      return expectedData;

    }


    public HashMap<String, Integer> SetUp2(){
       /*
       "https://dummy.restapiexample.com/api/v1/employees

        status codun 200 olduğu
            en yüksek maaşın 725000 olduğu
            en küçük yaşın 19 olduğu
            ıkıncı en yuksek maasın 675000 olguğunu test edin
          */


HashMap<String, Integer> expectedData= new HashMap<>();
expectedData.put("statusCode", 200);
expectedData.put("enyüksek maas", 725000 );
expectedData.put("enkucukyas", 19);
expectedData.put("ıkınıenyuksekmaas", 675000);
return expectedData;
    }


    public HashMap<String, String> setupRequestBody(){
        HashMap<String, String> requestBody=new HashMap<>();
        requestBody.put("name", "Semra");
        requestBody.put("salary", "123000");
        requestBody.put("age", "20");
        return requestBody;
    }

    public HashMap<String, Object> setupExpecteddata(){//içteki inner Map
HashMap<String, Object> data=new HashMap<>();
data.put("name", "Semra");
data.put("salary", "123000");
data.put("age", "20");

HashMap<String, Object> expecteddata=new HashMap<>();//dıştaki Map
expecteddata.put("statusCode", 200);
expecteddata.put("status", "success");
expecteddata.put("data", data);
return expecteddata;
    }

    public JSONObject setUpDeleteExpectedData(){
        JSONObject expectedData=new JSONObject();
        expectedData.put("status", "success");
        expectedData.put( "data", "2");
        expectedData.put("message", "Successfully! Record has been deleted");

        return expectedData;

    }
}
