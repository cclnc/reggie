package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
        @Autowired
        private CategoryService categoryService;
        //新增分类
        @PostMapping
        public R<String> save(@RequestBody Category category){
            categoryService.save(category);
            return R.success("新增分类成功");
        }
        //分类管理分页查询
        @GetMapping("/page")
        public R<Page> page(int page,int pageSize){
            //分页构造器
            Page<Category> pageInfo = new Page<>(page,pageSize);
            //条件构造器
            LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
            //添加排序条件，根据sort进行排序
            queryWrapper.orderByAsc(Category::getSort);
            //进行分页查询
            categoryService.page(pageInfo,queryWrapper);

            return R.success(pageInfo);

        }


        //根据id删除分类
        @DeleteMapping
        public R<String> delete(Long ids){
            categoryService.remove(ids);
            return R.success("分类信息删除成功");
        }

        //根据id修改分类信息
        @PostMapping
        public R<String> update(@RequestBody Category category){
            categoryService.updateById(category);
            return R.success("修改分类信息成功");
        }


}
