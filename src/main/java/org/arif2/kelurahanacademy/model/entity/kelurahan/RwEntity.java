package org.arif2.kelurahanacademy.model.entity.kelurahan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_rw")
public class RwEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "namaRw")
    private String namaRw;

    @Column(name = "dusun_id", length = 36, insertable = false, updatable = false)
    private String dusunId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dusun_id")
    private DusunEntity dusun;

    @OneToMany(mappedBy = "rw", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RtEntitiy> rtEntities = new ArrayList<>();

    public void addRt(RtEntitiy rtEntitiy) {
        rtEntities.add(rtEntitiy);
        rtEntitiy.setRw(this);
    }
    public RwEntity(String id, String nama, String namaRw) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.namaRw = namaRw;
    }

}
