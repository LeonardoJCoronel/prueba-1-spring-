package coronel.coronel.demo.controller;

import coronel.coronel.demo.entity.LeonardoCatalogoEntity;
import coronel.coronel.demo.entity.LeonardoCatalogoEnum;
import coronel.coronel.demo.service.LeonardoCatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalogo")
public class LeonardoCatalogoController {

    @Autowired
    private LeonardoCatalogoService catalogoService;

    @GetMapping("/getList")
    public ResponseEntity<List<LeonardoCatalogoEntity>> getList() {
        List<LeonardoCatalogoEntity> catalogoList = catalogoService.getList();
        return new ResponseEntity<List<LeonardoCatalogoEntity>>(catalogoList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody LeonardoCatalogoEntity catalogo) {
        catalogoService.save(catalogo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getByNombre/{nombre}")
    public ResponseEntity<LeonardoCatalogoEntity> getByNombre(@PathVariable LeonardoCatalogoEnum nombre) {
        Optional<LeonardoCatalogoEntity> catalogoOptional = catalogoService.getByNombre(nombre);
        return catalogoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteByNombre/{nombre}")
    public ResponseEntity<Void> deleteCatalogoByNombre(@PathVariable LeonardoCatalogoEnum nombre) {
        catalogoService.deleteCatalogoByNombre(nombre);
        return ResponseEntity.noContent().build();
    }
}
