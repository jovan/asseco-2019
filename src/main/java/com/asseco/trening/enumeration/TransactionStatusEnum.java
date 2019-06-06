/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.enumeration;

/**
 *
 * @author LT5
 */
public enum TransactionStatusEnum {
    
    VNESENA(1, "vnesena transakcija"),
    VKIBS(2, "verifikuvan, spremen za vo pratka za KIBS"),
    VMIPS(3, "verifikuvan, spremen za vo pratka za MIPS"),
    FINALEN(4, "finalen status");
    
    private Integer id;
    private String description;
    
    private TransactionStatusEnum(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
