package RestClientMaven.RestClientMaven;

import java.net.URI;  
import javax.ws.rs.client.Client;  
import javax.ws.rs.client.ClientBuilder;  
import javax.ws.rs.client.WebTarget;  
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;  
//import org.glassfish.jersey.client.ClientConfig;  
public class JersyGetClient {  
  public static void main(String[] args) {  
    //ClientConfig config = new ClientConfig();  
    Client client = ClientBuilder.newClient();  
    WebTarget target = client.target(getBaseURI());  
    //Now printing the server code of different media type  
    //System.out.println(target.request().accept(MediaType.TEXT_PLAIN).get(String.class));  
    System.out.println(target.queryParam("pickupLat", "13.0691658").queryParam("pickupLng", "80.1913883").queryParam("pickupMode", "NOW").queryParam("dropLat", "13.0381896").queryParam("dropLng", "80.156546").queryParam("silent", "true")
            .request(MediaType.APPLICATION_JSON).header("x-fingerprint-id", "442665447")
            .get(String.class));
    //System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class));  
  }  
  private static URI getBaseURI() {  
    return UriBuilder.fromUri("https://book.olacabs.com/data-api/category-availability/p2p?pickupLat=13.0691658&pickupLng=80.1913883&pickupMode=NOW&dropLat=13.0381896&dropLng=80.1565461&silent=true").build();  
  }  
}   