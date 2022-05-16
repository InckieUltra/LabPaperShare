package demo.spring.service;

import demo.spring.entity.Field;
import demo.spring.entity.Paper;

import java.util.List;

public interface PaperService {
    public int addPaper(Paper paper);
    public List<Field> findallField();
}
