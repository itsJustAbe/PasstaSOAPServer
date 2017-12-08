package soapserver;

import passwordgenerator.Passgen;
import pojo.Password;
import pojo.Procedure;
import pojo.User;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;


@WebService(name= "PasswordGenerationServer",
        serviceName = "PasswordGenerationServer",
        targetNamespace = "http://soapservice" )
@SOAPBinding(style = SOAPBinding.Style.RPC, use= SOAPBinding.Use.LITERAL)
public class ServerImplement implements PasswordGenerationServer {

    private static final String address ="http://localhost:9000/PasswordService/server";
    Passgen passgen = new Passgen();


    public static void main(String args[]) throws Exception {
        Endpoint.publish(address, new ServerImplement());
    }

    @Override
    public Procedure getProcedure(String service, User userInfo) {
        return passgen.encryptPassword(userInfo, service);

    }

    @Override
    public Password getPassword(Procedure procedure) {

        return passgen.decryptPassword(procedure);
    }
}
