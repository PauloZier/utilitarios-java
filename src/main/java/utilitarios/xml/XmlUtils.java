package utilitarios.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public final class XmlUtils {

	private XmlUtils() {}
	
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(String xml, Class<T> cls) {
		
		try {
		
			JAXBContext jaxbContext = JAXBContext.newInstance(cls);              
			 
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 
		    return (T) jaxbUnmarshaller.unmarshal(new StringReader(xml));
		    
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	public static <T> String serialize(T obj) {
		
		try {
		
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());              
			 
			Marshaller marshaller = jaxbContext.createMarshaller();
		 
			StringWriter writer = new StringWriter();
			
		    marshaller.marshal(obj, writer);
		    
		    return writer.toString();
		    
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
}
