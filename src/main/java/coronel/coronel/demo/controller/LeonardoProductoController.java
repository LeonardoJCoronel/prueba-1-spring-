package coronel.coronel.demo.controller;

import coronel.coronel.demo.entity.LeonardoProductoEntity;
import coronel.coronel.demo.service.LeonardoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class LeonardoProductoController {



    @Autowired
    private LeonardoProductoService productoService;

    @GetMapping
    @ApiOperation(value = "Obtener todos los productos")
    public List<LeonardoProductoEntity> getAllProductos() {
        return productoService.findAllProductos();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un producto por su ID")
    public ResponseEntity<LeonardoProductoEntity> getProductoById(@PathVariable int id) {
        return productoService.findProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ApiOperation(value = "Crear un nuevo producto")
    public ResponseEntity<LeonardoProductoEntity> createProducto(@RequestBody LeonardoProductoEntity producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.saveProducto(producto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar un producto existente")
    public ResponseEntity<LeonardoProductoEntity> updateProducto(@PathVariable int id, @RequestBody LeonardoProductoEntity producto) {
        if (!productoService.findProductoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        producto.setId(id);
        return ResponseEntity.ok(productoService.saveProducto(producto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un producto por su ID")
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        if (!productoService.findProductoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
