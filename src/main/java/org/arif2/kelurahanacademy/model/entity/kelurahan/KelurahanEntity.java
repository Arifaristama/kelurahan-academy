package org.arif2.kelurahanacademy.model.entity.kelurahan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.arif2.kelurahanacademy.response.kelurahan.KelurahanRes;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_kelurahan")
public class KelurahanEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "kecamatan")
    private String kecamatan;

    @OneToMany(mappedBy = "kelurahan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DusunEntity> daftarDusun = new ArrayList<>();

    public void addDusun(DusunEntity dusun) {
        this.daftarDusun.add(dusun);
        dusun.setKelurahan(this);
    }

    public KelurahanEntity(String id, String nama, String kecamatan) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.kecamatan = kecamatan;
    }
}
