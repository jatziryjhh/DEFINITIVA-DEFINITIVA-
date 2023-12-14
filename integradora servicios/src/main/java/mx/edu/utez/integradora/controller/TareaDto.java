package mx.edu.utez.integradora.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.integradora.model.Tareas;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TareaDto {
    private Integer id;

    private String nombre;

    private String descripcion;

    private String fecha;

    private Integer estado;

    public Tareas toEntity(){
        return Tareas.builder()
                .id(id)
                .nombre(nombre)
                .descripcion(descripcion)
                .fecha(fecha)
                .estado(estado)
                .build();
    }
}
