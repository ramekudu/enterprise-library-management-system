package com.hsbc.libmansys.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotNull(message ="UserId Value of a book is required")
    @Size(min = 1 , max = 100)
    private String userid;
    @NotNull(message ="firstname Value of a book is required")
    @Size(min = 1 , max = 100)
    private String firstName;
    @NotNull(message ="lastname Value of a book is required")
    @Size(min = 1 , max = 100)
    private String lastName;
    @NotNull(message ="sex Value of a book is required")
    @Size(min = 1 , max = 100)
    private String sex;
    @NotNull(message ="addressline1 Value of a book is required")
    @Size(min = 1 , max = 100)
    private String addressline1;
    @NotNull(message ="addressline2 Value of a book is required")
    @Size(min = 1 , max = 100)
    private String addressline2;
    @NotNull(message ="country Value of a book is required")
    @Size(min = 1 , max = 100)
    private String country;

}
