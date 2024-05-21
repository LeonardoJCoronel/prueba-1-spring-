package coronel.coronel.demo.service;

import coronel.coronel.demo.entity.LeonardoProductoEntity;
import coronel.coronel.demo.repository.LeonardoProductoRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LeonardoProductoService {

    @Autowired
    LeonardoProductoRepository productoRepository;

    public List<LeonardoProductoEntity> findAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<LeonardoProductoEntity> findProductoById(int id) {
        return productoRepository.findById(id);
    }

    public LeonardoProductoEntity saveProducto(LeonardoProductoEntity producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }
}