package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UsuarioComicDto {

    @NotBlank
    @NotNull
    private Long idUsuario;

    @NotBlank
    @NotNull
    private Long idComic;

    public UsuarioComicDto(Long idUsuario, Long idComic) {
        this.idUsuario = idUsuario;
        this.idComic = idComic;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdComic() {
        return idComic;
    }
}
