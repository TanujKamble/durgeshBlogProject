package com.durgesh.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.blog.payloads.ApiResponse;
import com.durgesh.blog.payloads.CategoryDto;
import com.durgesh.blog.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create
	
	@PostMapping("/add")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createcategory = this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(createcategory,HttpStatus.CREATED);
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
		CategoryDto updatedcategory = this.categoryService.updateCategory(categoryDto, catId);
		
		return new ResponseEntity<CategoryDto>(updatedcategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		this.categoryService.deleteCategory(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully",true),HttpStatus.OK);
	}


	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
	List<CategoryDto> categories = this.categoryService.getCategories();
		
		return ResponseEntity.ok(categories);
	}

}
