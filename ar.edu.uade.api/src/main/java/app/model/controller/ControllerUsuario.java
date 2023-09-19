package app.model.controller;

import app.model.entity.Usuario;
import app.model.service.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiU")
public class ControllerUsuario implements IControllerUsuario {
    @Autowired
    private IServiceUsuario service;

    @Override
    @RequestMapping(value = {"/usuarios", ""}, method = RequestMethod.GET)
    public List<Usuario> readAll() {

        return service.readAll();
    }
}
