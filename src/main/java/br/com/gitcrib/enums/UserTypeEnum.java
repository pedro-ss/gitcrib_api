package br.com.gitcrib.enums;

public enum UserTypeEnum {
    
    FOUNDER(1,"Founder"),
    CONTRIBUTOR(2,"Contributor");

    private UserTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    private Integer code;
    private String description;

    public Integer getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
