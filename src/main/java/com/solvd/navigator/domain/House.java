package com.solvd.navigator.domain;

public class House {

    private Long id;
    private Long number;
    private String block;
    private Long numberOfEntrances;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getNumberOfEntrances() {
        return numberOfEntrances;
    }

    public void setNumberOfEntrances(Long numberOfEntrances) {
        this.numberOfEntrances = numberOfEntrances;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
