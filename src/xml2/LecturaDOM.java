package xml2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LecturaDOM {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        try {
            File file = new File("src/xml2/compras.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            // estos métodos podemos usarlos combinados para normalizar el archivo XML
            doc.getDocumentElement().normalize();
            System.out.println(doc.getDocumentElement().getNodeName());

            NodeList comprasLista = doc.getElementsByTagName("compra");
            System.out.println("----------------------------");

            for (int i = 0; i < comprasLista.getLength(); i++) {

                Node compra = comprasLista.item(i);
                System.out.println("Compra "+ i+1);
                NodeList datosCompra=compra.getChildNodes();

                for (int j = 0; j < datosCompra.getLength(); j++) {

                    Node nodoCompra = datosCompra.item(j);
                    if (nodoCompra.getNodeType() == Node.ATTRIBUTE_NODE){
                        Node datoContenidoCompra = nodoCompra.getFirstChild();
                        System.out.println(nodoCompra.getNodeName()+": "+ datoContenidoCompra);


                    }
                }

            }

        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
            throw new RuntimeException(e);
        }

    }
}