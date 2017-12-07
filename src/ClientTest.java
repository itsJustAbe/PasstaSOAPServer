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
            user.setBirthdate(130000051996L);
            user.setEmail("techno848@gmail.com");
            user.setGender("male");
            String serviceName = "www.facebook.com";


            //pass.setPassword("$00552a$101000$23O0f/b0a00JbC84f1vwR35VjGa1RnKAKTS" +
                    //"2eHxhqq2kW.WQU41oAH2xif79111db9c9sWDz5mff5Q67y92a$11f888302$3f9Z3uf.Fg7Hk309");

            procedure = passwordService.getProcedure(serviceName, user);

            procedure.setId("dsfsgsdfg");
            pass = passwordService.getPassword(procedure);

            System.out.println(procedure);
            System.out.println(pass);

        }
    }

