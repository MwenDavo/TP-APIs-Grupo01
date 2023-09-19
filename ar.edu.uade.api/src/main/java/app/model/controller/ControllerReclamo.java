package app.model.controller;

import app.model.entity.Reclamo;
import app.model.service.IServiceReclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiR")
public class ControllerReclamo implements IControllerReclamo {
    @Autowired
    private IServiceReclamo service;

    @Override
    @RequestMapping(value = {"/reclamos", ""}, method = RequestMethod.GET)
    public List<Reclamo> readAll() {

        return service.readAll();
    }
}
