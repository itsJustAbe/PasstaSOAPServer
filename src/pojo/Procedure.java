package pojo;

import java.io.Serializable;

/**
 * Class representing the procedure (ENCRYPTED password) in the the system
 */
public class Procedure implements Serializable {

     private String id;

    /**
     * Label of the service associated to the password
     */
     private String serviceName;

    /**
     * Encrypted password, stored in the system
     */
     private String procedure;

    /**
     * pojo.User ID of the password owner in the system
     */
     private String owner;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "pojo.Procedure{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", procedure='" + procedure + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
