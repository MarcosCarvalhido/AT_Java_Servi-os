package com.sparkweb.sparkweb.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue
    private long id;
    private  String nome;
    private  String senha;
}
