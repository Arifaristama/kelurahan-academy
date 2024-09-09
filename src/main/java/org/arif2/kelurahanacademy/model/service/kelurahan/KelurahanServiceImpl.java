package org.arif2.kelurahanacademy.model.service.kelurahan;

import lombok.extern.slf4j.Slf4j;
import org.arif2.kelurahanacademy.model.entity.kelurahan.DusunEntity;
import org.arif2.kelurahanacademy.model.entity.kelurahan.KelurahanEntity;
import org.arif2.kelurahanacademy.model.repository.kelurahan.KelurahanRepo;
import org.arif2.kelurahanacademy.request.kelurahan.DusunReq;
import org.arif2.kelurahanacademy.request.kelurahan.KelurahanReq;
import org.arif2.kelurahanacademy.response.kelurahan.KelurahanRes;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class KelurahanServiceImpl implements KelurahanService {
    private final KelurahanRepo repo;

    public KelurahanServiceImpl(KelurahanRepo repo) {
        this.repo = repo;

    }

    @Override
    public List<KelurahanRes> get() {
        List<KelurahanEntity> list = repo.findAll();
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        return list.stream().map(KelurahanRes::new).collect(Collectors.toList());
    }

    @Override
    public Optional<KelurahanRes> getByid(String id) {
        KelurahanEntity entity = repo.findById(id).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }
        KelurahanRes res = new KelurahanRes(entity);
        return Optional.of(res);
    }

    @Override
    public Optional<KelurahanRes> save (KelurahanReq request) {
        KelurahanEntity entity = new KelurahanEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setId(UUID.randomUUID().toString());

        if (!request.getDusun().isEmpty()){
            for (DusunReq dusun : request.getDusun()) {
                DusunEntity dusunEntity = new DusunEntity();

            }
        }
        try {
            repo.save(entity);
            log.info("Kelurahan saved");
            return Optional.of(new KelurahanRes(entity));
        } catch (Exception e) {
            log.error("save kelurahan failed, error :{}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<KelurahanRes> update(KelurahanReq request, String id) {
        return Optional.empty();
    }

    @Override
    public Optional<KelurahanRes> delete(String id) {
        return Optional.empty();
    }
}
