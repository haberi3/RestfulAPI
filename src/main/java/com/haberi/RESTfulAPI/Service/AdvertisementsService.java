package com.haberi.RESTfulAPI.Service;

import com.haberi.RESTfulAPI.DTO.AdvertisementDTO;
import com.haberi.RESTfulAPI.Entity.Advertisement;
import com.haberi.RESTfulAPI.Mapper.AdvertisementMapper;
import com.haberi.RESTfulAPI.Repository.AdvertisementsRepository;
import com.haberi.RESTfulAPI.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementsService {

    private final AdvertisementsRepository advertisementsRepository;

    private final UserRepository userRepository;

    public AdvertisementsService(AdvertisementsRepository advertisementsRepository, UserRepository userRepository) {
        this.advertisementsRepository = advertisementsRepository;
        this.userRepository = userRepository;
    }

    /**
     * Hirdetés hozzáadása az adatbázishoz
     * A user hard-coded mert a securityval nem jutottam el addig, hogy beazonosíthatóvá tegyem.
     * Egy DTO átalakítást végez oda-vissza és közben elmenti az objektumot az adatbázisba
     * @param advertisementDTO a hirdetés DTO objektum formában
     * @return AdvertisementDTO objektummal tér vissza
     */
    public AdvertisementDTO addAdvertisement(AdvertisementDTO advertisementDTO){
       Advertisement ad = AdvertisementMapper.INSTANCE.advertisementDtoToAdvertisement(advertisementDTO);

           ad.setUser(userRepository.getById(1L));
           return AdvertisementMapper.INSTANCE.advertisementToAdvertisementDto(advertisementsRepository.save(ad));

    }

    /**
     * Hirdetéseket összegyűjti az adatbázisból és továbbítja a controllernek
     * @return AdvertisementDTO listával tér vissza
     */
    public List<AdvertisementDTO> getAllAdvertisement(){
        return advertisementsRepository
                .findAll()
                .stream()
                .map(AdvertisementMapper.INSTANCE::advertisementToAdvertisementDto)
                .collect(Collectors.toList());
    }


    public void deleteAdvertisement(Long id) {
        advertisementsRepository.deleteById(id);
    }
}
