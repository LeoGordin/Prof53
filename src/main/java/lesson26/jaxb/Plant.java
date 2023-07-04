package lesson26.jaxb;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Plant {
    private String plantid;
    private String common;
    private String botanical;
    private String zone;
    private String light;
    private String price;
    private String availability;

    public String getPlantid() {
        return plantid;
    }
    @XmlAttribute(name = "Plantid")
    public void setPlantid(String plantid) {
        this.plantid = plantid;
    }

    public String getCommon() {
        return common;
    }
    @XmlAttribute(name = "COMMON")
    public void setCommon(String common) {
        this.common = common;
    }

    public String getBotanical() {
        return botanical;
    }
    @XmlAttribute(name = "BOTANICAL")
    public void setBotanical(String botanical) {
        this.botanical = botanical;
    }

    public String getZone() {
        return zone;
    }
    @XmlAttribute(name = "ZONE")
    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getLight() {
        return light;
    }
    @XmlAttribute(name = "LIGHT")
    public void setLight(String light) {
        this.light = light;
    }

    public String getPrice() {
        return price;
    }
    @XmlAttribute(name = "PRICE")
    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }
    @XmlAttribute(name = "AVAILABILITY")
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "plantID='" + plantid + '\'' +
                ", common='" + common + '\'' +
                ", botanical='" + botanical + '\'' +
                ", zone='" + zone + '\'' +
                ", light='" + light + '\'' +
                ", price='" + price + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
