package com.haberi.RESTfulAPI.Repository;

import com.haberi.RESTfulAPI.Entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisementsRepository extends JpaRepository<Advertisement, Long> {

}
