package coronel.coronel.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import coronel.coronel.demo.entity.LeonardoCatalogoEntity;
import coronel.coronel.demo.entity.LeonardoCatalogoEnum;
import coronel.coronel.demo.service.LeonardoCatalogoService;

@SuppressWarnings("unused")
@Component
public class CreateCatalogos implements CommandLineRunner {

    @Autowired
    LeonardoCatalogoService catalogoService;

    @Override
    public void run(String... args) throws Exception {
        // LeonardoCatalogoEntity catalogoNuevo = new LeonardoCatalogoEntity(LeonardoCatalogoEnum.nuevo);
        // LeonardoCatalogoEntity catalogoGastado = new LeonardoCatalogoEntity(LeonardoCatalogoEnum.gastado);
        // LeonardoCatalogoEntity catalogoDaniado = new LeonardoCatalogoEntity(LeonardoCatalogoEnum.dañado);
        // catalogoService.save(catalogoNuevo);
        // catalogoService.save(catalogoGastado);
        // catalogoService.save(catalogoDaniado);
    }
}
