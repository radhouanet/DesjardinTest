package com.desjardins.test.controller;

import com.desjardins.test.model.Film;
import com.desjardins.test.repository.FilmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FilmController {
    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("api/film/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable("id") Long id) {
        Optional<Film> film = filmRepository.findById(id);
        if(film.isPresent()){
            return new ResponseEntity<>(film.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("api/film")
    public ResponseEntity<Film>createFilm(@RequestBody Film film) {
        Film createdFilm = filmRepository.save(film);
        return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
    }
}
