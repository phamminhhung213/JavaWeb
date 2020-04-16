package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @RequestMapping("worldclock")
    public String getTimeByTimeZone(Model model, @RequestParam(name ="city",required = false,defaultValue = "Asian/Ho_Chi_Minh")String city){
        Date date = new Date();
// Get timezone by the local
        TimeZone local = TimeZone.getDefault();
// Get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(city);
        // Calculate the current time in the specified city
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
// Reset the date by locale_time
        date.setTime(locale_time);

// Set the data sent to the view
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "worldclock";

    }

}