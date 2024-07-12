package med.voll.api.domain.foro;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="foros")
@Entity(name= "Foro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="idUsuario")
public class Foro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    private int idUsuario;
    private String mensaje;
    private String nombreCurso;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private boolean activo;


    public Foro(DatosRegistroForo datos) {
        this.idUsuario = datos.idUsuario();
        this.nombreCurso= datos.nombreCurso();
        this.mensaje = datos.nombreCurso();
        this.titulo = datos.titulo();
        this.categoria= datos.categoria();
    }

    public void actualizarDatos(DatosActualizarForo datosActualizarForo) {

    if (datosActualizarForo.nombreCurso() != null) {
        this.nombreCurso = datosActualizarForo.nombreCurso();
    }

    if(datosActualizarForo.titulo() != null) {

        this.titulo = datosActualizarForo.titulo();
    }
    if(datosActualizarForo.categoria() != null) {

        this.categoria = datosActualizarForo.categoria();
    }
    if(datosActualizarForo.mensaje() != null) {
        this.mensaje = datosActualizarForo.mensaje();
    }

    }


    public void desactivarForo() {
        this.activo = false;
    }
}
