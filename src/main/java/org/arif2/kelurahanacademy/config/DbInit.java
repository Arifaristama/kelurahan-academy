package org.arif2.kelurahanacademy.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.arif2.kelurahanacademy.model.entity.kelurahan.DusunEntity;
import org.arif2.kelurahanacademy.model.entity.kelurahan.KelurahanEntity;
import org.arif2.kelurahanacademy.model.entity.kelurahan.RtEntitiy;
import org.arif2.kelurahanacademy.model.entity.kelurahan.RwEntity;
import org.arif2.kelurahanacademy.model.repository.kelurahan.KelurahanRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DbInit implements CommandLineRunner {
    private final KelurahanRepo kelurahanRepo;

    @Override
    public void run(String... args) throws Exception {
        initKelurahan();
    }

    private void initKelurahan() {
        if (kelurahanRepo.count() > 0 ) {
            return;
        }

        KelurahanEntity kelurahan = new KelurahanEntity("", "Lampung Tengah", "Kota Gajah");

        DusunEntity kotasari1 = new DusunEntity("", "Kotasari 1");
        DusunEntity kotasari2 = new DusunEntity("", "Kota Sari 2");
        DusunEntity RB1 = new DusunEntity("", "Rama Indra 1");

        kelurahan.addDusun(kotasari1);
        kelurahan.addDusun(kotasari2);
        kelurahan.addDusun(RB1);

        RwEntity rw1 = new RwEntity("", "RW 01", "Mulyono");
        RwEntity rw2 = new RwEntity("", "RW 02", "Mukidi");
        RwEntity rw3 = new RwEntity("", "RW 03", "Suparjo");

        kotasari1.addRw(rw1);
        kotasari2.addRw(rw2);
        RB1.addRw(rw3);

        RtEntitiy rt1 = new RtEntitiy("", "RT 01");
        RtEntitiy rt2 = new RtEntitiy("", "RT 02");
        RtEntitiy rt3 = new RtEntitiy("", "RT 03");

        rw1.addRt(rt1);
        rw2.addRt(rt2);
        rw3.addRt(rt3);

        try {
            kelurahanRepo.save(kelurahan);
            log.info("saved successfully");
        } catch (Exception e) {
            log.error("Saved failed, error{}", e.getMessage());
        }
    }
}
