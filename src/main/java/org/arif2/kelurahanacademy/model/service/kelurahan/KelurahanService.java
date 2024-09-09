package org.arif2.kelurahanacademy.model.service.kelurahan;

import org.arif2.kelurahanacademy.request.kelurahan.KelurahanReq;
import org.arif2.kelurahanacademy.response.kelurahan.KelurahanRes;

import java.util.List;
import java.util.Optional;

public interface KelurahanService {
    List<KelurahanRes> get();
    Optional<KelurahanRes> getByid(String id);
    Optional<KelurahanRes> save(KelurahanReq kelurahanReq);
    Optional<KelurahanRes> update(KelurahanReq request, String id);
    Optional<KelurahanRes> delete(String id);

}
