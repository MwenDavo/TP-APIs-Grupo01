package application.controller;

import application.model.entity.Usuario;
import application.model.entity.dto.UsuarioDTO;
import application.service.IUsuarioService;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private SecretKey secretKey;
    private final int EXPIRATION_TIME_IN_MINUTES = 10;

    @PostMapping("/register")
    private ResponseEntity<String> register(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        usuarioService.create(usuario);
        return new ResponseEntity<>("Registro exitoso.", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        if (usuarioService.readByUsernameAndPassword(usuario) != null) {
            String token = Jwts.builder()
                    .setSubject(usuario.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MINUTES * 60 * 1000))
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .compact();
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("Credenciales inválidas.", HttpStatus.UNAUTHORIZED);
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        return new Usuario(
                usuarioDTO.getUsername(),
                usuarioDTO.getPassword(),
                usuarioDTO.getDni(),
                usuarioDTO.getNombre(),
                usuarioDTO.getTelefono()
        );
    }
}
