package org.arif2.kelurahanacademy.model.service.kelurahan;

import org.arif2.kelurahanacademy.request.kelurahan.DusunReq;
import org.arif2.kelurahanacademy.response.kelurahan.DusunRes;

import java.util.List;
import java.util.Optional;

public interface DusunService{
    List<DusunRes> get();
    Optional<DusunRes> getById(String id);
    Optional<DusunRes> save(DusunReq dusunReq);
    Optional<DusunRes> update(DusunReq dusunReq, String id);
    Optional<DusunRes> delete(String id);

}
