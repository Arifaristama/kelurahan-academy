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
@Table(name = "tbl_rt")
public class RtEntitiy {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "rw_id", length = 36, insertable = false, updatable = false)
    private String rwId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rw_id")
    private RwEntity rw;

    @OneToMany(mappedBy = "rt", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WargaEntity> wargaEntities = new ArrayList<>();

    public void addWarga(WargaEntity wargaEntity) {
    }

    public RtEntitiy(String id, String nama) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
    }
}
