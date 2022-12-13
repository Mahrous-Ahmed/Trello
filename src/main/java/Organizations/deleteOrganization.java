package Organizations;

import PropertyConfig.ReadFromProp;
import RestAssured.Base;
import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.Assert;

public class deleteOrganization extends Base {
    public deleteOrganization() {
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

    }


    @Override
    public void AddBody(String displayName , String type , String desc , String teamType , String prefs_permissionLevel , String token){
    }

    @Override
    public String getIDResponse(String endPoint) {
        return null;
    }


    public void DeleteAnOrganization(String endPoint , String idOrganization) {

        response = httpRequest.delete( endPoint + "/"+ idOrganization);
        Assert.assertEquals(response.statusCode(), 200);
    }





    public static void main(String[] args) {
        deleteOrganization deleteOrganization = new deleteOrganization();
        deleteOrganization.AddQueriesPara();
        deleteOrganization.DeleteAnOrganization("/organizations", ReadFromProp.getProperty("idOrganization"));

    }

}
