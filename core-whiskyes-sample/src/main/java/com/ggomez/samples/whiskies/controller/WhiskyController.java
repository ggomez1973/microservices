package com.ggomez.samples.whiskies.controller;

import com.ggomez.samples.whiskies.domain.Whisky;
import com.ggomez.samples.whiskies.repository.WhiskyRepository;
import com.ggomez.samples.whiskies.vo.WhiskyValueObject;
import com.ggomez.samples.whiskies.vo.converters.WhiskyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/whiskyes")
public class WhiskyController {
    private final WhiskyRepository repository;
    private final WhiskyConverter whiskyConverter;

    public WhiskyController(WhiskyRepository repository, WhiskyConverter whiskyConverter) {
        this.repository = repository;
        this.whiskyConverter = whiskyConverter;
    }

    @GetMapping
    public List<WhiskyValueObject> getWhiskyes(){
        List<Whisky> result = (List<Whisky>) repository.findAll();
        return result.stream().map(whiskyConverter::convert).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhiskyValueObject> getWhiskyById(@PathVariable Long id){
        Optional<Whisky> whisky = repository.findById(id);
        return whisky.map(whiskyConverter::convert).map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void addWhisky(@RequestBody WhiskyValueObject whiskyValueObject){
        Whisky whisky = new Whisky();
        whisky.setName(whiskyValueObject.getName());
        whisky.setPeated(whiskyValueObject.isPeated());
        repository.save(whisky);
    }

}
