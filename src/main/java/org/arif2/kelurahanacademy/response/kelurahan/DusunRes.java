package org.arif2.kelurahanacademy.response.kelurahan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.arif2.kelurahanacademy.model.entity.kelurahan.DusunEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DusunRes {
    private String id;
    private String nama;
    private String kelurahanId;
    private String kelurahanNama;
    private List<RwRes> rw = new ArrayList<>();

    public DusunRes(DusunEntity dusunEntity) {
        this.id = dusunEntity.getId();
        this.nama = dusunEntity.getNama();

        if (!dusunEntity.getDaftarRw().isEmpty()) {
            this.rw = dusunEntity.getDaftarRw().stream().map(RwRes::new).collect(Collectors.toList());
        }
    }
}
