package study.pagingpractice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import study.pagingpractice.domain.Player;
import study.pagingpractice.repository.PlayerRepository;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;


    // 연봉은 초기값이 시작:0, 끝:9999로 설정되어 있으므로
    // findAll => 모든 선수 찾기
    public Page<Player> findAll(Integer startSal, Integer endSal, Pageable pageable){
        return playerRepository.findPlayersBySalaryBetween(startSal, endSal, pageable);
    }

    // findPlayersByName => 이름으로 선수 찾기
    public Page<Player> findPlayersByName(String name, Integer startSal, Integer endSal, Pageable pageable) {
        return playerRepository.findPlayersByNameContainingAndSalaryBetween(name, startSal, endSal, pageable);
    }
}
