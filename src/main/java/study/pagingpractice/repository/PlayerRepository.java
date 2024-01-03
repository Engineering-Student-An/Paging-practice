package study.pagingpractice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import study.pagingpractice.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Page<Player> findPlayersBySalaryBetween(Integer startSal, Integer endSal, Pageable pageable);

    Page<Player> findPlayersByNameContainingAndSalaryBetween(String name, Integer startSal, Integer endSal, Pageable pageable);
}
