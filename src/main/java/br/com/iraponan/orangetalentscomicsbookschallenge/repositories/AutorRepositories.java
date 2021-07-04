package br.com.iraponan.orangetalentscomicsbookschallenge.repositories;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositories extends JpaRepository<Autor, String> {
}
