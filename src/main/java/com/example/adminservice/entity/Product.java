package com.example.adminservice.entity;

import com.example.adminservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update product set deleted=true,status=false where id=?")
public class Product extends AbsNameEntity {
    @ManyToOne
    private Category category;
    @OneToOne
    private Attachment photo;
    private Double price;
    private String description;
    //chegirma
    @ManyToOne(fetch = FetchType.LAZY)
    private Discount discount;
}
