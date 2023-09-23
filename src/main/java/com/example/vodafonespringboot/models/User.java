package com.example.vodafonespringboot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {
    // Declaración de variables.
    // Contiene un id único
    @Id
    private String id;              //Id único, se crea de forma automática para evitar errores
    private String name;            //Nombre del usuario
    private String lastName;        //Appellidos del usuario
    private int age;                //Edad del usuario
    private boolean isEnabled;      //True si el usuario está habilitado, false en caso contrario
    private float pointQuantity;    //Puntos del usuario


    // ------------------------------------- CONSTRUCTORES--------------------------------------
    public User() {

    }
    public User(String name, String lastName, int age, boolean isEnabled, float pointQuantity) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.isEnabled = isEnabled;
        this.pointQuantity = pointQuantity;
    }
    // -----------------------------------------------------------------------------------------

    // ---------- Getters -----------
    // Funciones para consulta de
    // variables
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public float getPointQuantity() {
        return pointQuantity;
    }
    // ------------------------------

    // -------------------- setters -------------------
    // Funciones para el setteo de variables
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setPointQuantity(float pointQuantity) {
        this.pointQuantity = pointQuantity;
    }

    public void addPoints(float pointQuantity) {
        //Esta función suma los puntos de entrada a los
        //puntos totales que tenía el usuario
        this.pointQuantity += pointQuantity;
    }
    // ------------------------------------------------
}
