package com.codingdojo.DojoOverflow.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.DojoOverflow.models.Answer;
import com.codingdojo.DojoOverflow.models.LoginUser;
import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.models.QuestionsTags;
import com.codingdojo.DojoOverflow.models.Tag;
import com.codingdojo.DojoOverflow.models.User;
import com.codingdojo.DojoOverflow.services.AnswerService;
import com.codingdojo.DojoOverflow.services.QuestionService;
import com.codingdojo.DojoOverflow.services.QuestionTagService;
import com.codingdojo.DojoOverflow.services.TagService;
import com.codingdojo.DojoOverflow.services.UserService;


@Controller
public class HomeController {
	private final UserService userSer;
	private final QuestionService quesSer;
	private final AnswerService ansSer;
	private final TagService tagSer;
	private final QuestionTagService quesTagSer;
	
	
	public HomeController(TagService tagSer,UserService userSer,QuestionService quesSer,AnswerService ansSer,QuestionTagService quesTagSer) {
		this.userSer = userSer;
		this.quesSer = quesSer;
		this.ansSer = ansSer;
		this.quesTagSer = quesTagSer;
		this.tagSer = tagSer;
	}
	
	// ================================ GENERAL ================================ 
		@GetMapping("/")
		public String index(Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				return "dashboard.jsp";
			}else {
				model.addAttribute("newUser", new User());
				model.addAttribute("newLogin", new LoginUser());
				return "index.jsp";
			}	
		}
		
		@GetMapping("/dashboard")
		public String dashboard(Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				Long loggedID = (Long) session.getAttribute("user_id");
				User userName = userSer.oneUser(loggedID);
				List<Question> questions = quesSer.allQuestions();
				model.addAttribute("questions",questions);
				model.addAttribute("logged",userName);
				return "dashboard.jsp";
			}else {
				return "redirect:/";
			}
		}
		
		// ================================ LOGIN / REGISTRATION ================================
			@PostMapping("/api/register")
			public String register(@Valid @ModelAttribute("newUser") User newUser, 
		            BindingResult result, Model model, HttpSession session) {
				
					userSer.register(newUser, result);
				
				if(result.hasErrors()) {
					model.addAttribute("newLogin", new LoginUser());
					return "index.jsp";
				}
				
				session.setAttribute("user_id", newUser.getId());
				return "redirect:/dashboard";
			}
			
			@PostMapping("/api/login")
			public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
		            BindingResult result, Model model, HttpSession session) {
				User user = userSer.login(newLogin, result);
				if(result.hasErrors()) {
					model.addAttribute("newUser", new User());
					return "index.jsp";
				}
				
				session.setAttribute("user_id", user.getId());
				return "redirect:/dashboard";
			}
			
			@GetMapping("/logout")
			public String dashboard(HttpSession session) {
				session.invalidate();
				return "redirect:/";
			}
	
	// ====================== QUESTION ======================
	@GetMapping("/add/question")
	public String addQuestion(Model model, HttpSession session,@ModelAttribute("question") Question question,RedirectAttributes redirectAttributes) {
		Long loggedID = (Long) session.getAttribute("user_id");
		User userName = userSer.oneUser(loggedID);

		model.addAttribute("logged",userName);
		return "addQuestion.jsp";
	}
	
	
	
	// ====================== QUESTION / TAG  ======================
	@PostMapping("/api/add/question")
	public String addQuestionForm(Model model,HttpSession session,@Valid @ModelAttribute("question") Question question,BindingResult result,@RequestParam("tag")String tag,RedirectAttributes redirectAttributes) {
		
		// how to not add duplicates?
		if(tag.isEmpty()) {
			redirectAttributes.addFlashAttribute("error", "Please add a tag, no more than 3");
			return "redirect:/add/question";
		}
		int count = 0;
		for(int i = 1; i < tag.length(); i++) {
			if (tag.charAt(i) == ',') {
		        count++;
		    }
		}
		
		if(count > 2) {
			redirectAttributes.addFlashAttribute("error", "Only 3 tags please!");
			return "redirect:/add/question";
		} 
		
		Question newQuestion = quesSer.createQuestion(question);
		
		if(tag.contains(",")) {
			String[] res = tag.split("[,]", 0);
			for(String myStr: res) {		
				Tag createTag = tagSer.getTagExsist(myStr.toLowerCase());
				quesTagSer.createQuesTag(new QuestionsTags(newQuestion,createTag));	
			}
		}else {
			Tag createTag = tagSer.getTagExsist(tag.toLowerCase());
			quesTagSer.createQuesTag(new QuestionsTags(newQuestion,createTag));	
			System.out.println(createTag.getSubject());
		}
		return "redirect:/dashboard";	
	}
	
	// ====================== ANSWERS ======================
	@GetMapping("/answer/{id}")
	public String addAnswer(Model model, @PathVariable("id")Long id,@ModelAttribute("answer") Answer answer) {
		Question question = quesSer.singleQuestion(id);
		List<Tag> tags = tagSer.findAllTags(question);
		model.addAttribute("question", question);
		model.addAttribute("tags",tags);
		return "addAnswer.jsp";
	}
	
	@PostMapping("/api/add/answer")
	public String addAnswer(Model model,@Valid @ModelAttribute("answer") Answer answer,BindingResult result) {
		
		
		if(result.hasErrors()) {	
			return "addAnswer.jsp";
		}else {
			ansSer.createAnswer(answer);
			return "redirect:/dashboard";
		}	
		
	}
}
