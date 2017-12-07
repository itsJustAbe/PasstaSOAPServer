import pojo.Password;
import pojo.Procedure;
import pojo.User;
import soapserver.PasswordGenerationServer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class ClientTest {

        public static void main(String[] args) throws Exception {
            URL wsdlUrl = new
                    URL("http://localhost:9000/PasswordService/server?wsdl");

            QName qname = new QName("http://soapserver/", "PasswordGenerationServer");

            Service service = Service.create(wsdlUrl, qname);

            PasswordGenerationServer passwordService = service.getPort(PasswordGenerationServer.class);

            Procedure procedure;
            User user = new User();
            Password pass = new Password();

            user.setFirstName("shivam");
            user.setLastName("sachdeva");
            user.setUserID("5a281b2388a7675aed00fb55");
            user.setBirthdate(101111110200051996L);
            user.setEmail("techno848@gmail.com");
            user.setGender("male");
            String serviceName = "www.facebook.com";


            procedure = passwordService.getProcedure(serviceName, user);

            procedure.setId("dsfsgsdfg");
            pass = passwordService.getPassword(procedure);

            System.out.println(procedure);
            System.out.println(pass);

        }
    }

