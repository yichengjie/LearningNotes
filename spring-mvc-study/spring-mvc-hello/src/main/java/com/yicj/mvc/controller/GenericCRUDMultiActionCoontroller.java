package com.yicj.mvc.controller;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class GenericCRUDMultiActionCoontroller extends MultiActionController {
    public Map list(HttpServletRequest request, HttpServletResponse response){

        return null ;
    }

    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response){

        return null ;
    }

    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response,Object command){

        return  null ;
    }

}
