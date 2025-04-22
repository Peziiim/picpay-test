package executor.dtos;


import java.math.BigDecimal;

import executor.domain.user.UserType;

public record UserDTO(
                    String firstName,
                    String lastName, 
                    String CPF,
                    String email,
                    String password,
                    BigDecimal balance,
                    UserType userType

) {
    
}
