package br.com.iraponan.orangetalentscomicsbookschallenge.repositories;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {

}
