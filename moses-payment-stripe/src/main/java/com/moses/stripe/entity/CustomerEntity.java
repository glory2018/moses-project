package com.moses.stripe.entity;

import com.moses.framework.common.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Moses
 * @date 2020/4/27
 */
@Entity
@Data
public class CustomerEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false, unique = true)
    private String customerId;
    @Column
    private String email;
}
