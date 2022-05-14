package demo.spring.controller;

import demo.spring.entity.Paper;
import demo.spring.entity.Result;
import demo.spring.mapper.PaperMapper;
import demo.spring.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    @CrossOrigin
    @PostMapping("/api/paper/upload")
    public Result upload(@RequestBody Paper paper) {
        try {
                this.paperService.addPaper(paper);
            } catch (Exception e) {
                return Result.fail("添加论文失败", null);
            }
        try{
            //this.paperService.addUpload(upload);
            int i=1;
        }catch (Exception e){
            return Result.fail("上传失败",null);
        }
        return Result.success("成功",paper);
    }
}
