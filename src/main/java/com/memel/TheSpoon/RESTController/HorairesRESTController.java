package com.memel.TheSpoon.RESTController;

import com.memel.TheSpoon.entities.Horaires;
import com.memel.TheSpoon.services.HorairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/horaires-api")
@CrossOrigin
public class HorairesRESTController {
    @Autowired
    HorairesService horairesService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Horaires> getAllHoraires()
    {
        return horairesService.getAllHoraires();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @Operation(summary = "Afficher l'horaire par son id")
    public Horaires getHorairesById(@PathVariable("id") Long id) {
        return horairesService.getHoraires(id);
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Horaires createHoraires(@RequestBody Horaires horaires) {
        return horairesService.saveHoraires(horaires);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Horaires updateHoraires(@RequestBody Horaires horaires) {
        return horairesService.updateHoraires(horaires);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteHoraires(@PathVariable("id") Long id)
    {
        horairesService.deleteHorairesById(id);
    }

}
