package BusinessLogic;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jasperhessellund on 13/12/2016.
 */

public class UserTest {

    User u = new User("clint", "123", 0, new UserInformation("clint", "ras", "vej"
    , 2000, "clinten@hotmail.com", 2020202020));
    @Before
    public void setUp() throws Exception {
        u.setOwnUsername("clint");
    }


    @Test
    public void getOwnUsername() throws Exception {
        assertEquals("clint", u.getOwnUsername());
    }

    @Test
    public void getUserInformation() throws Exception {
        UserInformation u1 = new UserInformation("clint", "ras", "vej"
                , 2000, "clinten@hotmail.com", 2020202020);

        assertEquals(u1.getMobil(), u.getUserInformation().getMobil());
    }

}