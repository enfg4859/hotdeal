package com.springmvc.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.domain.Item;
import com.springmvc.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

	private final ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping
	@ResponseBody
	public List<Item> getAllItems(Model model) {
		return itemService.getAllItems();
	}

	@GetMapping("/{id}")
	public Item getItemById(@PathVariable("id") int id) {
		return itemService.getItemById(id);
	}

	@PostMapping
	public String createItem(@ModelAttribute Item item, @RequestParam("file") MultipartFile file,
			HttpServletRequest request) {
		if (!file.isEmpty()) {
			try {
				// 파일을 저장할 경로 설정
				String realPath = request.getSession().getServletContext().getRealPath("/resources/img/item");
				// 파일 이름을 현재 시간을 기반으로 생성
				String originalFileName = file.getOriginalFilename();
				// 파일 이름을 현재 시간을 기반으로 생성
				String fileName = String.valueOf(System.currentTimeMillis())+getFileExtension(originalFileName);
				// 파일을 저장할 경로와 파일 이름을 합침
				String filePath = realPath + File.separator + fileName;
				// 파일을 실제로 저장
				File saveFile = new File(filePath);
				file.transferTo(saveFile);

				// 파일 경로를 item에 설정
				item.setImg(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 파일이 업로드되지 않은 경우 img 필드를 null로 설정
			item.setImg(null);
		}
		// 나머지 로직은 그대로 유지됩니다.
		itemService.createItem(item);
		return "main";
	}

	@PutMapping("/{id}")
	public Item updateItem(@PathVariable("id") int id, @RequestBody Item item) {
		return itemService.updateItem(id, item);
	}

	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable("id") int id) {
		itemService.deleteItem(id);
	}
	
	// 파일 확장자를 추출하는 메서드
	private String getFileExtension(String fileName) {
	    if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
	        return fileName.substring(fileName.lastIndexOf("."));
	    } else {
	        return "";
	    }
	}
}