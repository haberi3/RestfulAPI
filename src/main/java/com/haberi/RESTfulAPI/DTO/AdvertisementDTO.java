package com.haberi.RESTfulAPI.DTO;

import com.haberi.RESTfulAPI.Entity.Advertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO objektum a frontenddel való kommunikációhoz, és fieldek elfedéséhez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDTO {
    private Long id;
    private String title;
    private String description;

    public AdvertisementDTO (Advertisement advertisement){
        this.id = advertisement.getId();
        this.title = advertisement.getTitle();
        this.description = advertisement.getDescription();
    }
}
