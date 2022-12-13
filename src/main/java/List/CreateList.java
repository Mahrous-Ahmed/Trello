package List;


import PropertyConfig.ReadFromProp;
import RestAssured.Base;
import org.json.JSONObject;
import org.testng.Assert;

public class CreateList extends Base {
    public CreateList() {
        super();
    }

    @Override
    public void AddQueriesPara() {
    }

    @Override
    public void AddQueriesPara(String name, String Id) {
        httpRequest.queryParam("name", name);
        httpRequest.queryParam("idBoard", Id);
        httpRequest.queryParam("key", key);
        httpRequest.queryParam("token", token);
    }

    @Override
    public void AddHeaders() {
        httpRequest.header("Content-Type" , "application/json");
    }

    @Override
    public void AddBody(String displayName , String type , String desc , String teamType , String prefs_permissionLevel , String token){

    }

    @Override
    public String getIDResponse(String endPoint) {
        response = httpRequest.post(endPoint);

        Assert.assertEquals(response.statusCode(), 200);
        ReadFromProp.setProperty("idList",response.getBody().path("id").toString());
        System.out.println(response.getBody().path("id").toString());
        return response.getBody().path("id").toString();
    }







    public static void main(String[] args) {
        CreateList createList = new CreateList();
        createList.AddQueriesPara("Java List" , ReadFromProp.getProperty("idBoard").toString());
        createList.AddHeaders();
        createList.getIDResponse("/lists");

    }

}
