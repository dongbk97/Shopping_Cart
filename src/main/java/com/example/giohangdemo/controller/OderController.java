package com.example.giohangdemo.controller;

import com.example.giohangdemo.domain.Oder;
import com.example.giohangdemo.domain.User;
import com.example.giohangdemo.repository.IUserRepository;
import com.example.giohangdemo.service.OderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
public class OderController {
    @Autowired
    private OderService oderService;
    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping("/oder")
    public String oder(@RequestParam("id") int id, HttpSession http, Model model, RedirectAttributes redirectAttrs) {
        oderService.addCart(http, id);

        HashMap<Integer, Oder> productMap = (HashMap<Integer, Oder>) http.getAttribute("cart");
        productMap.forEach((key, value) ->
                log.info(value.getProduct().getName())
        );

//        redirectAttrs.addFlashAttribute("productMap", productMap);
        return "redirect:/display";
    }

    @GetMapping("/oder2")
    public String saveOder(HttpSession http) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            log.info(" Đã đăng nhập vs User: " + currentUserName);
            User user = iUserRepository.findByUsername(currentUserName);
            log.info("id user: " + user.getId());
            oderService.saveCart(http, user);
            return "redirect:/display";
        } else
            log.info("Chưa đăng nhập" + authentication.getName());
        return "redirect:/login";
    }

    @GetMapping("/display-oder")
    public String displayOder(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            List<Oder> listoder = oderService.displayCart(currentUserName);


//            listoder.stream().forEach(x->{
//
//                log.info(x.getProduct().getName());
//
//            });
            model.addAttribute("listoder", listoder);
            model.addAttribute("username", currentUserName);
            return "odercart";
        }
        return "error";
    }
}
