package br.com.iraponan.orangetalentscomicsbookschallenge.repositories;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //Estudar
public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByCpfOrEmail(String cpf, String email);
}
