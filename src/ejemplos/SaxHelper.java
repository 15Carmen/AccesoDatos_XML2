package ejemplos;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class SaxHelper extends DefaultHandler {

    //comienzo del documento
    public void startDocument() throws SAXException {
        System.out.println("startDocument");
    }

    //fin del documento
    public void endDocument() throws SAXException {
        System.out.println("endDocument");
    }

    //texto dentro de etiquetas
    public void characters(char[] ch, int start, int length) throws SAXException {

        String charString = new String(ch, start, length);
        System.out.println("caracteres: " + charString);
    }

    //etiqueta de apertura, puede contener atributos
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println("startElement: " + qName);
        // Lista atributos y sus valores
        for (int i=0; i<atts.getLength(); i++) {
            System.out.println("Atributo: " + atts.getLocalName(i));
            System.out.println("\tValor: " + atts.getValue(i));
        }
    }

    //etiqueta de cierre
    public void endElement(String nameSpaceURI, String localName, String qName) throws SAXException {
        System.out.println("endElement: " + qName);
    }

    //espacio en blanco que se puede ignorar
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println(length + " caracteres en blanco ignorables");
    }

    //comienzo de espacio de nombres
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Comienza prefijo de namespace: " + prefix);
    }

    //fin de espacio de nombres
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("Termina prefijo de namespace: " + prefix);
    }

    //instrucción de procesamiento
    public void processingInstruction(String instruction, String data) throws SAXException {
        System.out.println("Instrucción: " + instruction + ", datos: " + data);
    }

    //entidad que no se desea resolver, por lo que se ignora
    public void skippedEntity(String name) throws SAXException {
        System.out.println("Entidad saltada: " + name);
    }

}