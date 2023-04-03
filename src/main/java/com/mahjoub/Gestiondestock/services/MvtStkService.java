package com.mahjoub.Gestiondestock.services;

import com.mahjoub.Gestiondestock.DTO.ClientDto;
import com.mahjoub.Gestiondestock.DTO.MvtStkDto;

import java.util.List;

public interface MvtStkService {

    MvtStkDto save(MvtStkDto mvtStkDto);
    MvtStkDto findById(Integer id);
    MvtStkDto findByCodeMvtStock(String code);
    List<MvtStkDto> findAll();
    void deleteMvtstock(Integer id);
}
