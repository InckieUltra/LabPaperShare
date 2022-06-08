package demo.spring.service;

import demo.spring.controller.UploadRequest;
import demo.spring.entity.*;
import demo.spring.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("paperService")
public class PaperServiceImp implements PaperService{
    @Autowired
    private PaperMapper paperMapper;

    public int addPaper(Paper paper){
        return this.paperMapper.addPaper(paper);
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

    public int addNote(Note note){return this.paperMapper.addNote(note);}

    public int addUpload(Upload upload){return this.paperMapper.addUpload(upload);}

    public int addCover(int paper_id,int field_id){return this.paperMapper.addCover(paper_id,field_id);}

    public int addAttach_File(int upload_id,String file_path){return this.paperMapper.addAttach_File(upload_id,file_path);}

    public int addPublish(int paper_id,String author_name){return this.paperMapper.addPublish(paper_id,author_name);}

    public int addReference(int paper_id,int reference_id){return this.paperMapper.addReference(paper_id,reference_id);}
    @Override
    @Transactional
    public int upload(UploadRequest uploadRequest){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = df.format(date);
        Paper paper=uploadRequest.paper_merge();
        this.addPaper(paper);
        Note note=new Note();
        note.setContent(uploadRequest.getContent());
        this.addNote(note);
        Upload upload=new Upload();
        upload.setPaper_id(paper.getPaper_id());
        upload.setNote_id(note.getNote_id());
        upload.setUser_id(uploadRequest.getUser_id());
        upload.setUpload_date(str);
        this.addUpload(upload);
        for(int i=0;i<uploadRequest.getAuthors().size();i++){
            this.addPublish(paper.getPaper_id(),uploadRequest.getAuthors().get(i));
        }
        for(int i=0;i<uploadRequest.getField().size();i++) {
            this.addCover(paper.getPaper_id(),uploadRequest.getField().get(i));
        }
        for(int i=0;i<uploadRequest.getReferences().size();i++){
            this.addReference(paper.getPaper_id(),uploadRequest.getReferences().get(i));
        }
        for(int i=0;i<uploadRequest.getFileList().size();i++) {
            this.addAttach_File(upload.getUpload_id(),uploadRequest.getFileList().get(i));
        }
        return 0;
    }

    public int addComment(Comment comment){
        return this.paperMapper.addComment(comment);
    }

    public List<MultiComment> findComment(int paper_id){
        List<MultiComment> res=this.paperMapper.findMultiComment(paper_id);
        List<Comment> comments;
        for(int i=0;i<res.size();i++){
            comments=this.paperMapper.findComment(paper_id,res.get(i).getComment_id());
            for(int j=0;j<comments.size();j++){
                comments.get(j).setTo(this.paperMapper.findRepliedUser(comments.get(j).getSuper_id()));
            }
            res.get(i).setReply(comments);
        }
        return res;
    }
}
