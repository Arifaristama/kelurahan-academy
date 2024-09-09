package org.arif2.kelurahanacademy.model.entity.kelurahan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_warga")
public class WargaEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nik")
    private String nik;

    @Column(name = "namaWarga")
    private String namaWarga;

    @Column(name = "jenisKelamin")
    private String jenisKelamin;

    @Column(name = "age")
    private Integer age;

    @Column(name = "rt_id", length = 36, insertable = false, updatable = false)
    private String rtId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dusun_id")
    private DusunEntity dusun;

    @OneToMany(mappedBy = "warga", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KelurahanEntity> kelurahan;
}
