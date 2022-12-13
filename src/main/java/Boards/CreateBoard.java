package Boards;


import PropertyConfig.ReadFromProp;
import RestAssured.Base;
import org.testng.Assert;

public class CreateBoard extends Base {


    @Override
    public void AddQueriesPara() {

    }

    @Override
    public void AddQueriesPara(String name , String idOrganization) {
        httpRequest.queryParam("name", name);
        httpRequest.queryParam("idOrganization", idOrganization);
        httpRequest.queryParam("key", key);
        httpRequest.queryParam("token", token);
    }


    @Override
    public  void AddHeaders(){

        httpRequest.header("Content-Type" , "application/json");
    }

    @Override
    public void AddBody(String displayName, String type, String desc, String teamType, String prefs_permissionLevel, String token) {

    }


    public String getIDResponse(String endPoint) {
        response = httpRequest.post(endPoint);
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
        ReadFromProp.setProperty("idBoard",response.getBody().path("id").toString());
        System.out.println(response.getBody().path("id").toString());
        return response.getBody().path("id").toString();
    }

    public static void main(String[] args) {
        CreateBoard createBoard = new CreateBoard();
        createBoard.AddQueriesPara("Java Board",ReadFromProp.getProperty("idOrganization"));
        createBoard.AddHeaders();

        createBoard.getIDResponse("/boards");

    }


}
