package demo.spring.mapper;

import demo.spring.entity.Permission;
import demo.spring.entity.parper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MySearpaper {
    @Select("select DISTINCT paper_id,title,conference,summary,name,type,field from (select paper.paper_id,title,conference,summary,type,author_id from paper join publish on publish.paper_id = paper.paper_id) as A join author on A.author_id = author.author_id where paper_id=#{paper_id}")
    @Results(id="permissionMap",value={
            @Result(property = "paper_id",column = "paper_id",javaType = Integer.class),
            @Result(property = "title",column = "title",javaType = String.class),
            @Result(property = "conference",column = "conference",javaType = String.class),
            @Result(property = "summary",column = "summary",javaType = String.class),
            @Result(property = "role_name",column = "name",javaType = String.class),
            @Result(property = "type",column = "type",javaType = String.class),
            @Result(property = "field",column = "field",javaType = String.class),

    })
    List<parper> Findpaper1(int paper_id);

    @Select("select DISTINCT paper_id,title,conference,summary,name,type,field from (select paper.paper_id,title,conference,summary,type,author_id from paper join publish on publish.paper_id = paper.paper_id) as A join author on A.author_id = author.author_id where title=#{title}")
    @Results(id="permission1Map",value={
            @Result(property = "paper_id",column = "paper_id",javaType = Integer.class),
            @Result(property = "title",column = "title",javaType = String.class),
            @Result(property = "conference",column = "conference",javaType = String.class),
            @Result(property = "summary",column = "summary",javaType = String.class),
            @Result(property = "role_name",column = "name",javaType = String.class),
            @Result(property = "type",column = "type",javaType = String.class),
            @Result(property = "field",column = "field",javaType = String.class),

    })
    List<parper> Findpaper2(String title);

    @Select("select DISTINCT paper_id,title,conference,summary,name,type,field from (select paper.paper_id,title,conference,summary,type,author_id from paper join publish on publish.paper_id = paper.paper_id) as A join author on A.author_id = author.author_id where name=#{name}")
    @Results(id="permission2Map",value={
            @Result(property = "paper_id",column = "paper_id",javaType = Integer.class),
            @Result(property = "title",column = "title",javaType = String.class),
            @Result(property = "conference",column = "conference",javaType = String.class),
            @Result(property = "summary",column = "summary",javaType = String.class),
            @Result(property = "role_name",column = "name",javaType = String.class),
            @Result(property = "type",column = "type",javaType = String.class),
            @Result(property = "field",column = "field",javaType = String.class),

    })
    List<parper> Findpaper3(String name);

    @Select("select DISTINCT paper_id,title,conference,summary,name,type,field from (select paper.paper_id,title,conference,summary,type,author_id from paper join publish on publish.paper_id = paper.paper_id) as A join author on A.author_id = author.author_id where summary=#{summary}")
    @Results(id="permission3Map",value={
            @Result(property = "paper_id",column = "paper_id",javaType = Integer.class),
            @Result(property = "title",column = "title",javaType = String.class),
            @Result(property = "conference",column = "conference",javaType = String.class),
            @Result(property = "summary",column = "summary",javaType = String.class),
            @Result(property = "role_name",column = "name",javaType = String.class),
            @Result(property = "type",column = "type",javaType = String.class),
            @Result(property = "field",column = "field",javaType = String.class),

    })
    List<parper> Findpaper4(String summary);

    @Select("select DISTINCT paper_id,title,conference,summary,name,type,field from (select paper.paper_id,title,conference,summary,type,author_id from paper join publish on publish.paper_id = paper.paper_id) as A join author on A.author_id = author.author_id where type=#{type}")
    @Results(id="permission4Map",value={
            @Result(property = "paper_id",column = "paper_id",javaType = Integer.class),
            @Result(property = "title",column = "title",javaType = String.class),
            @Result(property = "conference",column = "conference",javaType = String.class),
            @Result(property = "summary",column = "summary",javaType = String.class),
            @Result(property = "role_name",column = "name",javaType = String.class),
            @Result(property = "type",column = "type",javaType = String.class),
            @Result(property = "field",column = "field",javaType = String.class),

    })
    List<parper> Findpaper5(String type);
}
