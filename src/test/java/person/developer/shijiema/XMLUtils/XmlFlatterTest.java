package person.developer.shijiema.XMLUtils;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.xml.xpath.XPathExpressionException;
import java.util.Iterator;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class XmlFlatterTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public XmlFlatterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( XmlFlatterTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testXmlFlatter() throws XPathExpressionException {
        String xml2 = "<Relations><Relationship bala=\"ddd\">        <id>1</id>        <Type>match</Type>        <Weight>1.0</Weight>        <Score>100.0</Score>    </Relationship>        <Relationship>        <id>2</id>        <Type>match</Type>        <Weight>1.0</Weight>        <Score>90.0</Score>    </Relationship></Relations>";

        XmlFlatter o = new XmlFlatter(xml2);
        Assert.assertEquals(o.getHeaders().size(),5);
        Assert.assertEquals(o.getHeaders().get(0),"Relations_Relationship_bala");
        Assert.assertEquals(o.getHeaders().get(4),"Relations_Relationship_Score");
        Assert.assertNotNull(o.getBody());
        Assert.assertEquals(o.getBody().size(),2);
        Assert.assertEquals(o.getBody().get(0).get("Relations_Relationship_bala"),"ddd");
        Assert.assertNull(o.getBody().get(1).get("Relations_Relationship_bala"));
        Assert.assertEquals(o.getBody().get(1).get("Relations_Relationship_Score"),"90.0");
        System.out.println("iterating:");
        Iterator<List<String>> it = o.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        assertTrue( true );
    }
}