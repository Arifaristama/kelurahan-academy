package org.arif2.kelurahanacademy.model.repository.kelurahan;

import org.arif2.kelurahanacademy.model.entity.kelurahan.RwEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RwRepo extends JpaRepository<RwEntity, String> {
}