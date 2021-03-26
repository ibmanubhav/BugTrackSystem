package com.example.bts.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bts.entity.Bug;
import com.example.bts.repo.BugRepository;

@Service
public class BugServices {
	@Autowired
	BugRepository bugRepository;

	public String createBug(Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		return savedBug.getId();
	}
	
	
	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}


	public void updateBug(Bug bug) {
		bugRepository.save(bug);
	}

	public void deleteBug(String bugId) {
		bugRepository.deleteById(bugId);
		;
	}

	public Optional<Bug> getOrder(String bugId) {
		return bugRepository.findById(bugId);
	}

}
