package coronel.coronel.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalogo")
public class LeonardoCatalogoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private LeonardoCatalogoEnum nombre;

    public LeonardoCatalogoEntity() {
    }

    public LeonardoCatalogoEntity(LeonardoCatalogoEnum nombre) {
        this.nombre = nombre;
    }

    public LeonardoCatalogoEnum getNombre() {
        return nombre;
    }

    public void setNombre(LeonardoCatalogoEnum nombre) {
        this.nombre = nombre;
    }

}
