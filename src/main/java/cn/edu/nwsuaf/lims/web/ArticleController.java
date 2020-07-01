package cn.edu.nwsuaf.lims.web;

import cn.edu.nwsuaf.lims.core.Result;
import cn.edu.nwsuaf.lims.core.ResultGenerator;
import cn.edu.nwsuaf.lims.model.Article;
import cn.edu.nwsuaf.lims.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by liuchao Li on 2020/02/17.
*/
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("/add")
    public Result add(@RequestBody Article article) {
        articleService.save(article);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Article article) {
        articleService.deleteById(article.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Article article) {
        articleService.update(article);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        Article article = articleService.findById(id);
        return ResultGenerator.genSuccessResult(article);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "") String orderby) {
        PageHelper.startPage(page, size,orderby);

        List<Article> list = articleService.findAllArticle();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findbykeywords")
    public Result findByKeywords(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "") String keywords) {
        PageHelper.startPage(page, size);

        List<Article> list = articleService.findByKeywords(page,keywords);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
