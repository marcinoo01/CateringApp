package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Diet;
import pl.coderslab.model.Order;
import pl.coderslab.repository.DietRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class DietService {
    private DietRepository dietRepository;

    public DietService(DietRepository dietRepository) {
        this.dietRepository = dietRepository;
    }

    public void updateDietDescriptio(long id, String description) {
        dietRepository.updateDescription(id, description);
    }

    public List<Diet> findAll() {
        return dietRepository.findAll();
    }


    public Double roundPlacesDouble(Double d) {
        String format = String.format("%.2f", d);
        Double re = Double.parseDouble(format);
        return re;
    }

    public Double getPrizeWholePlan(String kcal, LocalDate startDate, LocalDate expireDate, Long idDiet) {
        Optional<Diet> diet = dietRepository.findById(idDiet);
        if (diet.isPresent()) {
            if (kcal.equals("1500")) {
                Order order = new Order();
                Double startPrice = diet.get().getPrice();
                Long lengthOfPlan = order.calculateLengthOfPlan(startDate, expireDate);
                Double result = roundPlacesDouble(lengthOfPlan * (startPrice));
                if (result > 0) {
                    return result;
                } else {
                    return 0.0;
                }
            } else if (kcal.equals("2000")) {
                Order order = new Order();
                Double startPrice = diet.get().getPrice();
                Long lengthOfPlan = order.calculateLengthOfPlan(startDate, expireDate);
                Double result = roundPlacesDouble(lengthOfPlan * (startPrice + 2));
                if (result > 0) {
                    return result;
                } else {
                    return 0.0;
                }
            } else if (kcal.equals("2500")) {
                Order order = new Order();
                Double startPrice = diet.get().getPrice();
                Long lengthOfPlan = order.calculateLengthOfPlan(startDate, expireDate);
                Double result = roundPlacesDouble(lengthOfPlan * (startPrice + 4));
                if (result > 0) {
                    return result;
                } else {
                    return 0.0;
                }
            } else {
                Order order = new Order();
                Double startPrice = diet.get().getPrice();
                Long lengthOfPlan = order.calculateLengthOfPlan(startDate, expireDate);
                Double result = roundPlacesDouble(lengthOfPlan * (startPrice + 8));
                if (result > 0) {
                    return result;
                } else {
                    return 0.0;
                }
            }
        } else {
            throw new NullPointerException("Input not found");
        }
    }

    public Boolean checkIfDatesAreBeforeToday(LocalDate startDate, LocalDate expireDate) {
        return startDate.isAfter(LocalDate.now()) && expireDate.isAfter(LocalDate.now());
    }


}
