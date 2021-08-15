package org.acme.rest.json;

public class Whoami {

    public String app;
    public String message;

    public Whoami() {
    }
    public Whoami(String app, String message) {
        this.app = app;
        this.message = message;
    }
}