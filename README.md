# PasstaSOAPServer
SOAP SERVER 

## Dependencies
It is necessary to import the library ´lib/jbcrypt-0.3m.jar´ before compiling.

## How to set the service up
The server endpoint can be run `/PasstaSOAPServer/soapserver/ServerImplement.class`

## Description of the data input
There are 2 services which can be called from a client
1) getProcedure = provides an encrypted version of the generated password.
2) getPassword =  provides a decrypted password.

+ getProcedure 
    It requires:  
    - User Full Name(First and last/family)
    - User Birthdate (dd/mm/yyyy)
    - User ID(length more than 15 prefered and should be unique)
    - Name of the service 

+ getPassword
    It requires 
    - encrypted password
    - User ID (the one used for encrypting)
