package com.example.SaleModule.Permission;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete"),

    CASHIER_READ("cashier:read"),
    CASHIER_UPDATE("cashier:update"),
    CASHIER_DELETE("cashier:delete"),
    CASHIER_CREATE("cashier:create");


    @Getter
    private final String permission;
}