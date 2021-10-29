package equipo1.ofertasLaborales.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entidad que gestiona la tabla ofertas de la base de datos
 */
@Entity
@Table(name = "Ofertas")
  public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name="OfertaTecnologia",
            joinColumns={
            @JoinColumn(name="IdOferta", referencedColumnName = "id")
            },
            inverseJoinColumns= {
            @JoinColumn(name = "IdTecnologia", referencedColumnName = "id") })
    @JsonManagedReference
    private List<Tecnologia> tecnologias = new ArrayList<>();

    // Resto de atributos
    private String empresa;
    private String descripcion;
    private Integer numeroVacantes;
    private String localidad;
    private Integer salarioMinimo;
    private Integer salarioMaximo;
    private String modalidad;
    private Integer anyosExperiencia;
    private String titulacion;
    private String categoria;
    private String tipoContrato;
    private Date fechaPublicacion;
    private Boolean estadoProceso;
    private String urlImagen;

    // Constructores
    public Oferta() {}

    public Oferta(Long id, String empresa, String descripcion, Integer numeroVacantes,
                  String localidad, Integer salarioMinimo, Integer salarioMaximo, String modalidad,
                  Integer anyosExperiencia, String titulacion, String categoria, String tipoContrato,
                  Date fechaPublicacion, Boolean estadoProceso, String urlImagen) {
        this.id = id;
//        this.tecnologias = tecnologias;
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.numeroVacantes = numeroVacantes;
        this.localidad = localidad;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
        this.modalidad = modalidad;
        this.anyosExperiencia = anyosExperiencia;
        this.titulacion = titulacion;
        this.categoria = categoria;
        this.tipoContrato = tipoContrato;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoProceso = estadoProceso;
        this.urlImagen = urlImagen;
    }

    // Setters y Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumeroVacantes() {
        return numeroVacantes;
    }

    public void setNumeroVacantes(Integer numeroVacantes) {
        this.numeroVacantes = numeroVacantes;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Integer salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public Integer getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(Integer salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Integer getAnyosExperiencia() {
        return anyosExperiencia;
    }

    public void setAnyosExperiencia(Integer anyosExperiencia) {
        this.anyosExperiencia = anyosExperiencia;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Boolean getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(Boolean estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", tecnologias=" + tecnologias +
                ", empresa='" + empresa + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numeroVacantes=" + numeroVacantes +
                ", localidad='" + localidad + '\'' +
                ", salarioMinimo=" + salarioMinimo +
                ", salarioMaximo=" + salarioMaximo +
                ", modalidad='" + modalidad + '\'' +
                ", anyosExperiencia=" + anyosExperiencia +
                ", titulacion='" + titulacion + '\'' +
                ", categoria=" + categoria +
                ", tipoContrato='" + tipoContrato + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", estadoProceso=" + estadoProceso +
                ", urlImagen='" + urlImagen + '\'' +
                '}';
    }
}