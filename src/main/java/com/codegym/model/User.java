package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String userName;
    private String passWord;
    private Date dob;
    private String address;
    private String phone;
    private boolean status;

    @ManyToOne
    @JoinColumn (name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;
}
