package com.ll.donggibook.app.cart.entity;

import com.ll.donggibook.app.base.entity.BaseEntity;
import com.ll.donggibook.app.member.entity.Member;
import com.ll.donggibook.app.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class CartItem extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member buyer;
    @ManyToOne(fetch = LAZY)
    private Product product;

    public CartItem(long id) {
        super(id);
    }
}
