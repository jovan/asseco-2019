package com.asseco.trening.enumeration;

public enum ZanimanjeEnum{
    
    DIREKTOR(1, "direktor"),
    PROGRAMER(2,"programer"),
    PROFESOR(3,"profesor");
    
    private Integer id;
    private String description;

    private ZanimanjeEnum(Integer id, String description) {
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