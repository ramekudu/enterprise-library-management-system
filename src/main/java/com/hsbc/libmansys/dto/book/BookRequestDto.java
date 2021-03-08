package com.hsbc.libmansys.dto.book;

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
public class BookRequestDto {

    @NotNull(message ="ISBN Value of a book is required")
    @Size(max = 50)
    private String isbn;

    @NotNull(message ="ISBN Value of a book is required")
    @Size(min = 1 , max = 100)
    private String title;

    @NotNull(message ="ISBN Value of a book is required")
    @Size(min = 1 , max = 100)
    private String author;

    @NotNull(message ="ISBN Value of a book is required")
    @Size(min = 1 , max = 100)
    private String publisher;

    @NotNull(message ="ISBN Value of a book is required")
    @Size(min = 1 , max = 100)
    private String description;

}
