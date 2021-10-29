package equipo1.ofertasLaborales.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que gestiona la tabla tecnologías de la base de datos
 */
@Entity
@Table(name = "tecnologias")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "tecnologias", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Oferta> ofertas= new ArrayList<>();

    // Resto de atributos
    private String nombre;

    // Constructores
    public Tecnologia() {}

    public Tecnologia(String nombre) {
        this.nombre = nombre;
    }

    public Tecnologia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Setters y Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    @Override
    public String toString() {
        return "Tecnologia{" +
                "id=" + id +
//                ", ofertas=" + ofertas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
