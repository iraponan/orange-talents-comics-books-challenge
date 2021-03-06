package br.com.iraponan.orangetalentscomicsbookschallenge.repositories;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepositories extends JpaRepository<Comic, Long> {
}
