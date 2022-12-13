package Boards;

import PropertyConfig.ReadFromProp;
import RestAssured.Base;
import io.restassured.RestAssured;
import org.testng.Assert;

public class DeleteBoard extends Base {

    public DeleteBoard() {
       super();
    }

    @Override
    public void AddQueriesPara() {
        httpRequest.queryParam("key", key);
        httpRequest.queryParam("token", token);
    }

    @Override
    public void AddQueriesPara(String name , String idOrganization) {

    }


    @Override
    public  void AddHeaders(){

        httpRequest.header("Content-Type" , "application/json");
    }

    @Override
    public void AddBody(String displayName, String type, String desc, String teamType, String prefs_permissionLevel, String token) {

    }


    public String getIDResponse(String endPoint) {
        response = httpRequest.delete(endPoint);
        Assert.assertEquals(response.statusCode(), 200);

        System.out.println(response.prettyPrint());
        return null;
    }

    public static void main(String[] args) {
        DeleteBoard deleteBoard = new DeleteBoard();
        deleteBoard.AddQueriesPara();
        deleteBoard.AddHeaders();

        deleteBoard.getIDResponse("/boards/"+ReadFromProp.getProperty("idBoard"));

    }

}
