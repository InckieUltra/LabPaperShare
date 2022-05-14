package demo.spring.service;

import demo.spring.entity.Paper;
import demo.spring.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("paperService")
public class PaperServiceImp implements PaperService{
    @Autowired
    private PaperMapper paperMapper;

    public int addPaper(Paper paper){
        return this.paperMapper.addPaper(paper.getTitle(),paper.getConference(),paper.getDate(),paper.getSummary(),paper.getLink(),paper.getType());
    }
}
