package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@NotEmpty(message = "Id không được để trống")
    @Size(min=6,max = 45,message = "id phải gồm từ 5-45 ký tự")
    @Pattern(regexp ="\\b[a-z0-9]*\\b",message = "Id chưa đúng định dạng")
    private String id;
   // @NotEmpty(message = "Pass không được để trống")
    @Size(min=6,max = 45,message = "Pass phải từ 5 đến 45 kí tự")
    private String password;

   // @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;


    public User() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
