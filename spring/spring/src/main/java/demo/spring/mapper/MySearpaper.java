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
    @Select("select paper_id,title,conference,left(summary,25) as summary,name,type,field from (select paper_id,title,conference,summary,group_concat(distinct author_name) as name,type,group_concat(distinct field_name) as field from paper natural join publish natural join cover natural join field group by paper_id) as T where paper_id like '%${paper_id}%'")
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

    @Select("select paper_id,title,conference,left(summary,25) as summary,name,type,field from (select paper_id,title,conference,summary,group_concat(distinct author_name) as name,type,group_concat(distinct field_name) as field from paper natural join publish natural join cover natural join field group by paper_id) as T where title like '%${title}%'")
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

    @Select("select paper_id,title,conference,left(summary,25) as summary,name,type,field from (select paper_id,title,conference,summary,group_concat(distinct author_name) as name,type,group_concat(distinct field_name) as field from paper natural join publish natural join cover natural join field group by paper_id) as T where name like '%${name}%'")
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

    @Select("select paper_id,title,conference,left(summary,25) as summary,name,type,field from (select paper_id,title,conference,summary,group_concat(distinct author_name) as name,type,group_concat(distinct field_name) as field from paper natural join publish natural join cover natural join field group by paper_id) as T where summary like '%${summary}%'")
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

    @Select("select paper_id,title,conference,left(summary,25) as summary,name,type,field from (select paper_id,title,conference,summary,group_concat(distinct author_name) as name,type,group_concat(distinct field_name) as field from paper natural join publish natural join cover natural join field group by paper_id) as T where type like '%&{type}%'")
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
