package br.com.gitcrib.enums;

public enum StatusProjectEnum {
    
    ACTIVE(1,"Active"),
    CANCELED(2,"Canceled"),
    DONE(4,"Done");

    private StatusProjectEnum(Integer code, String description) {
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
