package org.arif2.kelurahanacademy.response.kelurahan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.arif2.kelurahanacademy.model.entity.kelurahan.KelurahanEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KelurahanRes {
    private String id;
    private String nama;
    private String kecamatan;
    private List<DusunRes> dusun = new ArrayList<>();

    public KelurahanRes(KelurahanEntity kelurahanEntity) {
        this.id = kelurahanEntity.getId();
        this.nama = kelurahanEntity.getNama();
        this.kecamatan = kelurahanEntity.getKecamatan();


        if(!kelurahanEntity.getDaftarDusun().isEmpty()) {
           this.dusun = kelurahanEntity.getDaftarDusun().stream().map(DusunRes::new).collect(Collectors.toList());
        }
    }
}
