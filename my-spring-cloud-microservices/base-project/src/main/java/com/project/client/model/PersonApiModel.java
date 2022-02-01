package com.project.client.model;

import com.project.client.model.base.BaseApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonApiModel extends BaseApiModel {

    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
