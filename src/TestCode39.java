import junit.framework.*;

/**
 * Created by heathcliff on 11/3/16.
 */
public class TestCode39 extends TestCase
{
    public void testCalculer() throws Exception
    {
        // empty string
        assertEquals(Code39.encoder(""), "**");
        // strings
        assertEquals(Code39.encoder("ABC"), "*ABC*");
        assertEquals(Code39.encoder("abc"), "*ABC*");
        assertEquals(Code39.encoder("A b C"), "*A B C*");
        assertEquals(Code39.encoder("A1b2c3"), "*A1B2C3*");

        // string with allowed characters
        assertEquals(Code39.encoder("a/bc"), "*A/BC*");
        assertEquals(Code39.encoder("a-bc"), "*A-BC*");
        assertEquals(Code39.encoder("$abc"), "*$ABC*");
        assertEquals(Code39.encoder("a-b+c"), "*A-B+C*");
        assertEquals(Code39.encoder("/a%b$c."), "*/A%B$C.*");

        assertEquals(Code39.encoder("[abc]"), "*ABC*");
        assertEquals(Code39.encoder("a)|]b^[#\"]}c"), "*ABC*");
        assertEquals(Code39.encoder("abcàâäêéèëîïôöùûü"), "*ABC*");


        // empty string
        assertEquals(Code39.encoder2(""), "*0*");
        // strings
        assertEquals(Code39.encoder2("ABC"), "*ABCX*");
        assertEquals(Code39.encoder2("abc"), "*ABCX*");
        assertEquals(Code39.encoder2("A b C"), "*A B CN*");
        assertEquals(Code39.encoder2("A1b2c3"), "*A1B2C3$*");

        // string with allowed characters
        assertEquals(Code39.encoder2("a/bc"), "*A/BCU*");
        assertEquals(Code39.encoder2("a-bc"), "*A-BCQ*");
        assertEquals(Code39.encoder2("$abc"), "*$ABCT*");
        assertEquals(Code39.encoder2("a-b+c"), "*A-B+CO*");
        assertEquals(Code39.encoder2("/a%b$c."), "*/A%B$C.J*");

        assertEquals(Code39.encoder2("[abc]"), "*ABCX*");
        assertEquals(Code39.encoder2("a)|]b^[#\"]}c"), "*ABCX*");
        assertEquals(Code39.encoder2("abcàâäêéèëîïôöùûü"), "*ABCX*");
    }
}
