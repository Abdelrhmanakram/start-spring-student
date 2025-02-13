package com.boot.start.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;

   @NotBlank(message = "invalid.name")
    private String name;

    @NotBlank(message = "invalid.address")
    private String address;
}
