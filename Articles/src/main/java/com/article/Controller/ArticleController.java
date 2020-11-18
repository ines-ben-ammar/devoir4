package com.article.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.article.entities.Article;
import com.article.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService articleService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createArticle";
	}
	@RequestMapping("/saveArticle")
	public String saveArticle(@ModelAttribute("article") Article article,
	                          @RequestParam("date") String date,
	                          ModelMap modelMap) throws ParseException
	                          
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 article.setDateCreation(dateCreation);

	Article saveArticle = articleService.saveArticle(article);
	String msg ="produit enregistré avec Id "+saveArticle. getIdArticle();
	modelMap.addAttribute("msg", msg);
	return "createArticle";

}
	@RequestMapping("/ListeArticles")
	public String listeArticles(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{ 
		
		Page<Article> a = articleService.getAllArticlesParPage(page, size);
		modelMap.addAttribute("articles", a);
		 modelMap.addAttribute("pages", new int[a.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

	return "listeArticles";
	}
	@RequestMapping("/supprimerArticle")
	public String supprimerArticle(@RequestParam("id") Long id,
	                     ModelMap modelMap,
	                     @RequestParam (name="page",defaultValue = "0") int page,
	                     @RequestParam (name="size", defaultValue = "2") int size)
	{
	articleService.deleteArticleById(id);
	Page<Article> a = articleService.getAllArticlesParPage(page,
			size);
			modelMap.addAttribute("articles", a);
			modelMap.addAttribute("pages", new int[a.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
	return "listeArticles";
	}
	@RequestMapping("/modifierArticle")
	public String editerArticle(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Article a= articleService.getArticle(id);
	modelMap.addAttribute("article", a);
	return "EditerArticle";
	}
	@RequestMapping("/updateArticle")
	public String updateArticle(@ModelAttribute("article") Article article,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 article.setDateCreation(dateCreation);

	 articleService.updateArticle(article);
	 List<Article> a = articleService.getAllArticles();
	 modelMap.addAttribute("articles", a);
	return "listeArticles";
}
}
