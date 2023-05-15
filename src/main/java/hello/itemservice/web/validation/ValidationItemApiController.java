package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/validation/api/items")
@Slf4j
public class ValidationItemApiController {
    @PostMapping("/add")
    public Object addItem(@Valid @RequestBody ItemSaveForm form, BindingResult bindingResult) {
        log.info("Controller Start");
        if (bindingResult.hasErrors()) {
            log.info("Errors = {}", bindingResult.getAllErrors());
            return bindingResult.getAllErrors();
        }
        log.info("Success, form = {}", form);
        return form;
    }
}
