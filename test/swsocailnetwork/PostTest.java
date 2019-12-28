
package swsocailnetwork;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class PostTest {
    
    SWSocailNetwork obj;
    List list;
    User u;
    
    @Before
    public void setUp() {
        obj = new SWSocailNetwork();
        list= obj.AllUsers;
        u= new User();
    }
        

    @Test
    public void testSignUp() {        
        boolean log = obj.signUp("hassan", "221");
        assertEquals(false,log);
    }
    
    @Test
    public void sendRequest() {        
        boolean log =u.sendRequest("hassan", list);
        assertEquals(true,log);
    }
    
    
}
