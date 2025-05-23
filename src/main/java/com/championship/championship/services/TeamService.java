package com.championship.championship.services;

import com.championship.championship.DTO.TeamDTO;
import com.championship.championship.entities.TeamModel;
import com.championship.championship.repositories.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private ChampionshipRepository repository;

    @Transactional(readOnly = true)
    public TeamDTO getById(Long id){
        TeamModel entity = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Team not found whith id " + id));
        return new TeamDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<TeamDTO> findAll(Pageable pageable) {
        Page<TeamModel> entities = repository.findAll(pageable);
        return entities.map(TeamDTO::new);
    }

    @Transactional
    public TeamDTO create(TeamDTO teamDTO){
        TeamModel entity = new TeamModel();
        copyDtoToEntity(teamDTO, entity);
        entity = repository.save(entity);
        return new TeamDTO(entity);
    }

    @Transactional
    public TeamDTO update(Long id, TeamDTO teamDTO ){
        TeamModel entity = repository.getReferenceById(id);
        copyDtoToEntity(teamDTO, entity);
        entity = repository.save(entity);
        return new TeamDTO(entity);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    private void copyDtoToEntity(TeamDTO teamDTO, TeamModel entity) {
        entity.setName(teamDTO.getName());
        entity.setStadium(teamDTO.getStadium());
        entity.setColor(teamDTO.getColor());
    }




}
