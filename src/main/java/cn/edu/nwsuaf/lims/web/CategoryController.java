package cn.edu.nwsuaf.lims.web;

import cn.edu.nwsuaf.lims.core.Result;
import cn.edu.nwsuaf.lims.core.ResultGenerator;
import cn.edu.nwsuaf.lims.model.Category;
import cn.edu.nwsuaf.lims.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by liuchao Li on 2020/06/28.
*/
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @PostMapping("/add")
    public Result add(@RequestBody Category category) {
        categoryService.save(category);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Category category) {
        categoryService.deleteById(category.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Category category) {
        categoryService.update(category);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        Category category = categoryService.findById(id);
        return ResultGenerator.genSuccessResult(category);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Category> list = categoryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
