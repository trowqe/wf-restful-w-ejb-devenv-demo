package msg.rs;

import msg.ejb.MessageEJB;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.persistence.criteria.CriteriaBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//http://localhost:8080/unnamed1/api/message

@Path("/message")
public class MessageResource {

    @EJB
    private MessageEJB messageEJB;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() { 
        
        List <Integer> list = messageEJB.getMessage(); 
        
        Map <Integer, Integer> map = new HashMap<>();
        
        list.stream()
                .forEach(x->{map.put(list.indexOf(x), x);});

        JSONObject json = new JSONObject(map);

        return json.toString();
    }
}
