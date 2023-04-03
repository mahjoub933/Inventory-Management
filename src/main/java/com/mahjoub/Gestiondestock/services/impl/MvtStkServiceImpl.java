package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DTO.MvtStkDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;
import com.mahjoub.Gestiondestock.Repository.MvtStkRepository;
import com.mahjoub.Gestiondestock.services.MvtStkService;
import com.mahjoub.Gestiondestock.validators.MvtStkValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
 @Slf4j
public class MvtStkServiceImpl implements MvtStkService {
    private MvtStkRepository mvtStkRepository;
@Autowired
    public MvtStkServiceImpl(MvtStkRepository mvtStkRepository) {
        this.mvtStkRepository = mvtStkRepository;
    }

    @Override
    public MvtStkDto save(MvtStkDto mvtStkDto) {
    List<String> errors= MvtStkValidator.validate(mvtStkDto);
    if(!errors.isEmpty()){
       log.error("le mouvement de stock n'est pas valide");
       throw  new InvalidEntityException("le mouvement de Stock n'est pas valide", ErrorCode.MVTSTK_NOT_VALID,errors);
    }

        return MvtStkDto.fromEntity(mvtStkRepository.save(MvtStkDto.toEntity(mvtStkDto)));
    }

    @Override
    public MvtStkDto findById(Integer id) {
    if(id==null){
        log.error("l'id de mouvement de Stock est nulle");
        return null;
    }
        return mvtStkRepository.findById(id).map(MvtStkDto::fromEntity).orElseThrow(()->new
                EntityNotFoundException("le mouvement de Stock de l'ID"+id+"n'a pas trouvé dans la BDD",
                ErrorCode.MVTSTK_NOT_FOUND));
    }


    @Override
    public MvtStkDto findByCodeMvtStock(String code) {
    if(!StringUtils.hasLength(code)){
        log.error("le code de mouvement n'est pas valide");
    }
        return mvtStkRepository.findByCodemvstock(code).map(MvtStkDto::fromEntity).orElseThrow(()->new
                EntityNotFoundException("le mouvement de Stock du code"+code+"n'a pas trouvé dans la BDD",
                ErrorCode.MVTSTK_NOT_FOUND));
    }

    @Override
    public List<MvtStkDto> findAll() {
        return mvtStkRepository.findAll().stream().map(MvtStkDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteMvtstock(Integer id) {

    mvtStkRepository.deleteById(id);

    }
}
