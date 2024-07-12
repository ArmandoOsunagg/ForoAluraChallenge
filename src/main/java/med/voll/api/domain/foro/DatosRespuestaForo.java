package med.voll.api.domain.foro;

public record DatosRespuestaForo(
 int idUsuario,
String mensaje,
 String nombreCurso,
   String titulo,
   Categoria categoria,
        boolean activo
) {
}
