package com.chernikin.webapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDetails {

    private int id;
    private String firstName;
    private String lastName;
}
