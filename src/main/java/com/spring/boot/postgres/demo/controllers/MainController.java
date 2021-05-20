package com.spring.boot.postgres.demo.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.postgres.demo.beans.OrdersBean;
import com.spring.boot.postgres.demo.services.OrdersSercices;
import com.spring.boot.postgres.demo.services.PersonSercices;

@RestController
public class MainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Autowired
	PersonSercices personSercices;

	@Autowired
	OrdersSercices ordersServices;

	@Autowired
	private Environment environment;

	/**
	 * 
	 * @param httpRequest
	 * @param apiRequest
	 * @return
	 * @throws BackendException
	 * @throws IOException
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 */
	@CrossOrigin("http://localhost:8080")
	@PostMapping(value = "/save", consumes = { "application/json" })
	public @ResponseBody String checkout(HttpServletRequest httpRequest, @RequestBody Object object)
			throws IOException, NoSuchAlgorithmException, NoSuchProviderException {

		List<OrdersBean> responseList = ordersServices.getAllOrders();

		System.out.println("Active profiles: " + Arrays.toString(environment.getActiveProfiles()));

//		for (int i = 0; i < 1000000000; i++) {
//			LOGGER.info("Saving.............");
//			Person p = new Person();
//			p.setAddress("Amman" + i);
//			p.setName("Azzeh" + i);
//			personSercices.savePerson(p);
//
//			Orders orders = new Orders();
//			orders.setOrderDescription("Items List" + i);
//			orders.setOrderName("AMM" + i);
//			Person p2 = new Person();
//			p2.setId(1);
//			orders.setPersonId(p2);
//
//			ordersServices.saveOrder(orders);
//			LOGGER.info("Saved.............");
//		}

		return "Ok";

	}

	/**
	 * 
	 * @param exception
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler({ IOException.class, NoSuchAlgorithmException.class, NoSuchProviderException.class,
			Exception.class })
	public @ResponseBody String handleBackendException() throws IOException {
		LOGGER.error("Exception While Processing your Request {}");
		return "Ok";

	}

}
