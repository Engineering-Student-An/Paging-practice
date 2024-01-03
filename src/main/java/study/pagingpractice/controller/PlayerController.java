package study.pagingpractice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import study.pagingpractice.domain.Player;
import study.pagingpractice.domain.SearchForm;
import study.pagingpractice.service.PlayerService;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("")
    public String home(@RequestParam(required = false, defaultValue = "1") int page,
                        @ModelAttribute SearchForm searchForm,
                        Model model){



        if(searchForm.getStartSal() > searchForm.getEndSal()){
            model.addAttribute("errorMessage", "검색할 수 없는 범위 입니다.");
            model.addAttribute("nextUrl", "/");
            return "/error";
        }

        // PageRequest.of(페이지 번호, 페이지 사이즈, 정렬 기준)
        PageRequest pageRequest = PageRequest.of(page-1, 5, Sort.by("salary").descending());

        if(searchForm.getName() == null){
            searchForm.setName("");
        }
        Page<Player> players = playerService.findPlayersByName(searchForm.getName(), searchForm.getStartSal(), searchForm.getEndSal(), pageRequest);

        model.addAttribute("players", players);
        model.addAttribute("searchForm", searchForm);

        return "/home";
    }

}
