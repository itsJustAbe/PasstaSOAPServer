package soapserver;

import passwordgenerator.Passgen;
import pojo.Password;
import pojo.Procedure;
import pojo.User;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService(name= "PasswordGenerationServer", serviceName = "PasswordGenerationServer")
@SOAPBinding(style = SOAPBinding.Style.RPC, use= SOAPBinding.Use.LITERAL)
public class ServerImplement implements PasswordGenerationServer {

    public static void main(String args[]) throws Exception {
        Endpoint.publish("http://localhost:9000/PasswordService/server", new ServerImplement());
    }

    @Override
    public Procedure getProcedure(String service, User userInfo) {
        return (new Passgen()).start("encrypt", userInfo, service);

    }

    @Override
    public Password getPassword(Procedure procedure) {
        return (new Passgen()).decrypt(procedure);
    }
}
