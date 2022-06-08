package demo.spring.mapper;

import demo.spring.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PaperMapper {
    @Insert("insert into paper(title,conference,date,summary,link,type) values(#{title},#{conference},#{date},#{summary},#{link},#{type})")
    @Options(useGeneratedKeys = true, keyProperty = "paper_id", keyColumn = "paper_id")
    int addPaper(Paper paper);

    @Insert("insert into field(field_name,pid) values(#{field_name},#{pid})")
    int addField(String field_name,int pid);

    @Insert("insert into upload(user_id,upload_date,paper_id,note_id) values(#{user_id},#{upload_date},#{paper_id},#{note_id})")
    @Options(useGeneratedKeys = true, keyProperty = "upload_id", keyColumn = "upload_id")
    int addUpload(Upload upload);

    @Insert("insert into note(content) values(#{content})")
    @Options(useGeneratedKeys = true, keyProperty = "note_id", keyColumn = "note_id")
    int addNote(Note note);

    @Insert("insert into cover values(#{paper_id},#{field_id})")
    int addCover(int paper_id,int field_id);

    @Insert("insert into attach values(#{upload_id},#{file_path})")
    int addAttach_File(int upload_id,String file_path);

    @Insert("insert into publish values(#{author_name},#{paper_id})")
    int addPublish(int paper_id,String author_name);

    @Insert("insert into reference values(#{paper_id},#{reference_id})")
    int addReference(int paper_id,int reference_id);

    @Insert("insert into comment(text,time,super_id,paper_id,user_id) values(#{text},#{time},#{super_id},#{paper_id},#{user_id})")
    int addComment(Comment comment);
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

    @Select("select * from comment natural join user where paper_id = #{paper_id} and super_id = 0")
    @Results(id="multiCommentMap",value={
            @Result(property = "comment_id",column = "comment_id"),
            @Result(property = "text",column = "text"),
            @Result(property = "time",column = "time"),
            @Result(property = "super_id",column = "super_id"),
            @Result(property = "user_id",column = "user_id"),
            @Result(property = "name",column = "username")
    })
    List<MultiComment> findMultiComment(int paper_id);

    @Select("select * from comment natural join user where paper_id = #{paper_id} and super_id = #{super_id}")
    @Results(id="commentMap",value={
            @Result(property = "comment_id",column = "comment_id"),
            @Result(property = "text",column = "text"),
            @Result(property = "time",column = "time"),
            @Result(property = "super_id",column = "super_id"),
            @Result(property = "user_id",column = "user_id"),
            @Result(property = "name",column = "username")
    })
    List<Comment> findComment(int paper_id,int super_id);

    @Select("select username from comment natural join user where comment_id = #{super_id}")
    String findRepliedUser(int super_id);
    @Update("update field set field_name=#{field_name} where field_id=#{field_id}")
    int modifyFieldName(int field_id,String field_name);

    @Delete("delete from field where field_id=#{field_id}")
    int deleteField(int field_id);


}