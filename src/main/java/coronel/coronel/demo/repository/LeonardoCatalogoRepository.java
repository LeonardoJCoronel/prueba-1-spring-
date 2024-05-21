package coronel.coronel.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coronel.coronel.demo.entity.LeonardoCatalogoEntity;
import coronel.coronel.demo.entity.LeonardoCatalogoEnum;

public interface LeonardoCatalogoRepository extends JpaRepository<LeonardoCatalogoEntity, Integer>{
    void deleteByNombre(LeonardoCatalogoEnum nombre);
    
    Optional<LeonardoCatalogoEntity> findByNombre(LeonardoCatalogoEnum nombre);
}
