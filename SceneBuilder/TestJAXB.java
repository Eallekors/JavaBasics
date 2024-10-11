package SceneBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class TestJAXB {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            TestPerson person = new TestPerson("John", "Doe");

            // Create a JAXB context for the Person class
            JAXBContext context = JAXBContext.newInstance(TestPerson.class);

            // Create a Marshaller
            Marshaller marshaller = context.createMarshaller();

            // Set formatting for the output XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshal the person instance to System.out (or a file)
            marshaller.marshal(person, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
