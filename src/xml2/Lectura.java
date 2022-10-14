package xml2;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Lectura {
    public static void main(String[] args) {
        try {

            int contadorProductos = 0;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("src/xml2/compras.xml");

            doc.getDocumentElement().normalize();
            System.out.println("Elemento raiz:" + doc.getDocumentElement().getNodeName());

            NodeList listaCompras = doc.getElementsByTagName("compra");

            for (int i = 0; i < listaCompras.getLength(); i++) {

                Node compra = listaCompras.item(i);
                System.out.println("Compra " + i+1);
                System.out.println("==========");

                NodeList datosCompra = compra.getChildNodes();

                for (int j = 0; j < datosCompra.getLength(); j++) {
                    Node nodoCompra = datosCompra.item(j);
                    if (nodoCompra.getNodeType() == Node.ELEMENT_NODE) {
                        Node datoContenidoCompra = nodoCompra.getFirstChild();
                        System.out.println(nodoCompra.getNodeName() + ": " + datoContenidoCompra.getNodeValue());

                        NodeList datosTicket = nodoCompra.getChildNodes();

                        for (int k = 0; k < datosTicket.getLength(); k++) {
                            Node nodoTicket = datosTicket.item(k);
                            if (nodoTicket.getNodeType() == Node.ELEMENT_NODE) {
                                Node datoContenidoTicket = nodoTicket.getFirstChild();
                                System.out.println(nodoTicket.getNodeName() + ": " + datoContenidoTicket.getNodeValue());

                                NodeList datosProducto = nodoTicket.getChildNodes();

                                for (int l = 0; l < datosProducto.getLength(); l++) {
                                    Node nodoProducto = datosProducto.item(l);
                                    if (nodoProducto.getNodeType() == Node.ELEMENT_NODE) {
                                        Node datoContenidoProducto = nodoProducto.getFirstChild();
                                        System.out.println(nodoProducto.getNodeName() + ": " + datoContenidoProducto.getNodeValue());

                                    }

                                }
                            }

                        }
                    }
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
