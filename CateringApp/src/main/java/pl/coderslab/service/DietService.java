package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Diet;
import pl.coderslab.model.Order;
import pl.coderslab.repository.DietRepository;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class DietService {
    private final DietRepository dietRepository;

    public DietService(DietRepository dietRepository) {
        this.dietRepository = dietRepository;
    }

    public void updateDietDescription(long id, String description) {
        dietRepository.updateDescription(id, description);
    }

    public List<Diet> findAll() {
        return dietRepository.findAll();
    }


    public Double roundPlacesDouble(Double d) {
        String format = String.format("%.2f", d);
        return Double.parseDouble(format);
    }

    public Double getPrizeWholePlan(String kcal, LocalDate startDate, LocalDate expireDate, Long idDiet) {
        Optional<Diet> diet = dietRepository.findById(idDiet);
        if (diet.isPresent()) {
            switch (kcal) {
                case "1500": {
                    Order order = new Order();
                    Double dietPrice = diet.get().getPrice();
                    Long lengthOfPlan = order.calculateLengthOfPlan(startDate, expireDate);
                    Double result = roundPlacesDouble(lengthOfPlan * (dietPrice));
                    if (result > 0) {
                        return result;
                    } else {
                        return 0.0;
                    }
                }
                case "2000": {
                    Order order = new Order();
                    Double dietPrice = diet.get().getPrice();
                    Long lengthOfPlan = order.calculateLengthOfPlan(startDate, expireDate);
                    Double result = roundPlacesDouble(lengthOfPlan * (dietPrice + 2));
                    if (result > 0) {
                        return result;
                    } else {
                        return 0.0;
                    }
                }
                case "2500": {
                    Order order = new Order();
                    Double dietPrice = diet.get().getPrice();
                    Long lengthOfPlan = order.calculateLengthOfPlan(startDate, expireDate);
                    Double result = roundPlacesDouble(lengthOfPlan * (dietPrice + 4));
                    if (result > 0) {
                        return result;
                    } else {
                        return 0.0;
                    }
                }
                default: {
                    Order order = new Order();
                    Double startPrice = diet.get().getPrice();
                    Long lengthOfPlan = order.calculateLengthOfPlan(startDate, expireDate);
                    Double result = roundPlacesDouble(lengthOfPlan * (startPrice + 6));
                    if (result > 0) {
                        return result;
                    } else {
                        return 0.0;
                    }
                }
            }
        } else {
            throw new NullPointerException("Input not found");
        }
    }


    public void setDietRequestedDataToSession(Long idDiet, String kcal, LocalDate startDate, LocalDate expireDate, HttpSession session) {
        Optional<Diet> diet = dietRepository.findById(idDiet);
        if (!diet.isPresent()) {
            return;
        }
        Double prize = getPrizeWholePlan(kcal, startDate, expireDate, idDiet);
        session.setAttribute("prize", prize);
        session.setAttribute("kcal", kcal);
        session.setAttribute("startDate", startDate);
        session.setAttribute("expireDate", expireDate);
        session.setAttribute("dietName", diet.get().getDietName());
    }
}
