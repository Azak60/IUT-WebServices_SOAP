/**
 * Company.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package iutservice.jaxws.beans;

public class Company  implements java.io.Serializable {
    private java.lang.String hourClosing;

    private java.lang.String hourOpening;

    private int id;

    private java.lang.String name;

    public Company() {
    }

    public Company(
           java.lang.String hourClosing,
           java.lang.String hourOpening,
           int id,
           java.lang.String name) {
           this.hourClosing = hourClosing;
           this.hourOpening = hourOpening;
           this.id = id;
           this.name = name;
    }


    /**
     * Gets the hourClosing value for this Company.
     * 
     * @return hourClosing
     */
    public java.lang.String getHourClosing() {
        return hourClosing;
    }


    /**
     * Sets the hourClosing value for this Company.
     * 
     * @param hourClosing
     */
    public void setHourClosing(java.lang.String hourClosing) {
        this.hourClosing = hourClosing;
    }


    /**
     * Gets the hourOpening value for this Company.
     * 
     * @return hourOpening
     */
    public java.lang.String getHourOpening() {
        return hourOpening;
    }


    /**
     * Sets the hourOpening value for this Company.
     * 
     * @param hourOpening
     */
    public void setHourOpening(java.lang.String hourOpening) {
        this.hourOpening = hourOpening;
    }


    /**
     * Gets the id value for this Company.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Company.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the name value for this Company.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Company.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
}
