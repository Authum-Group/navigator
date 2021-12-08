package com.solvd.navigator.domain;

public class House {

    private Long id;
    private Integer number;
    private String block;
    private String numberOfEntrances;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getNumberOfEntrances() {
        return numberOfEntrances;
    }

    public void setNumberOfEntrances(String numberOfEntrances) {
        this.numberOfEntrances = numberOfEntrances;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
