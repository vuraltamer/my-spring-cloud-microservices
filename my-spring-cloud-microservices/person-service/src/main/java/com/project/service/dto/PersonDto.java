package com.project.service.dto;

import com.project.data.document.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto extends BaseDto<Person> {

    private String username;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;
}
