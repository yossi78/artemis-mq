package com.example.artemis_mq.entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString(); // Pre-generate UUID

    private String firstName;
    private String lastName;

}
