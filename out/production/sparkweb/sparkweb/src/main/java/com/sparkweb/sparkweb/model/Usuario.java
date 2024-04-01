package model;

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
