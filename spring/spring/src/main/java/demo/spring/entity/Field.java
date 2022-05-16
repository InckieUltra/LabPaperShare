package demo.spring.entity;

import java.io.Serializable;
import java.util.List;

public class Field implements Serializable {
    private static final long serialVersionUID = 3497935890426858541L;

    int field_id;

    String field_name;

    int pid;

    List<Integer> children;

    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<Integer> getChildren() {
        return children;
    }

    public void setChildren(List<Integer> children) {
        this.children = children;
    }
}
