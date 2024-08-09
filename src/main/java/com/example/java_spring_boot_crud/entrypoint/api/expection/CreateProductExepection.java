package com.example.java_spring_boot_crud.entrypoint.api.expection;

public class CreateProductExepection extends RuntimeException {

    public CreateProductExepection() {
        super("Não foi possível criar um novo produto");
    }

    public CreateProductExepection(String msg) {
        super(msg);
    }
}
