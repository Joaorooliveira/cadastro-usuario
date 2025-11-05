package br.com.joaov.cadastrousuario.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email",unique = true) // Quer dizer q o nome da tabela e email e esse atributo e unico
    private String email;

    @Column(name= "nome")
    private String nome;


}
