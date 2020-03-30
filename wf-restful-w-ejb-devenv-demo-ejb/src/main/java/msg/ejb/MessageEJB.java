package msg.ejb;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Stateless
public class MessageEJB {
    
    private final List<Integer>  list= new ArrayList();

    public List<Integer> getMessage() {
        Random r = new Random();
        for(int i=0;i<10;i++){
            list.add(r.nextInt());
        }
        return list;
    }
}