package RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Optional;

import java.util.Hashtable;

public abstract class Base {
    protected String path = "";

    protected final String baseUrl = "https://api.trello.com/1";
    protected  final String key = "24add5103583a8a3b0a4f0fc6373e478";
    protected final String token = "c92e3263bcda70d4a0b94870a1eb76bae8d5c404ab80cafc5b91f6b32d3ec51a";
    public final String username = "mahrousahmed4";

    protected RequestSpecification httpRequest;
    protected Response response;

    public Base() {
        RestAssured.baseURI = baseUrl;
        httpRequest = RestAssured.given();

    }
    public abstract void AddQueriesPara();
    public abstract void AddQueriesPara(String name , String Id);

    public abstract void AddHeaders();


    public abstract void AddBody(String displayName , String type , String desc , String teamType , String prefs_permissionLevel , String token);


    public abstract String getIDResponse(String endPoint);





}
