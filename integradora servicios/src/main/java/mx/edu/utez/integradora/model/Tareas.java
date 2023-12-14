package mx.edu.utez.integradora.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tareas")
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

     @Column(name = "descripcion")
    private String descripcion;

     @Column(name = "fecha")
    private String fecha;

     @Column(name = "estado")
    private Integer estado;


}
