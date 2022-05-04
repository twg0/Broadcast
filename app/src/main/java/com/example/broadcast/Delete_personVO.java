package com.example.broadcast;

public class Delete_personVO {
    boolean checked;
    String ItemString;
    Delete_personVO(boolean b, String t) {
        checked = b;
        ItemString = t;
    }
    public boolean isChecked() {
        return checked;
    }
}
