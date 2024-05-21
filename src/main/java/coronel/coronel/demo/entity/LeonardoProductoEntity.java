package coronel.coronel.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class LeonardoProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime fechaRegistro;

    private Float precio;

    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private LeonardoCatalogoEntity catalogo;
}
