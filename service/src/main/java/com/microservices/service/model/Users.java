package com.microservices.service.model;

import java.util.Set;





public class Users {
	
	
	
    private int id;

    
    private String email;

   
    private String name;
    
    private String password;
   
    private String lastName;
    
    
    
    
    private Set<Role> roles;


    public Users() {
    }

    public Users(Users users) {

        
        this.email = users.email;
        this.id = users.id;
        this.lastName = users.lastName;
        this.name = users.name;
        this.password = users.password;
        this.roles = users.roles;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}