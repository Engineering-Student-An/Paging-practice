package study.pagingpractice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchForm {
    private String name;
    private Integer startSal;
    private Integer endSal;

    public SearchForm() {
        this.startSal=0;
        this.endSal=99999;
    }
}
