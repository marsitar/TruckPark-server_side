package com.sitarski.truckparkserver.configuration;

public enum KeyCloakRoles {
    USER("user");

    public final String value;

    private KeyCloakRoles(String value) {
        this.value = value;
    }
}
