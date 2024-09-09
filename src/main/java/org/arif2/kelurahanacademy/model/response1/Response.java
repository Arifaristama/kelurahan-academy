package org.arif2.kelurahanacademy.model.response1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private int code;
    private String message;
    private String status;
    private Object data;
}
