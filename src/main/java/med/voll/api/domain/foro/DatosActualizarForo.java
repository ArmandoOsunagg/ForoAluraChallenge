package med.voll.api.domain.foro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarForo(    @NotNull
                                      long id,
                                      @NotNull
                                      int idUsuario,
                                      @NotBlank
                                      String mensaje,
                                      @NotBlank String nombreCurso,
                                      @NotBlank String titulo,
                                      @NotNull Categoria categoria) {


}
