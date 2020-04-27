package uk.co.breschbrothers.fencingcalc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uk.co.breschbrothers.fencingcalc.entity.*;
import uk.co.breschbrothers.fencingcalc.repositories.AnotherRepository;
import uk.co.breschbrothers.fencingcalc.repositories.FencyRepository;
import uk.co.breschbrothers.fencingcalc.repositories.RailRepository;
import uk.co.breschbrothers.fencingcalc.pojos.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CalculatorController {

    private final FencyRepository fencyRepository;
    private final RailRepository railRepository;
    private final AnotherRepository anotherRepository;


    @Autowired
    public CalculatorController(FencyRepository fencyRepository, RailRepository railRepository, AnotherRepository anotherRepository) {
        this.fencyRepository = fencyRepository;
        this.railRepository = railRepository;
        this.anotherRepository = anotherRepository;
    }

    @GetMapping("/calculator")
    public String calculator(Model model) {
        List<Fency> fencyList = fencyRepository.findAll();
        model.addAttribute("fencyList", fencyList);
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calcForm (@RequestParam String fencyList, @RequestParam String fenceLength, Model model) {
        Optional<Fency> fencyOptional = fencyRepository.findById(Long.parseLong(fencyList));
        Fency fency = fencyOptional.get();
        Post post = fency.getPost();
        Rail rail = railRepository.findById((long) 1).get();
        Another nails = anotherRepository.findById((long) 1).get();
        Another job = anotherRepository.findById((long) 2).get();
        Another postcrete = anotherRepository.findById((long) 3).get();

        List<Item> itemList = new ArrayList<>();

        addItemToList(fency, itemList, fenceLength);
        addItemToList(post, itemList, fenceLength);
        addItemToList(rail, itemList, fenceLength);

        itemList.add(new Item("Nails", nails.getType(), 1, nails.getPrice(), nails.getPrice()));
        itemList.add(new Item("Job", job.getType(), 1, job.getPrice(), job.getPrice() * Double.parseDouble(fenceLength)));

        int postcreteQuantity = (int) (Double.parseDouble(fenceLength) * 1.1) + 1;
        itemList.add(new Item("Postcrete", postcrete.getType(), postcreteQuantity, postcrete.getPrice(), postcrete.getPrice() * postcreteQuantity));

        model.addAttribute("itemList", itemList);
        return "result";
    }

    private void addItemToList (EntityBase entityBase, List<Item> itemList, String length) {
        double lengthInMeter = Double.parseDouble(length);

        Item item = new Item();
        item.setType(entityBase.getType());
        item.setPriceForEach(entityBase.getPricePerPiece());
        int quantity;

        if (entityBase instanceof Fency) {
            item.setDescription("Boards");
            quantity = (int) (lengthInMeter * 1000 / (entityBase.getWidth() + 15)) + 1;
        } else if (entityBase instanceof Post) {
            item.setDescription("Posts");
            quantity = (int) (lengthInMeter * 0.6 + 1);
        } else {
            item.setDescription("Rails");
            quantity = (int) lengthInMeter;
        }

        item.setQuantity(quantity);
        item.setTotalPrice();

        itemList.add(item);

    }


}
