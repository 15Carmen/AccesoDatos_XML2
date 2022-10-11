package xml2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LecturaDOM {
    public static void main(String[] args) {

       try {
           File file = new File("C:\\Users\\cmartin\\eclipse-workspace\\AccesoDatos_XML2\\src\\compras.xml");

           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(file);

           // estos métodos podemos usarlos combinados para normalizar el archivo XML
           doc.getDocumentElement().normalize();

           System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
           NodeList nList = doc.getElementsByTagName("compra");
           System.out.println("----------------------------");

           for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
               System.out.println("\nCurrent Element :" + nNode.getNodeName());
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                   Element eElement = (Element) nNode;
                   System.out.println("Fecha: " +  eElement.getElementsByTagName("fecha").item(0).getTextContent());
                   System.out.println("Ticket: " + eElement.getElementsByTagName("ticket").item(0).getTextContent());
               }
           }

       }catch (Exception e){

       }
    }
}