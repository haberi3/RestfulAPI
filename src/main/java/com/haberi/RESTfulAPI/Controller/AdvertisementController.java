package com.haberi.RESTfulAPI.Controller;

import com.haberi.RESTfulAPI.DTO.AdvertisementDTO;
import com.haberi.RESTfulAPI.Service.AdvertisementsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ads")
public class AdvertisementController {

    private final AdvertisementsService advertisementsService;

    public AdvertisementController(AdvertisementsService advertisementsService) {
        this.advertisementsService = advertisementsService;
    }

    /**
     * Hirdetés hozzáadása az adatbázishoz
     * @param advertisementDTO a hirdetés DTO objektum formában
     * @return AdvertisementDTO objektummal tér vissza
     */
    @PostMapping
    public AdvertisementDTO addAdvertisement(@RequestBody AdvertisementDTO advertisementDTO){
        return advertisementsService.addAdvertisement(advertisementDTO);
    }

    /**
     * Összes hirdetés visszaadása DTO formátumban
     * @return AdvertisementDTO lista
     */
    @GetMapping
    public List<AdvertisementDTO> getAllAdvertisement(){
        return advertisementsService.getAllAdvertisement();
    }

    /**
     * Hirdetés törlése id alapján
     * @param id a hirdetés id-ja
     */
    @DeleteMapping("/{id}")
    public void deleteAdvertisement(Long id){
        advertisementsService.deleteAdvertisement(id);
    }

}
