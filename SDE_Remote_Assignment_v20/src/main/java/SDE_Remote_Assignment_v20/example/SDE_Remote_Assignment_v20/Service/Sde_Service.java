package SDE_Remote_Assignment_v20.example.SDE_Remote_Assignment_v20.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SDE_Remote_Assignment_v20.example.SDE_Remote_Assignment_v20.Bean.CardDao;
import SDE_Remote_Assignment_v20.example.SDE_Remote_Assignment_v20.Bean.Card;

@Service
public class Sde_Service {

	private Pattern reg;
	private List<String> cards = new ArrayList<>();

	@Autowired
	private CardDao cardDao;

	public String getCardNo(String card_no) {

		String[] args = card_no.split("\\s+");
		String card = "";

		for (String ag : args)
			card = card + ag;

		return card;
	}

	public boolean checkType(String card) {

		reg = Pattern.compile("^5[1-5][0-9]{14}$");
		if (card.startsWith("4") || reg.matcher(card).matches())
			return true;

		return false;
	}

	public boolean checkExpiry(String expiry_month, String input) throws ParseException {

		reg = Pattern.compile("1[0-2]|0[1-9]");

		if (reg.matcher(expiry_month).matches()) {
			// Expiry Logic taken from Google
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
			simpleDateFormat.setLenient(false);
			Date expiry = simpleDateFormat.parse(input);
			boolean expired = expiry.before(new Date());

			if (expired != true) {
				return true;
			}

		}

		return false;
	}

	public boolean isBlackListed(String card) {

		if (cards.contains(card))
			return true;

		return false;
	}

	public void addBlacklists(String card) {
		cards.add(getCardNo(card.trim()));

	}

	public boolean getLuhn(String card) {

		char arr[] = card.toCharArray();
		int  sum = 0, counter = 0;
		boolean flag = false;

		for (int i = arr.length - 1; i >= 0; i--) {
			int num = Integer.parseInt(Character.toString(arr[i]));

			if (counter % 2 == 0) {
				sum = sum + num;
			} else {
				num = num * 2;
				int rem = 0;

				if (num >= 10) {
					rem = num % 10;
					num = num / 10;
				}

				sum = sum + num + rem;
			}

			counter++;
		}

		int rem = sum % 10;
		System.out.println("Luhn reminder : " + rem);

		if (rem == 0)
			flag = true;

		return flag;
	}


}
