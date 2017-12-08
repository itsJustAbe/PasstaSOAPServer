# PasstaSOAPServer
SOAP SERVER 

There are 2 services which can be called from a client
1) getProcedure = provides an encrypted version of the generated password.
2) getPassword =  provides a decrypted password.

1) getProcedure 
  It requires:  
    - User Full Name(First and last/family)
    - User Birthdate (dd/mm/yyyy)
    - User ID(length more than 15 prefered and should be unique)
    - Name of the service 

2) getPassword
  It requires 
    - encrypted password
    - User ID (the one used for encrypting)