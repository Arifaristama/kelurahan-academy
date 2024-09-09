package org.arif2.kelurahanacademy.controller.kelurahan.v2;

import org.arif2.kelurahanacademy.model.response1.Response;
import org.arif2.kelurahanacademy.model.service.kelurahan.KelurahanService;
import org.arif2.kelurahanacademy.request.kelurahan.KelurahanReq;
import org.arif2.kelurahanacademy.response.kelurahan.KelurahanRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v2/kelurahan")
public class KelurahanV2 {
    private final KelurahanService kelurahanService;

    @Autowired
    public KelurahanV2(KelurahanService kelurahanService) {
        this.kelurahanService = kelurahanService;
    }

    @GetMapping
    public ResponseEntity<Response> getKelurahan() {
        return ResponseEntity.ok(
                Response.builder()
                        .code(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .message("Success")
                        .data(kelurahanService.get())
                        .build()

        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getKelurahanById(@PathVariable("id") String id) {

        Optional<KelurahanRes> result = kelurahanService.getByid(id);
        return result.map(kelurahanRes -> ResponseEntity.ok(
                Response.builder()
                        .code(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .message("Success")
                        .data(kelurahanRes)
                        .build()
        )).orElseGet(() -> ResponseEntity.badRequest().body(
                Response.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .status(HttpStatus.BAD_REQUEST.name())
                        .message("Data Not Found")
                        .data(null)
                        .build()
        ));

    }

    @PostMapping
    public ResponseEntity<Response> postKelurahan(@RequestBody KelurahanReq kelurahanReq) {
        Optional<KelurahanRes> result = kelurahanService.save(kelurahanReq);
        return result.map(kelurahanRes1 -> ResponseEntity.ok(
                Response.builder()
                        .code(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .message("Success")
                        .data(kelurahanRes1)
                        .build()
        )).orElseGet(() -> ResponseEntity.badRequest().body(
                Response.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .status(HttpStatus.BAD_REQUEST.name())
                        .message("Bad Request")
                        .data(null)
                        .build()
        ));
    }
}
