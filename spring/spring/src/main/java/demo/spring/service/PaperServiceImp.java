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
        return loopQuery(null,fields);
    }

    private List<Field> loopQuery(Integer pid,List<Field> allFields){
        List<Field> fieldList=new ArrayList<Field>();
        for(Field field:allFields){
            if(pid==null){
                if(field.getPid()==null){
                    fieldList.add(field);
                    field.setChildren(loopQuery(field.getField_id(),allFields));
                }
            }
            else if(pid==field.getPid()){
                fieldList.add(field);
                field.setChildren(loopQuery(field.getField_id(),allFields));
            }
        }
        return fieldList;
    }

    @Override
    public int addField(Field field){
        return this.paperMapper.addField(field.getField_name(),field.getPid());
    }

    @Override
    public int modifyFieldName(Field field){
        return this.paperMapper.modifyFieldName(field.getField_id(),field.getField_name());
    }

    @Override
    public int deleteField(int field_id){
        if(this.paperMapper.findPaperbyField_id(field_id).size()!=0){
            return 1;
        }
        if(this.paperMapper.findFieldChildren(field_id).size()!=0)
            return 2;
        this.paperMapper.deleteField(field_id);
        return 0;
    }
}
