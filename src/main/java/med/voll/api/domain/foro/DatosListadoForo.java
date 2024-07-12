package med.voll.api.domain.foro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosListadoForo(
        Long id,
        @NotNull int idUsuario,
        @NotBlank String mensaje,
        @NotBlank String nombreCurso,
        @NotBlank String titulo,
        @NotNull Categoria categoria,
        boolean activo) {


    public DatosListadoForo(Foro foro){

        this(foro.getId(), foro.getIdUsuario(), foro.getMensaje(), foro.getNombreCurso(),foro.getTitulo(),foro.getCategoria(),foro.isActivo());

    }



}
