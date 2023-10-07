package application.controller;

import application.model.entity.Foto;
import application.model.entity.dto.FotoDTO;
import application.service.IFotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/fotos")
public class FotoController {
    @Autowired
    private IFotoService fotoService;

    @PostMapping("/subir")
    public ResponseEntity<String> upload(@RequestParam("archivo") MultipartFile archivo) {
        try {
            Foto foto = new Foto();
            foto.setData(archivo.getBytes());
            fotoService.create(foto);
            return ResponseEntity.ok("Imagen subida exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {
        Foto foto = fotoService.read(id);
        if (foto != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(foto.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public static FotoDTO convertToDTO(Foto f) {
        return new FotoDTO(
                f.getData()
        );
    }

    public static Foto convertToEntity(FotoDTO f) {
        Foto foto = new Foto(f.getData());
        return foto;
    }
}
