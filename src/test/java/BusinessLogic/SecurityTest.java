package BusinessLogic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jasperhessellund on 13/12/2016.
 */
public class SecurityTest {
    @Test
    public void hashpw() throws Exception {
        assertEquals(Security.hashpw("123"), Security.hashpw("123"));
        assertNotEquals(Security.hashpw("123"), "123");
        assertNotEquals(Security.hashpw("1234"), Security.hashpw("123"));
    }

}