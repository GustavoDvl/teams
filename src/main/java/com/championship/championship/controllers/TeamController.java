package com.championship.championship.controllers;

import com.championship.championship.DTO.TeamDTO;
import com.championship.championship.entities.TeamModel;
import com.championship.championship.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> findById(@PathVariable Long id){
        TeamDTO dto = teamService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<TeamDTO>> findAll(Pageable pageable){
        Page<TeamDTO> dto = teamService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/create")
    public ResponseEntity<TeamDTO> create(@RequestBody TeamDTO teamDTO){
        teamDTO = teamService.create(teamDTO);
        return ResponseEntity.ok(teamDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> update(@PathVariable Long id, @RequestBody TeamDTO teamDTO){
        teamDTO = teamService.update(id, teamDTO);
        return ResponseEntity.ok(teamDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id){
        teamService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
