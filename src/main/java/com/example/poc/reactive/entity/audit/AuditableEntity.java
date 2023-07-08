package com.example.poc.reactive.entity.audit;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

/**
 * The type Auditable entity.
 */
@Setter
@Getter
@Accessors(chain = true)
public class AuditableEntity {

    /**
     * The Created by.
     */
    @CreatedBy
    @Column(value = "created_by")
    protected String createdBy;

    /**
     * The Modified by.
     */
    @LastModifiedBy
    @Column(value = "modified_by")
    protected String modifiedBy;

    @CreatedDate
    @Column(value = "created_on")
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(value = "modified_on")
    private LocalDateTime modifiedOn;

    @Column(value = "is_deleted")
    private Boolean isDeleted = false;
}
