package org.arif2.kelurahanacademy.request.kelurahan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.arif2.kelurahanacademy.model.entity.kelurahan.DusunEntity;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DusunReq {
    private String id;
    private String nama;


    public DusunReq(DusunEntity dusun) {
        BeanUtils.copyProperties(dusun, this);
    }
}
