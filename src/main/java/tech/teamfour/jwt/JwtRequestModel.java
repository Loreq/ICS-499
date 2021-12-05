package tech.teamfour.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtRequestModel implements Serializable {

    private static final long serialVersionUID = 2636936156391265891L;
    private String username;
    private String password;

}
