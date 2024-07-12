package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.domain.foro.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/foro")
public class ForoController {

    @Autowired
    private ForoRepository foroRepository;


    @PostMapping
    public ResponseEntity registrarForo(@RequestBody @Valid DatosRegistroForo datos,
                                        UriComponentsBuilder uriComponentsBuilder){
        System.out.println(datos);



        Foro foro = foroRepository.save(new Foro(datos));

        DatosRespuestaForo datosRespuestaForo = new DatosRespuestaForo(
                foro.getIdUsuario(),
                foro.getMensaje(),foro.getNombreCurso(),foro.getTitulo(),foro.getCategoria()
                ,foro.isActivo());
        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(foro.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaForo);
    }

    @GetMapping
    public ResponseEntity <Page<DatosListadoForo>> listadoForos(Pageable paginacion){


        return ResponseEntity.ok( foroRepository.findAll(paginacion).map(DatosListadoForo::new));


    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarForo(@RequestBody DatosActualizarForo datosActualizarForo){

        Foro foro = foroRepository.getReferenceById(datosActualizarForo.id());
        foro.actualizarDatos(datosActualizarForo);
        return ResponseEntity.ok( new DatosRespuestaForo(foro.getIdUsuario(),
                foro.getMensaje(),foro.getNombreCurso(),foro.getNombreCurso(),
                foro.getCategoria(),foro.isActivo()));
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Foro foro = foroRepository.getReferenceById(id);
        foro.desactivarForo();
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaForo> retornoDatosForo(@PathVariable Long id) {
        Foro foro = foroRepository.getReferenceById(id);
        DatosRespuestaForo datosForo =  new DatosRespuestaForo(
                foro.getIdUsuario(),
                foro.getMensaje(),foro.getNombreCurso(),foro.getTitulo(),foro.getCategoria()
                ,foro.isActivo());




        return ResponseEntity.ok(datosForo);



    }



    //    DELETE EN BASE DE DATOD
    //    public void eliminarForo(@PathVariable Long id) {
    //        Foro foro = foroRepository.getReferenceById(id);
    //        foroRepository.delete(foro);
    //    }

}
