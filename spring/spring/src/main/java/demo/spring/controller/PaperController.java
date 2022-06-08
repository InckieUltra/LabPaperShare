package demo.spring.controller;

import demo.spring.entity.Comment;
import demo.spring.entity.Field;
import demo.spring.entity.Paper;
import demo.spring.entity.Result;
import demo.spring.mapper.PaperMapper;
import demo.spring.service.PaperService;
import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    @CrossOrigin
    @PostMapping("/api/paper/upload")
    public Result upload(@RequestBody UploadRequest uploadRequest) {
        try {
                this.paperService.upload(uploadRequest);
            } catch (Exception e) {
                return Result.fail("添加论文失败", null);
            }
        return Result.success("成功",uploadRequest.paper_merge());
    }

    @CrossOrigin
    @PostMapping("/api/allfield")
    public Result allfield() {
        List<Field> res=new ArrayList<Field>();
        try {
            res=this.paperService.findallField();
        } catch (Exception e) {
            return Result.fail("查询失败", null);
        }
        return Result.success("查询成功",res);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/uploadfile")
    public Result uploadFolder(@RequestBody MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            FTPUtil.sshSftp(bytes, file.getOriginalFilename());
            return Result.success("上传成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("上传失败",null);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/comment")
    public Result comment(@RequestBody Comment comment) {
        try {
            paperService.addComment(comment);
            return Result.success("评论成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("评论失败",null);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getcomment")
    public Result comment(@RequestParam("paper_id") Integer paper_id) {
        try {
            return Result.success("查询成功",this.paperService.findComment(paper_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("查询失败",null);
    }
}
