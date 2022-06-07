package demo.spring.service;

import demo.spring.controller.UploadRequest;
import demo.spring.entity.Field;
import demo.spring.entity.Paper;

import java.util.List;

public interface PaperService {
    public int addPaper(Paper paper);
    public List<Field> findallField();
    public int addField(Field field);
    public int modifyFieldName(Field field);
    public int deleteField(int field_id);

    public int upload(UploadRequest uploadRequest);
}
