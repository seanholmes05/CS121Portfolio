import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML_Read {
    public static void main(String[] args) {
        try
        {
            File input = new File("cars.xml");
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = Factory.newDocumentBuilder();
            Document doc = builder.parse(input);

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList carList = doc.getElementsByTagName("car");
            for (int i=0;i<carList.getLength();i++){
                Node node =carList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("ID: " + element.getAttribute("id"));
                    System.out.println("Make: " + element.getElementsByTagName("make").item(0).getTextContent());
                    System.out.println("Model: " + element.getElementsByTagName("model").item(0).getTextContent());
                    System.out.println("Year: " + element.getElementsByTagName("year").item(0).getTextContent());
                    System.out.println();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
