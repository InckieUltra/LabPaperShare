package demo.spring.service;

import demo.spring.entity.Field;
import demo.spring.entity.Paper;
import demo.spring.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("paperService")
public class PaperServiceImp implements PaperService{
    @Autowired
    private PaperMapper paperMapper;

    public int addPaper(Paper paper){
        return this.paperMapper.addPaper(paper.getTitle(),paper.getConference(),paper.getDate(),paper.getSummary(),paper.getLink(),paper.getType());
    }

    @Override
    public List<Field> findallField(){
        List<Field> fields=this.paperMapper.findallField();
        for(int i=0;i<fields.size();i++){
            fields.get(i).setChildren(this.paperMapper.findFieldChildren(fields.get(i).getField_id()));
        }
        return fields;
    }
}
