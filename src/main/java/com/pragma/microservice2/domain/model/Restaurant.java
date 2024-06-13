package com.pragma.microservice2.domain.model;

public class Restaurant {

    private final String name;
    private final String nit;
    private final String address;
    private final String phone;
    private final String logo;
    private final String dniOwner;

    public Restaurant(String name, String nit, String address, String phone, String logo, String dniOwner) {
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.logo = logo;
        this.dniOwner = dniOwner;
    }

    public String getNit() {
        return nit;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getLogo() {
        return logo;
    }

    public String getDniOwner() {
        return dniOwner;
    }

    public String getName() {
        return name;
    }
}
