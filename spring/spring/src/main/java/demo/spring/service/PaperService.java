package demo.spring.service;

import demo.spring.controller.UploadRequest;
import demo.spring.entity.*;

import java.util.HashMap;
import java.util.List;

public interface PaperService {
    public int addPaper(Paper paper);
    public List<Field> findallField();
    public int addField(Field field);
    public int modifyFieldName(Field field);
    public int deleteField(int field_id);

    public int upload(UploadRequest uploadRequest);

    public int addComment(Comment comment);
    public List<MultiComment> findComment(int paper_id);

    public List<Object> findPaperbyField(int field_id, int page_no, int page_size);
    public PaperDetail findPaperDetail(int paper_id);
}