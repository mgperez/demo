package com.example.demo.entity;

import com.example.demo.UserView;
import com.example.demo.repository.Identifiable;
import com.example.demo.utils.IdEntity;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonView(UserView.Common.class)
public class User extends IdEntity implements Identifiable<String> {
    /**
     * serial number
     */
    private static final long serialVersionUID = 4878714592685892394L;

    /**
     * created timestamp
     */
    private String created;
    private String firstName;
    // private String id;
    private String label;
    private String lastName;
    private String phone;
    private String pictureName;
    /**
     * updated timestamp
     */
    private String updated;
    @JsonView({UserView.QuickContactView.class})
    private String username;
    private String website;

    @Override
    public String getIdentifier() {
        return username;
    }
}
