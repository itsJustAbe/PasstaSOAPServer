package soapserver;

import pojo.Password;
import pojo.Procedure;
import pojo.User;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PasswordGenerationServer {

    /**
     * Retrieve a procedure form the remote server
     *
     * @param service  name of the service for the new procedure
     * @param userInfo password owner's information
     * @return generated procedure
     */
    @WebMethod
    Procedure getProcedure(String service, User userInfo);

    /**
     * Decrypt a procedure and receive a password from the remote server
     *
     * @param procedure encryped procedure
     * @return retrieved password
     */
    @WebMethod
    Password getPassword(Procedure procedure);
}
