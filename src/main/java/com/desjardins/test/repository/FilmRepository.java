package com.desjardins.test.repository;

import com.desjardins.test.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {



}
