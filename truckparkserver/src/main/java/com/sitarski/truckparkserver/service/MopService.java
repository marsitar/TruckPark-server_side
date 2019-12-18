package com.sitarski.truckparkserver.service;

import com.sitarski.truckparkserver.dao.MopRepository;
import com.sitarski.truckparkserver.domain.dto.MopDto;
import com.sitarski.truckparkserver.domain.entity.Mop;
import com.sitarski.truckparkserver.service.mapper.Mapper;
import com.sitarski.truckparkserver.service.mapper.MopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MopService {

    @Autowired
    private final MopRepository mopRepository;

    @Autowired
    private final Mapper<MopDto, Mop> mopMapper;

    public MopService(MopRepository mopRepository, MopMapper mopMapper) {
        this.mopRepository = mopRepository;
        this.mopMapper = mopMapper;
    }

    public List<MopDto> getMops() {
        return mopRepository
                .findAll()
                .stream()
                .map(mopMapper::convertToDto)
                .sorted(Comparator.comparing(MopDto::getId))
                .collect(Collectors.toList());
    }

    public Optional<MopDto> getMopById(Long id) {
        return mopRepository
                .findById(id)
                .map(mopMapper::convertToDto);
    }

    public Optional<MopDto> getMopByIdentificationName(String identificationName) {
        return mopRepository
                .findMopByIdentificationName(identificationName)
                .map(mopMapper::convertToDto);
    }

    public List<MopDto> getMopsByIdentificationNameIsLike(String identificationNamePattern) {
        return mopRepository
                .findMopsByIdentificationNameIsLike(identificationNamePattern)
                .stream()
                .map(mopMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public void addMop(MopDto mopDto) {
        Mop mopToSave = mopMapper.convertToEntity(mopDto);
        mopRepository.save(mopToSave);
    }

    public MopDto updateMop(MopDto mopDto) {
        Mop mopToSave = Optional.of(mopDto)
                .map(mopMapper::convertToEntity)
                .orElse(null);
        Mop savedMop = mopRepository.save(mopToSave);
        return mopMapper.convertToDto(savedMop);
    }

    public void deleteMopById(Long id) {
        mopRepository.deleteById(id);
    }
}
