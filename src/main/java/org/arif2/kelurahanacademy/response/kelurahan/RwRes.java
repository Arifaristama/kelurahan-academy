package org.arif2.kelurahanacademy.response.kelurahan;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.arif2.kelurahanacademy.model.entity.kelurahan.RwEntity;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RwRes {
    private String id;
    private String nama;
    private String namaRw;

    public RwRes(RwEntity rwEntity) {
        BeanUtils.copyProperties(rwEntity, this);
    }
}
