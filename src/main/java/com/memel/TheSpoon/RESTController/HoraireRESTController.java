package com.memel.TheSpoon.RESTController;

import com.memel.TheSpoon.entities.Horaire;
import com.memel.TheSpoon.services.HoraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horaires-api")
@CrossOrigin
public class HoraireRESTController {

    @Autowired
    HoraireService horaireService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Horaire> getAllHoraires() {
        return horaireService.getAllHoraires();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Horaire getHoraireById(@PathVariable("id") Long id) {
        return horaireService.getHoraire(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Horaire createHoraire(@RequestBody Horaire horaire) {
        return horaireService.saveHoraire(horaire);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Horaire updateHoraire(@RequestBody Horaire horaire) {
        return horaireService.updateHoraire(horaire);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteHoraire(@PathVariable("id") Long id) {
        horaireService.deleteHoraireById(id);
    }
}
