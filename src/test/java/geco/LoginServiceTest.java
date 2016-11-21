package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {
    private static final String ANEM = "ANEM";
    private static final String ABIL = "ABIL";
    private LoginService ls;
    @Before
    public void setUp() throws Exception {
        String[] start = new String[1];
        start[0] = ANEM;
        ls = new LoginService(start);
    }

    @Test
    public void testLoginExists() throws Exception {
        boolean res = ls.loginExists(ANEM);
        Assert.assertTrue(res);
        res = ls.loginExists(ABIL);
        Assert.assertFalse(res);
    }

    @Test
    public void testAddLogin() throws Exception {
        ls.addLogin("AAA");
        ls.addLogin("AAA");
        List<String> allLogins = ls.findAllLogins();
        Assert.assertEquals(3, allLogins.size());
    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        List<String> allLogins = ls.findAllLogins();
        Assert.assertEquals(3, allLogins.size());
        ls.addLogin("AAA");
        allLogins = ls.findAllLoginsStartingWith("A");
        Assert.assertEquals(2, allLogins.size());
        allLogins = ls.findAllLoginsStartingWith("B");
        Assert.assertEquals(0, allLogins.size());
    }

    @Test
    public void testFindAllLogins() throws Exception {
        List<String> allLogins = ls.findAllLogins();
        Assert.assertEquals(1, allLogins.size());
        ls.addLogin("AAA");
        allLogins = ls.findAllLogins();
        Assert.assertEquals(2, allLogins.size());
    }
}