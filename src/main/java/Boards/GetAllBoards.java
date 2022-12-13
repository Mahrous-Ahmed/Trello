package Boards;

import PropertyConfig.ReadFromProp;
import RestAssured.Base;

public class GetAllBoards extends Base {


    @Override
    public void AddQueriesPara() {

    }

    @Override
    public void AddQueriesPara(String name , String idOrganization) {
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
        response = httpRequest.get(endPoint);
        System.out.println(response.prettyPrint());
        //Assert.assertEquals(response.statusCode(), 200);
        return response.getBody().path("id").toString();
    }

    public static void main(String[] args) {
        GetAllBoards getAllBoards = new GetAllBoards();
        getAllBoards.AddQueriesPara("Java Board",ReadFromProp.getProperty("idOrganization"));
        getAllBoards.AddHeaders();

        getAllBoards.getIDResponse("/members/"+ getAllBoards.username);

    }
}
