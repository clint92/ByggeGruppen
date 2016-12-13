package BusinessLogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jasperhessellund on 13/12/2016.
 */
public class MessageTest {
    Message msg = new Message("projectName", "20-20-17", "Hello", "clint");
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void getTimelineID() throws Exception {
        assertEquals(msg.getTimelineID(), "projectName");
    }

    @Test
    public void getDateAndTime() throws Exception {
        assertEquals(msg.getDateAndTime(), "20-20-17");
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals(msg.getDescription(), "Hello");
    }

    @Test
    public void getPicture() throws Exception {
        assertEquals(msg.getPicture(), null);
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals(msg.getFirstName(), "clint");
    }

}