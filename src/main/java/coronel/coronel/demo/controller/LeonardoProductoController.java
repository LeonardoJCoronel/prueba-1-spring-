package coronel.coronel.demo.controller;

import coronel.coronel.demo.entity.LeonardoProductoEntity;
import coronel.coronel.demo.service.LeonardoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class LeonardoProductoController {

    @Autowired
    private LeonardoProductoService productoService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos encontrada"),
            @ApiResponse(responseCode = "404", description = "No se encontraron productos")
    })
    public List<LeonardoProductoEntity> getAllProductos() {
        return productoService.findAllProductos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<LeonardoProductoEntity> getProductoById(@PathVariable int id) {
        return productoService.findProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public ResponseEntity<LeonardoProductoEntity> createProducto(@RequestBody LeonardoProductoEntity producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.saveProducto(producto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<LeonardoProductoEntity> updateProducto(@PathVariable int id, @RequestBody LeonardoProductoEntity producto) {
        if (!productoService.findProductoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        producto.setId(id);
        return ResponseEntity.ok(productoService.saveProducto(producto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        if (!productoService.findProductoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
