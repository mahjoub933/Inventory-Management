package com.mahjoub.Gestiondestock.controllers.api;

import com.mahjoub.Gestiondestock.DTO.VenteDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mahjoub.Gestiondestock.utils.Constants.END_POINT_VENTE;

@Api(END_POINT_VENTE)
public interface VenteApi {

    @PostMapping(END_POINT_VENTE+"/create")
    VenteDto save(@RequestBody VenteDto venteDto);

    @GetMapping(END_POINT_VENTE+"/{id}")
    VenteDto findById(@PathVariable Integer id);

    @GetMapping(END_POINT_VENTE+"/{codevente}")
    VenteDto findBycodeVente(@PathVariable("codevente") String code);
    @GetMapping(END_POINT_VENTE+"/all")
    List<VenteDto> findAll();
    @DeleteMapping(END_POINT_VENTE+"/{id}")
    void DeleteVente(@PathVariable Integer id);
}


