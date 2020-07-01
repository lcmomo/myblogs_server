package cn.edu.nwsuaf.lims.web;

import cn.edu.nwsuaf.lims.core.Result;
import cn.edu.nwsuaf.lims.core.ResultGenerator;
import cn.edu.nwsuaf.lims.model.Comment;
import cn.edu.nwsuaf.lims.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by liuchao Li on 2020/06/28.
*/
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/add")
    public Result add(@RequestBody Comment comment) {
        commentService.save(comment);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Comment comment) {
        commentService.deleteById(comment.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Comment comment) {
        commentService.update(comment);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        Comment comment = commentService.findById(id);
        return ResultGenerator.genSuccessResult(comment);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Comment> list = commentService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @GetMapping("/findbyarticleId")
    public Result findByArticleId(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,@RequestParam(defaultValue = "1") Integer articleId) {
        PageHelper.startPage(page, size);

        List<Comment> list = commentService.findByArticleId(articleId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
