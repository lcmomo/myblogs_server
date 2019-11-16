package cn.edu.nwsuaf.lims.web;

import cn.edu.nwsuaf.lims.core.Result;
import cn.edu.nwsuaf.lims.core.ResultGenerator;
import cn.edu.nwsuaf.lims.model.Poem2;
import cn.edu.nwsuaf.lims.service.Poem2Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by liuchao Li on 2019/10/27.
*/
@RestController
@RequestMapping("/poem2")
public class Poem2Controller {
    @Resource
    private Poem2Service poem2Service;

    @PostMapping("/add")
    public Result add(@RequestBody Poem2 poem2) {
        poem2Service.save(poem2);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Poem2 poem2) {
        poem2Service.deleteById(poem2.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Poem2 poem2) {
        poem2Service.update(poem2);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        Poem2 poem2 = poem2Service.findById(id);
        return ResultGenerator.genSuccessResult(poem2);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Poem2> list = poem2Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
