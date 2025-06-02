package com.aliyaman.deermind.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoUser {

    private Long id;

    private String username;

    private String email;

    private List<DtoNote> notes;
}
