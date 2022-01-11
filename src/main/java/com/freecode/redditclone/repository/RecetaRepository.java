package com.freecode.redditclone.repository;

import java.util.List;
import java.util.Optional;

import com.freecode.redditclone.model.Receta;
import com.freecode.redditclone.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta,Long> {
    Optional<Receta> findById(Long id);

    List<Receta> findAllBySubreddit(Receta receta);

    List<Receta> findByUser(User user);
}
