package org.arif2.kelurahanacademy.request.kelurahan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WargaReq {
    private String id;
    private Integer nik;
    private String namaWarga;
    private String jenisKelamin;
    private Integer age;
}
