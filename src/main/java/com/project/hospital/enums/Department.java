package com.project.hospital.enums;

public enum Department {

    CARDIOLOGIE("CARDIOLOGIE"),
    CHIRURGIE("CHIRURGIE"),
    NEUROLOGIE("NEUROLOGIE"),
    PEDIATRIE("PEDIATRIE"),
    ORTOPEDIE("ORTOPEDIE"),
    ONCOLOGIE("ONCOLOGIE");

    private final String dept;

    Department(String dept) {
        this.dept = dept;
    }

    public String getDept() {
        return this.dept;
    }

}
