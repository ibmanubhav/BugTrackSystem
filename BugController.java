package com.example.bts;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.bts.entity.Bug;
import com.example.bts.services.BugServices;

@RestController
public class BugController {
	@Autowired
	BugServices bugServices;

	@PostMapping("/bug")
	String createBug(@RequestBody @Validated Bug bug, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(bug);
		return bugServices.createBug(bug);

	}

	@GetMapping("/bug")
	List<Bug> getBugs() {
		return bugServices.getBugs();
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Retry");
		}
	}

	@PutMapping("/bug/{id}")
	void updateBug(@RequestBody @Valid Bug bug, @PathVariable("id") String bugId, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(bugId);
		bug.setId(bugId);
		bugServices.updateBug(bug);
	}

	@DeleteMapping("/bug/{id}")
	void deleteBug(@PathVariable("id") String bugId) {
		System.out.println(bugId);
		bugServices.deleteBug(bugId);
	}

}
