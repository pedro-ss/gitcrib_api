package br.com.gitcrib.enums;

public enum StatusTasksEnum {
    
    ACTIVE(1,"Active"),
    FREEZE(2,"Freeze"),
    CLOSED(3,"Closed"),
    DONE(4,"Done");

    private StatusTasksEnum(Integer code, String description) {
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
