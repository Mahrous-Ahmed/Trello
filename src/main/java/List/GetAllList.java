package List;

import PropertyConfig.ReadFromProp;
import RestAssured.Base;
import io.restassured.RestAssured;
import org.testng.Assert;

public class GetAllList extends Base {

    public GetAllList() {
        super();
    }

    @Override
    public void AddQueriesPara() {
        httpRequest.queryParam("key", key);
        httpRequest.queryParam("token", token);
    }

    @Override
    public void AddQueriesPara(String name, String Id) {

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
        response = httpRequest.get(endPoint);
        //Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.prettyPrint());
        return null;
    }







    public static void main(String[] args) {
        GetAllList getAllList = new GetAllList();
        getAllList.AddQueriesPara();
        getAllList.AddHeaders();
        getAllList.getIDResponse("/boards/" +ReadFromProp.getProperty("idBoard") +"/lists");

    }
}
