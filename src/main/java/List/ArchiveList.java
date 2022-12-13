package List;

import PropertyConfig.ReadFromProp;
import RestAssured.Base;

public class ArchiveList extends Base {
    public ArchiveList() {
        super();
    }

    @Override
    public void AddQueriesPara() {
        httpRequest.queryParam("value", "1");
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
        response = httpRequest.put(endPoint);
        //Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.prettyPrint());
        return null;
    }







    public static void main(String[] args) {
        ArchiveList archiveList = new ArchiveList();
        archiveList.AddQueriesPara();
        archiveList.AddHeaders();
        archiveList.getIDResponse("/lists/"+ ReadFromProp.getProperty("idList")+"/closed");

    }
}
