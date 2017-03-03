package com.srav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.srav.dao.Dao;
import com.srav.pojo.Pojo;
@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	Dao dao;
	 @RequestMapping("/")
		public ModelAndView display(){
		 ModelAndView modelAndView=new ModelAndView();
		 modelAndView.addObject("msg", "HEllo");
		 modelAndView.setViewName("index");
			return modelAndView;
		}
	 @RequestMapping("/index")
		public ModelAndView display1(){
		 ModelAndView modelAndView=new ModelAndView("index");
		 modelAndView.addObject("msg", "Welcome");
			return modelAndView;
		}
	 @RequestMapping("/empform")
	 public ModelAndView form(){
		return new ModelAndView("empform","command",new Pojo());	 
	 }	 
	 @RequestMapping(value="/save",method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("pojo") Pojo pojo){
		 dao.save(pojo);
		 return new ModelAndView("sucess");
	 }
	 @RequestMapping("/viewemp")
	 public ModelAndView view(){
		 List<Pojo>list=dao.getDetails();
		return new ModelAndView("viewemp","list",list);
	 }
	 @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable int id){
		 dao.delete(id);
		 return new ModelAndView("sucess");
	 }
	 @RequestMapping(value="/edit/{id}")
	 public ModelAndView edit(@PathVariable int id){
		 Pojo pojo=dao.getById(id);
		 return new ModelAndView("ting","command",pojo);
	 }
	 @RequestMapping(value="/update",method=RequestMethod.POST)
	 public ModelAndView update(@ModelAttribute("pojo") Pojo pojo){
		 dao.update(pojo);
		return new ModelAndView("sucess");
	 }
	 @RequestMapping("/viewbyid")
	 public ModelAndView viewbyid(){
		 List<Pojo>list=dao.getDetails();
			return new ModelAndView("viewemp","list",list); 
	 }
	 @RequestMapping(value="/search/{id}",method=RequestMethod.POST)
	 public ModelAndView search(@PathVariable int id){
		 dao.search(id);
		return new ModelAndView("viewdatabyid");
	 }	 
}