package org.github.caseca.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExitDTO {
    private Long id;
    private String name;
    private String email;
}
