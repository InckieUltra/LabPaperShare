package demo.spring.mapper;

import demo.spring.entity.Field;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PaperMapper {
    @Insert("insert into paper values((select max(paper_id)+1 from (select paper_id from paper) as tmp),#{title},#{conference},#{date},#{summary},#{link},#{type})")
    int addPaper(String title,String conference,String date,String summary,String link,String type);

    @Insert("insert into field(field_name,pid) values(#{field_name},#{pid})")
    int addField(String field_name,int pid);

    @Select("select * from field")
    @Results(id="fieldMap",value={
            @Result(property = "field_id",column = "field_id",javaType = Integer.class),
            @Result(property = "field_name",column = "field_name",javaType = String.class),
            @Result(property = "pid",column = "pid")
    })
    List<Field> findallField();

    @Select("select field_id from field where pid=#{id}")
    List<Integer> findFieldChildren(int id);

    @Select("select paper_id from cover where field_id=#{field_id}")
    List<Integer> findPaperbyField_id(int field_id);

    @Update("update field set field_name=#{field_name} where field_id=#{field_id}")
    int modifyFieldName(int field_id,String field_name);

    @Delete("delete from field where field_id=#{field_id}")
    int deleteField(int field_id);
}