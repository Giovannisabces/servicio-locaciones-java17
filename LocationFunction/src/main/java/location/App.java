package location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
// import com.amazonaws.serverless.proxy.model.Headers;
/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<Request, Object> {

    @Override
    public Object handleRequest(Request request, Context context) {
        AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(db);
        Location location = null;
        AwsProxyResponse response = new AwsProxyResponse();
        Map<String, String> headers = new HashMap<String, String>();
        // Headers headersMultivHeaders = new Headers();
        headers.put("Access-Control-Allow-Headers","Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token");
        // headersMultivHeaders.add("Access-Control-Allow-Headers","Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token" );
        headers.put("Access-Control-Allow-Methods","*");
        headers.put("Access-Control-Allow-Origin","*");
        // response.setMultiValueHeaders(headersMultivHeaders);
        response.setHeaders(headers);
        response.setStatusCode(200);
        response.setBody("It's Done");

        switch(request.getHttpMethod().toUpperCase()) {
            case "GET": 
                if ( request.getId() == 0){
                    List<Location> locations = new ArrayList<>();
                    locations = mapper.scan(Location.class, new DynamoDBScanExpression());
                    
                    response.setBody(getList(locations));
                    return response;
                }else{
                    location = mapper.load(Location.class, request.getId());
                    response.setBody(location.toString());
                    return response;
                }
            case "POST":
                location = request.getLocation();
                mapper.save(location);
                return location;
            case "DELETE":
                location = mapper.load(Location.class, request.getId());
                mapper.delete(location);
                return location;
        }
        return null;
    }
    public String getList(List<Location> locations){
        if (locations.size() == 0) return "[]";
        String body = "[\n";
        for (int i = 0; i < locations.size(); i++){
            body += locations.get(i).toString()+",\n";
            if(i==(locations.size()-1)) body += locations.get(i).toString()+"\n]";
        }
        return body;
    }
}
//mvn clean (esto es para limpiar y eliminar toda compilacion previa)
//mvn package -DskipTests=true (Esto es para generar ejecutable .jar)