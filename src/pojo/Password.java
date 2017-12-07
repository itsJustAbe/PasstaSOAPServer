package pojo;

import java.io.Serializable;

/**
 * Class representing the DECRYPTED password in the system
 */
public class Password implements Serializable {

    private String id;

    /**
     * Label of the service associated to the password
     */
    private String serviceName;

    /**
     * Actual decrypted password
     */
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "pojo.Password{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", password='" + password + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
