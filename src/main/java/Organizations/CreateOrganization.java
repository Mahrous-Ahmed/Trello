package Organizations;

import PropertyConfig.ReadFromProp;
import RestAssured.Base;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;


class CreateOrganization extends Base {

    public CreateOrganization() {
        super();
    }

    @Override
    public void AddQueriesPara() {
        httpRequest.queryParam("key", key);
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
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("displayName",displayName);
        jsonObject.put("type",type);
        jsonObject.put("desc",desc);
        jsonObject.put("teamType",teamType);
        jsonObject.put("prefs_permissionLevel",prefs_permissionLevel);
        jsonObject.put("token",token);
        httpRequest.body(jsonObject.toString());
    }

    @Override
    public String getIDResponse(String endPoint) {
        response = httpRequest.post(endPoint);

        Assert.assertEquals(response.statusCode(), 200);
        ReadFromProp.setProperty("idOrganization",response.getBody().path("id").toString());
        System.out.println(response.getBody().path("id").toString());
        return response.getBody().path("id").toString();
    }







    public static void main(String[] args) {
        CreateOrganization addAnOrganization = new CreateOrganization();
        addAnOrganization.AddQueriesPara();
        addAnOrganization.AddHeaders();
        addAnOrganization.AddBody("Java","default","","education","private", addAnOrganization.token);
        addAnOrganization.getIDResponse("/organizations");

    }

}


