package app.model.controller;

import app.model.entity.Edificio;
import app.model.service.IServiceEdificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiE")
public class ControllerEdificio implements IControllerEdificio {
    @Autowired
    private IServiceEdificio service;

    @Override
    @RequestMapping(value = {"/edificios", ""}, method = RequestMethod.GET)
    public List<Edificio> readAll() {

        return service.readAll();
    }
}
