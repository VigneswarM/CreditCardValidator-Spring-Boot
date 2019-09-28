package SDE_Remote_Assignment_v20.example.SDE_Remote_Assignment_v20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import SDE_Remote_Assignment_v20.example.SDE_Remote_Assignment_v20.Bean.Card;
import SDE_Remote_Assignment_v20.example.SDE_Remote_Assignment_v20.Service.Sde_Service;


@RestController
@RequestMapping("/SDE")
public class Sde_controller {

	@Autowired
	private Sde_Service sde_Service;

	
	@ResponseBody
	@RequestMapping(value = "/ValidateCard", method = RequestMethod.POST)
	public String Validate(@RequestParam String card_no, @RequestParam String card_holder, @RequestParam String expiry)
			throws Exception {

		String[] arg = expiry.split("/");
		String expiry_month = arg[0];
		String expiry_year = arg[1];
		String card = sde_Service.getCardNo(card_no.trim());

		System.out.println(card + " " + card_holder + " " + arg[0] + " " + arg[1]);

		// Add Backlists cards
		sde_Service.addBlacklists("4788 3845 3855 2446");
		sde_Service.addBlacklists("5144 3854 3852 3845");

		// check blacklisted
		if (sde_Service.isBlackListed(card))
			return "Validation Failed : Card Black Listed";

		// Check card Length
		if (card.length() != 16)
			return "Validation Failed :- Invalid Card : All Card Numbers should have 16 digits";

		// Check master or visa card
		if (!sde_Service.checkType(card))
			return "Validation Failed :- Invalid Card : Card should be VISA or MASTER card type ";

		// Check card expiry
		if (!sde_Service.checkExpiry(expiry_month, expiry))
			return "Validation Failed :- Invalid Expiry Month/Year or Card already Expired ";

		// Check Luhn formula
		if (!sde_Service.getLuhn(card))
			return "Validation Failed : Luhn formula is not Satisfied";

		
		return "Validation Success";

	}

}
