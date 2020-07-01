package cn.edu.nwsuaf.lims.web;

import cn.edu.nwsuaf.lims.core.Result;
import cn.edu.nwsuaf.lims.core.ResultGenerator;
import cn.edu.nwsuaf.lims.model.Reply;
import cn.edu.nwsuaf.lims.service.ReplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by liuchao Li on 2020/06/28.
*/
@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Resource
    private ReplyService replyService;

    @PostMapping("/add")
    public Result add(@RequestBody Reply reply) {
        replyService.save(reply);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Reply reply) {
        replyService.deleteById(reply.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Reply reply) {
        replyService.update(reply);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        Reply reply = replyService.findById(id);
        return ResultGenerator.genSuccessResult(reply);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Reply> list = replyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
