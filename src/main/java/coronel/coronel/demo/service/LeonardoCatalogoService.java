package coronel.coronel.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coronel.coronel.demo.repository.LeonardoCatalogoRepository;
import coronel.coronel.demo.entity.LeonardoCatalogoEntity;
import coronel.coronel.demo.entity.LeonardoCatalogoEnum;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class LeonardoCatalogoService {

    @Autowired
    LeonardoCatalogoRepository catalogoRepository;

    public List<LeonardoCatalogoEntity> getList(){
        return catalogoRepository.findAll();
    }

    public void save(LeonardoCatalogoEntity catalogo){
        catalogoRepository.save(catalogo);
    }

    public Optional<LeonardoCatalogoEntity> getByNombre(LeonardoCatalogoEnum nombre){
        return catalogoRepository.findByNombre(nombre);
    }

    public void deleteCatalogoByNombre(LeonardoCatalogoEnum nombre) {
        catalogoRepository.deleteByNombre(nombre);
    }
}
