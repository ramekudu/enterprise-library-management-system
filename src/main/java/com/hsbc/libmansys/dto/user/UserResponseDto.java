package com.hsbc.libmansys.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String userid;

    private String firstName;

    private String lastName;

    private String sex;

    private String addressline1;

    private String addressline2;

    private String country;
}

