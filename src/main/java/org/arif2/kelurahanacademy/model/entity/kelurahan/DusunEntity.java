package org.arif2.kelurahanacademy.model.entity.kelurahan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_dusun")
public class DusunEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "kelurahan_id", length = 36, insertable = false, updatable = false)
    private String kelurahanId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kelurahan_id")
    private KelurahanEntity kelurahan;

    @OneToMany(mappedBy = "dusun", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RwEntity> daftarRw = new ArrayList<>();

    public void addRw(RwEntity rwEntity) {
        this.daftarRw.add(rwEntity);
        rwEntity.setDusun(this);
    }

    public DusunEntity(String id, String nama) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
    }

}
