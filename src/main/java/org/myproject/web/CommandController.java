package org.myproject.web;

import java.util.List;

import org.myproject.entity.Command;
import org.myproject.page.Page;
import org.myproject.service.ModificationService;
import org.myproject.service.QueryService;
import org.myproject.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping // 第一级路径为空
public class CommandController {
	@Autowired
	private ModificationService modificationService;
	@Autowired
	private QueryService queryService;

	/**
	 * 查询全部命令
	 * 
	 * @param model
	 * @return
	 */
	@Token(save=true)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		int totalCount = queryService.queryCommandCount(null, null);
		Page page = new Page(totalCount, 1, 5);
		List<Command> list = queryService.queryCommandsByPage(null, null,page.getOffsetIndex(),page.getQueryNumber());
		model.addAttribute("commandList", list);
		model.addAttribute("page",page);
		return "list";
	}

	/**
	 * 查询符合条件的命令
	 * 
	 * @param commandName
	 * @param description
	 * @param model
	 * @return
	 */
	@Token(save=true)
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String getList(@RequestParam("commandName") String commandName,
		@RequestParam("description") String description, Model model) {
		int totalCount = queryService.queryCommandCount(null, null);
		Page page = new Page(totalCount, 1, 5);
		List<Command> list = queryService.queryCommandsByPage(commandName, description,page.getOffsetIndex(),page.getQueryNumber());
		model.addAttribute("commandList", list);
		model.addAttribute("commandName", commandName);
		model.addAttribute("description", description);
		model.addAttribute("page",page);
		return "list";
	}
	@Token(save=true)
	@RequestMapping(value = "/{totalCount}/page{currentPage}", method = RequestMethod.GET)
	public String page(String commandName,String description,@PathVariable int totalCount,@PathVariable int currentPage,Model model) {
		Page page = new Page(totalCount, currentPage, 5);
		List<Command> list = queryService.queryCommandsByPage(commandName, description,page.getOffsetIndex(),page.getQueryNumber());
		model.addAttribute("commandList", list);
		model.addAttribute("commandName", commandName);
		model.addAttribute("description", description);
		model.addAttribute("page",page);
		return "list";
	}
	/**
	 * 新增一条命令
	 * 
	 * @param name
	 * @param description
	 * @param model
	 * @return
	 */
	@Token(remove=true)
	@RequestMapping(value = "/command/addition", method = RequestMethod.POST)
	public String addOneCommand(String addName, String addDescription, Model model) {
		modificationService.addOneCommand(addName, addDescription);
		return list(model);
	}
	/**
	 * 删除一条命令及其包含的全部内容
	 * @param commandId
	 * @param model
	 * @return
	 */
	@Token(remove=true)
	@RequestMapping(value = "/command/deletion", method = RequestMethod.POST)
	public String deleteOneCommand(@RequestParam("commandId") String commandId, Model model) {
		modificationService.deleteOneCommand(commandId);
		return list(model);
	}
	/**
	 * 批量删除命令及其包含的所有内容
	 * @param commandIdList
	 * @param model
	 * @return
	 */
	@Token(remove=true)
	@RequestMapping(value = "/command/multideletion", method = RequestMethod.POST)
	public String deleteCommands(@RequestParam("ids") String[] commandIds, Model model) {
		modificationService.deleteCommands(commandIds);
		return list(model);
	}
	/**
	 *更新一条命令的名称和描述
	 * @param commandId
	 * @param updateName
	 * @param updateDescription
	 * @param model
	 * @return
	 */
	@Token(remove=true)
	@RequestMapping(value = "/command/update", method = RequestMethod.POST)
	public String updateOneCommand(@RequestParam("updateId") String commandId,@RequestParam String updateName,@RequestParam String updateDescription, Model model) {
		modificationService.updateCommand(commandId, updateName, updateDescription);
		return list(model);
	}
	/**
	 * 查询所选命令的内容
	 * 
	 * @param commandId
	 * @param model
	 * @return
	 */
	@Token(save=true)
	@RequestMapping(value = "/{commandId}/content", method = RequestMethod.GET)
	public String content(@PathVariable("commandId") String commandId, Model model) {
		Command command = queryService.queryContents(commandId);
		model.addAttribute("commandId",commandId);
		model.addAttribute("command", command.getName());
		model.addAttribute("contentList", command.getContentList());
		return "content";
	}
	/**
	 * 新增一条内容
	 * @param commandId
	 * @param newContent
	 * @param model
	 * @return
	 */
	@Token(remove=true)
	@RequestMapping(value = "/content/addition", method = RequestMethod.POST)
	public String addOneContent(String commandId,String newContent, Model model) {
		modificationService.addOneContent(newContent, commandId);
		return content(commandId,model);
	}
	/**
	 * 删除一条内容
	 * @param commandId
	 * @param contentId
	 * @param model
	 * @return
	 */
	@Token(remove=true)
	@RequestMapping(value = "/content/deletion", method = RequestMethod.POST)
	public String deleteOneContent(@RequestParam("commandId") String commandId,String contentId, Model model) {
		modificationService.deleteContent(contentId);;
		return content(commandId,model);
	}
	/**
	 * 批量删除内容
	 * @param commandId
	 * @param contentIdList
	 * @param model
	 * @return
	 */
	@Token(remove=true)
	@RequestMapping(value = "/content/multideletion", method = RequestMethod.POST)
	public String deleteOneContent(@RequestParam("commandId") String commandId,@RequestParam("ids")String[] contentIds, Model model) {
		modificationService.deleteContents(contentIds);
		return content(commandId,model);
	}
	/**
	 * 更新一条内容
	 * @param contentId
	 * @param commandId
	 * @param updateContent
	 * @param model
	 * @return
	 */
	@Token(remove=true)
	@RequestMapping(value = "/content/update", method = RequestMethod.POST)
	public String updateOneContent(@RequestParam("updateId") String contentId,String commandId,@RequestParam String updateContent, Model model) {
		modificationService.updateContent(contentId, commandId, updateContent);
		return content(commandId,model);
	}
	/**
	 * 进入聊天界面
	 * @return
	 */
	@RequestMapping("/init/talk")
	public String initTalk(){
		return "talk";
	}
	/**
	 * 聊天界面信息传递
	 * @param content
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/talk", method = RequestMethod.POST, produces = {
	"application/json;charset=utf-8" })
	@ResponseBody
	public String talk(@RequestParam("content")String content,Model model){
		return queryService.queryByCommandName(content);
	}
	/**
	 * 进入图灵机器人聊天界面
	 * @return
	 */
	@RequestMapping("/turing/talk")
	public String turingTalk(){
		return "turing-talk";
	}
}
