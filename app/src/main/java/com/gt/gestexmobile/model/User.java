package com.gt.gestexmobile.model;

public class User {
    public  String use_id;
    public  String use_dni;
    public  String use_names;
    public  String use_lastnames;
    public  String use_email;
    public  String use_phone;
    public  String use_address;
    public  String use_password;
    public  String use_image;
    public Boolean use_active;
    public String[] role;
    public String token;
    public String status;

    public String getUse_id() {
        return use_id;
    }

    public void setUse_id(String use_id) {
        this.use_id = use_id;
    }

    public String getUse_dni() {
        return use_dni;
    }

    public void setUse_dni(String use_dni) {
        this.use_dni = use_dni;
    }

    public String getUse_names() {
        return use_names;
    }

    public void setUse_names(String use_names) {
        this.use_names = use_names;
    }

    public String getUse_lastnames() {
        return use_lastnames;
    }

    public void setUse_lastnames(String use_lastnames) {
        this.use_lastnames = use_lastnames;
    }

    public String getUse_email() {
        return use_email;
    }

    public void setUse_email(String use_email) {
        this.use_email = use_email;
    }

    public String getUse_phone() {
        return use_phone;
    }

    public void setUse_phone(String use_phone) {
        this.use_phone = use_phone;
    }

    public String getUse_address() {
        return use_address;
    }

    public void setUse_address(String use_address) {
        this.use_address = use_address;
    }

    public String getUse_password() {
        return use_password;
    }

    public void setUse_password(String use_password) {
        this.use_password = use_password;
    }

    public String getUse_image() {
        return use_image;
    }

    public void setUse_image(String use_image) {
        this.use_image = use_image;
    }

    public Boolean getUse_active() {
        return use_active;
    }

    public void setUse_active(Boolean use_active) {
        this.use_active = use_active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public User(String use_id, String use_dni, String use_names, String use_lastnames, String use_email, String use_phone, String use_address, String use_password, String use_image, Boolean use_active, String token, String status) {
        this.use_id = use_id;
        this.use_dni = use_dni;
        this.use_names = use_names;
        this.use_lastnames = use_lastnames;
        this.use_email = use_email;
        this.use_phone = use_phone;
        this.use_address = use_address;
        this.use_password = use_password;
        this.use_image = use_image;
        this.use_active = use_active;
        this.token = token;
        this.status = status;
    }
}
