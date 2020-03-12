package com.example.movienigth.Model;

public class ModelClient {

    int id_client;
    int id;
    String first_name;
    String last_name;
    String ci;
    int cellphone;
    String email;
    String address;
    String latitude;
    String longitude;
    String birthdate;
    int status;

    public ModelClient(int id, String first_name, String last_name, String ci, int cellphone, String email, String address, String latitude, String longitude, String birthdate, int status) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.ci = ci;
        this.cellphone = cellphone;
        this.email = email;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.birthdate = birthdate;
        this.status = status;
    }

    public ModelClient(int id_client, int id, String first_name, String last_name, String ci, int cellphone, String email, String address, String latitude, String longitude, String birthdate, int status) {
        this.id_client = id_client;
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.ci = ci;
        this.cellphone = cellphone;
        this.email = email;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.birthdate = birthdate;
        this.status = status;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
