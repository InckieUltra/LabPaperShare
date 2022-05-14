package demo.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PaperMapper {
    @Insert("insert into paper values((select max(paper_id)+1 from (select paper_id from paper) as tmp),#{title},#{conference},#{date},#{summary},#{link},#{type})")
    int addPaper(String title,String conference,String date,String summary,String link,String type);
}
