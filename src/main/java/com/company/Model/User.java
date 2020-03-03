package com.company.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlRootElement;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
@XmlRootElement(name="User")
public class User {
    int id;
    String name;
    String password;
}
