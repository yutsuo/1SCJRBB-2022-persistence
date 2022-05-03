package org.scjrbb.persistence.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "Customer")
public class Customer {
    @Id public ObjectId _id;
    public int id;
    public String name;
    public String phone;
    public String email;
}
